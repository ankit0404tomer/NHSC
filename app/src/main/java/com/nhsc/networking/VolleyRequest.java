package com.nhsc.networking;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Puneet on 27/09/15.
 */
public class VolleyRequest extends JsonRequest<JSONObject> {

    private Response.Listener<JSONObject> listener;
    private Map<String, String> params;
    private boolean cacheEnabled;
    private long softCacheExpiryTimeLimit, hardCacheExpiryTimeLimit;
    private HashMap<String, String> headers;
    private Priority priority;

    public VolleyRequest(int method, String url, JSONObject jsonObject, Response.Listener<JSONObject> listener,
                         Response.ErrorListener errorListener) {
        super(method, url, jsonObject.toString(), listener, errorListener);
        this.listener = listener;
        setPriority(url);
        Log.d("ANKIT ", "Request URL :: " + url);
        Log.d("ANKIT ", "Request Body :: " + jsonObject.toString());

    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (headers == null) {
            headers = new HashMap<>();
        }
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    protected Map<String, String> getParams()
            throws AuthFailureError {
        return params;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            Log.d("ANKIT ", "Headers :: " + headers);
            String charSet = "UTF-8";//HttpHeaderParser.parseCharset(response.headers);
            String jsonString = new String(response.data,
                    charSet);
            Cache.Entry cacheEntry;

            //Checking weather object type is Array or Object
            Object json = new JSONTokener(jsonString).nextValue();

            if (json instanceof JSONArray) {
                JSONArray jsonResponseArray = new JSONArray(jsonString);
                jsonString = jsonResponseArray.getJSONObject(0).toString();
            }

            if (cacheEnabled) {
                cacheEntry = parseIgnoreCacheHeaders(response);
            } else {
                cacheEntry = null;//HttpHeaderParser.parseCacheHeaders(response);
            }
            if (jsonString.length() == 0 && (response.statusCode == 200 || response.statusCode == 201 || response.statusCode == 203 || response.statusCode == 204)) {

                Log.d("ANKIT ", "Response Success :: " + jsonString);
                return Response.success(new JSONObject(), cacheEntry);
            } else {

                Log.d("ANKIT ", "Response Success :: " + jsonString);
                return Response.success(new JSONObject(jsonString), cacheEntry);
            }
        } catch (UnsupportedEncodingException e) {
            Log.d("ANKIT ", "Response Failed :: " + e);
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            Log.d("ANKIT ", "Response Failed :: " + je);
            return Response.error(new ParseError(je));
        }
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    private void setPriority(String url) {
        this.priority = Priority.IMMEDIATE;
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        listener.onResponse(response);
    }

    /**
     * Extracts a {@link Cache.Entry} from a {@link NetworkResponse}.
     * Cache-control headers are ignored. SoftTtl == 24 mins, ttl == 24 hours.
     *
     * @param response The network response to parse headers from
     * @return a cache entry for the given response, or null if the response is not cacheable.
     */
    public Cache.Entry parseIgnoreCacheHeaders(NetworkResponse response) {
        long now = System.currentTimeMillis();

        Map<String, String> headers = response.headers;
        long serverDate = 0;
        String serverEtag = null;
        String headerValue;

        headerValue = headers.get("Date");
        if (headerValue != null) {
            serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
        }

        serverEtag = headers.get("ETag");

        final long cacheHitButRefreshed = getSoftCacheExpiryTimeLimit(); // in 3 minutes cache will be hit, but also refreshed on background
        final long cacheExpired = getHardCacheExpiryTimeLimit(); // in 24 hours this cache entry expires completely
        final long softExpire = now + cacheHitButRefreshed;
        final long ttl = now + cacheExpired;

        Cache.Entry entry = new Cache.Entry();
        entry.data = response.data;
        entry.etag = serverEtag;
        entry.softTtl = softExpire;
        entry.ttl = ttl;
        entry.serverDate = serverDate;
        entry.responseHeaders = headers;

        return entry;
    }

    public boolean isCacheEnabled() {
        return cacheEnabled;
    }

    public void setCacheEnabled(boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
        this.setShouldCache(cacheEnabled);
    }

    public long getHardCacheExpiryTimeLimit() {
        return hardCacheExpiryTimeLimit;
    }

    public void setHardCacheExpiryTimeLimit(long hardCacheExpiryTimeLimit) {
        this.hardCacheExpiryTimeLimit = hardCacheExpiryTimeLimit;
    }

    public long getSoftCacheExpiryTimeLimit() {
        return softCacheExpiryTimeLimit;
    }

    public void setSoftCacheExpiryTimeLimit(long softCacheExpiryTimeLimit) {
        this.softCacheExpiryTimeLimit = softCacheExpiryTimeLimit;
    }

    public Response.Listener<JSONObject> getListener() {
        return listener;
    }
}
