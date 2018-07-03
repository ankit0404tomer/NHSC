package com.nhsc.networking;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Simple RestClient wrapper for Volley + OKHttp
 * Created by ANKIT on 27/09/16.
 */
public abstract class VolleyRestClient {

    public String mDateFormat = "yyyy-MM-dd HH:mm:ss";

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private Context mCtx;
    private CookieManager mCookieManager;

    /**
     * Initialize a new RestClient.
     * Sets the server date format to "yyyy-MM-dd HH:mm:ss"
     * Uses default useragent.
     *
     * @param applicationContext Application Context
     */
    public VolleyRestClient(Context applicationContext) {
        this(applicationContext, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Initialize a new RestClient
     *
     * @param applicationContext Application Context
     * @param dateFormat         date format to be used
     */
    public VolleyRestClient(Context applicationContext, String dateFormat) {
        mCtx = applicationContext;
        mRequestQueue = getRequestQueue();
        mDateFormat = dateFormat;
        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
        mCookieManager = new CookieManager();
        CookieHandler.setDefault(mCookieManager);
    }

    public CookieManager getCookieManager() {
        return mCookieManager;
    }

    /**
     * Get the application context
     *
     * @return
     */
    public Context getApplicationContext() {
        return mCtx;
    }

    /**
     * Get the current request queue
     *
     * @return Volley's RequestQueue
     */
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext(), getHttpStack());
        }
        return mRequestQueue;
    }

    /**
     * Cancel all ongoing requests with a particular tag.
     *
     * @param tag
     */
    public void cancelAll(String tag) {
        mRequestQueue.cancelAll(tag);
    }

    /**
     * Get an ImageLoader for NetworkImageView
     *
     * @return Volley's ImageLoader
     */
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    /**
     * Clear cache for a particular URL
     *
     * @param url
     */
    public void clearCache(String url) {
        mRequestQueue.getCache().remove(url);
    }

    /**
     * Clear all cache
     */
    public void clearCache() {
        mRequestQueue.getCache().clear();
    }

    /**
     * Builds and returns a GET URL for an endpoint and its params
     *
     * @param endpoint
     * @param params
     * @return
     */
    public String buildGetUrl(String endpoint, HashMap<String, String> params) {
        Uri.Builder builder = Uri.parse(endpoint).buildUpon();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder.build().toString();
    }

    /**
     * Helper function to get the context's versionName
     *
     * @return Value in build.gradle's versionName field
     */
    public String getAppVersion() {
        PackageManager manager = mCtx.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(mCtx.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String versionName = (info != null) ? info.versionName : null;
        if (versionName != null) {
            try {
                return URLEncoder.encode(versionName, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * Convert Date to a server friendly date string
     *
     * @param date
     * @return String
     */
    public String getServerFriendlyDateString(Date date) {
        SimpleDateFormat serverDateFormat = new SimpleDateFormat(mDateFormat);
        serverDateFormat.setLenient(false);
        return serverDateFormat.format(date);
    }

    /**
     * Converts a string into a server friendly date string
     *
     * @param dateStr String
     * @param format  format of dateStr
     * @return String
     */
    public String getServerFriendlyDateString(String dateStr, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            Date date = dateFormat.parse(dateStr);

            return getServerFriendlyDateString(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Parses a date string returned by the server.
     *
     * @param dateStr
     * @return String
     */
    public Date parseServerDateString(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(mDateFormat);
            dateFormat.setLenient(false);
            Date date = dateFormat.parse(dateStr);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Make a GET API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param headers          params to add to the header
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void getDontCache(String endpoint, HashMap<String, String> headers, HashMap<String, String> params, String tag,
                             VolleyResponseListener<?, JSONObject> responseListener) {
        if (params == null) {
            params = new HashMap<String, String>();
        }
        VolleyRequest request = new VolleyRequest(Request.Method.GET, buildGetUrl(endpoint, params), new JSONObject(), responseListener, responseListener);
        request.setCacheEnabled(false);
        basicRequestSetup(request, tag, headers);
        addRequestToQueue(request);
    }

    /**
     * Make a GET API call to the base url.
     * The cache policy for this call is set by:
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param headers          params to add to the header
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     * @see VolleyRestClient#setCachePolicy(VolleyRequest)
     */
    public void get(String endpoint, HashMap<String, String> headers, HashMap<String, String> params, String tag,
                    VolleyResponseListener<?, JSONObject> responseListener) {
        if (params == null) {
            params = new HashMap<String, String>();
        }
        VolleyRequest request = new VolleyRequest(Request.Method.GET, buildGetUrl(endpoint, params), new JSONObject(), responseListener, responseListener);
        basicRequestSetup(request, tag, headers);
        setCachePolicy(request);
        addRequestToQueue(request);
    }

    /**
     * s
     * Make a POST API call to the base url.
     * This call is not cached
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param headers          params to add to the header
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void postDontCache(String endpoint, HashMap<String, String> headers, final HashMap<String, Object> params, String tag,
                              VolleyResponseListener<?, JSONObject> responseListener) {
        //appendAuthenticationData(params);//Append auth data if present
        //appendMandatoryParameters(params);
        Log.d("URL", endpoint);

        VolleyRequest request = new VolleyRequest(Request.Method.POST, endpoint, getJsonFormatParams(params), responseListener, responseListener);
        request.setCacheEnabled(false);
        basicRequestSetup(request, tag, headers);
        addRequestToQueue(request);
    }

    /**
     * Make a POST API call to the base url.
     * The cache policy for this call is set by:
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param headers          params to add to the header
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     * @see VolleyRestClient#setCachePolicy(VolleyRequest)
     */
    public void post(String endpoint, HashMap<String, String> headers, final HashMap<String, Object> params, String tag,
                     VolleyResponseListener<?, JSONObject> responseListener) {
        appendAuthenticationData(params);//Append auth data if present
        appendMandatoryParameters(params);

        VolleyRequest request = new VolleyRequest(Request.Method.POST, endpoint, getJsonFormatParams(params), responseListener, responseListener);
        setCachePolicy(request);
        basicRequestSetup(request, tag, headers);
        addRequestToQueue(request);
    }

    /**
     * Make a PUT Authorized API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param headers          params to add to the header
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void putDontCache(String endpoint, HashMap<String, String> headers, HashMap<String, Object> params, String tag,
                             VolleyResponseListener<?, JSONObject> responseListener) {
        if (params == null) {
            params = new HashMap<>();
        }
        VolleyRequest request = new VolleyRequest(Request.Method.PUT, endpoint, getJsonFormatParams(params), responseListener, responseListener);
        basicRequestSetup(request, tag, headers);
        request.setCacheEnabled(false);
        addRequestToQueue(request);
    }

    /**
     * Make a DELETE Authorized API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param headers          params to add to the header
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void deleteDontCache(String endpoint, HashMap<String, String> headers, HashMap<String, String> params, String tag,
                                VolleyResponseListener<?, JSONObject> responseListener) {
        if (params == null) {
            params = new HashMap<String, String>();
        }
        VolleyRequest request = new VolleyRequest(Request.Method.DELETE, buildGetUrl(endpoint, params), new JSONObject(), responseListener, responseListener);
        basicRequestSetup(request, tag, headers);
        request.setCacheEnabled(false);
        addRequestToQueue(request);
    }

    /**
     * Does some basic setup for the request
     *
     * @param request
     * @param tag
     */
    protected void basicRequestSetup(VolleyRequest request, String tag, HashMap<String, String> headers) {
        request.setTag(tag);
        request.setRetryPolicy(getRetryPolicy());//10s timeout no retries
        HashMap<String, String> defaultHeaders = new HashMap<>();
     /*   if(request.getUrl().contains(BuildConfig.RAZORPAY_BASE_URL)){
            defaultHeaders.putAll(headers);
            request.setHeaders(defaultHeaders);
        }else {
            defaultHeaders= getDefaultHeaders();
            if (headers != null) {
                defaultHeaders.putAll(headers);//Replace all custom headers.
            }
            request.setHeaders(defaultHeaders);
        }*/
    }

    /**
     * Changes hash map to json object
     *
     * @param params
     */
    protected JSONObject getJsonFormatParams(HashMap<String, Object> params) {
        JSONObject jsonParams = new JSONObject();
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                try {
                    if (entry.getValue() == null)
                        jsonParams.put(entry.getKey(), "");
                    else
                        jsonParams.put(entry.getKey(), entry.getValue());

                } catch (JSONException e) {
                    e.printStackTrace();
                    return jsonParams;
                }
            }
        }
        return jsonParams;
    }

    protected void addRequestToQueue(final VolleyRequest request) {
        mRequestQueue.add(request);
    }

    public abstract HashMap<String, String> getDefaultHeaders();

    /**
     * Set the cache police for the request
     *
     * @param request TTRequest
     * @see VolleyRequest#setSoftCacheExpiryTimeLimit(long)
     * @see VolleyRequest#setHardCacheExpiryTimeLimit(long)
     * @see VolleyRequest#setCacheEnabled(boolean)
     */
    public abstract void setCachePolicy(VolleyRequest request);

    /**
     * Append any necessary authentication fields.
     * This function is called before each POST call and the params will be attached to all.
     *
     * @param params current params.
     */
    public abstract void appendAuthenticationData(HashMap<String, Object> params);

    /**
     * Set any other mandatory parameters
     * We recommend passing the app version with all api calls.
     *
     * @param params current params
     */
    public abstract void appendMandatoryParameters(HashMap<String, Object> params);

    /**
     * Set the default timeout & retry policy for api calls
     * eg. new DefaultRetryPolicy(6000,0,1)
     *
     * @return DefaultRetryPolicy
     * @see DefaultRetryPolicy
     */
    public abstract DefaultRetryPolicy getRetryPolicy();

    /**
     * Allows the application to customize the httpstack.
     *
     * @return
     */
    public OkHttpStack getHttpStack() {
        return new OkHttpStack(new OkHttpClient());
    }

    public boolean doesCookieExistForDomain(String domain) {
        List<HttpCookie> uriList = getCookieManager().getCookieStore().getCookies();
        for (int i = 0; i < uriList.size(); i++) {
            if (uriList.get(i).getDomain().equalsIgnoreCase(domain)) {
                return true;
            }
        }
        return false;
    }

    public void clearCookies() {
        CookieManager cookieManager = (CookieManager) CookieHandler.getDefault();
        cookieManager.getCookieStore().removeAll();
    }
}
