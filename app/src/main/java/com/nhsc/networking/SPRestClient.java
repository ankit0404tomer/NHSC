package com.nhsc.networking;

/**
 * Created by ANKIT on 10/2/16.
 */

import android.content.Context;
import android.net.Uri;

import com.android.volley.DefaultRetryPolicy;
import com.nhsc.networking.ssl.NukeSSLCerts;


import org.json.JSONObject;

import java.util.HashMap;


/**
 * Simple RestClient wrapper for Volley + OKHttp that integrates well with
 * Embitel's default API Structure.
 * Created by ANKIT on 10/02/16.
 */
public class SPRestClient extends VolleyRestClient {
    private static SPRestClient mInstance;
    private static Context mContext;

    public SPRestClient(Context applicationContext) {
        super(applicationContext);
    }

    public SPRestClient(Context applicationContext, String dateFormat) {
        super(applicationContext, dateFormat);
    }

    public static synchronized SPRestClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SPRestClient(context);
        }
        mContext = context;
        return mInstance;
    }

    public static String getBaseUrl() {
        return "";

    }

    public static String getDomain() {
        Uri uri = Uri.parse(getBaseUrl());
        return uri.getAuthority();
    }

    @Override
    public OkHttpStack getHttpStack() {
        return new OkHttpStack(NukeSSLCerts.getUnsafeOkHttpClient());
    }

    @Override
    public HashMap<String, String> getDefaultHeaders() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("User-Agent", "Android App");


        return hashMap;
    }

    @Override
    public void setCachePolicy(VolleyRequest request) {
        request.setHardCacheExpiryTimeLimit(10 * 24 * 60 * 60 * 1000);//10 days by default
        request.setSoftCacheExpiryTimeLimit(0);//0 days by default
        request.setCacheEnabled(true);
    }

    @Override
    public void appendAuthenticationData(HashMap<String, Object> params) {

    }

    @Override
    public void appendMandatoryParameters(HashMap<String, Object> params) {

    }

    @Override
    public DefaultRetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy(60000, 0, 1);
    }

    /**
     * Make a GET API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void getDontCache(String endpoint, HashMap<String, String> params, String tag,
                             VolleyResponseListener<?, JSONObject> responseListener) {


        getDontCache(endpoint, null, params, tag, responseListener);
    }


    /**
     * Make a GET API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void getWithHeaders(String endpoint, HashMap<String, String> headers, HashMap<String, String> params, String tag,
                               VolleyResponseListener<?, JSONObject> responseListener) {


        getDontCache(endpoint, headers, params, tag, responseListener);
    }

    /**
     * Make a GET API call to the base url.
     * The cache policy for this call is set by:
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     * @see VolleyRestClient#setCachePolicy(VolleyRequest)
     */
    public void get(String endpoint, HashMap<String, String> params, String tag,
                    VolleyResponseListener<?, JSONObject> responseListener) {
        get(endpoint, null, params, tag, responseListener);
    }

    /**
     * Make a POST API call to the base url.
     * This call is not cached
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void postDontCache(String endpoint, final HashMap<String, Object> params, String tag,
                              VolleyResponseListener<?, JSONObject> responseListener) {
        postDontCache(endpoint, null, params, tag, responseListener);
    }

    /**
     * Make a POST API call to the base url.
     * The cache policy for this call is set by:
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     * @see VolleyRestClient#setCachePolicy(VolleyRequest)
     */
    public void post(String endpoint, final HashMap<String, Object> params, String tag,
                     VolleyResponseListener<?, JSONObject> responseListener) {
        post(endpoint, null, params, tag, responseListener);
    }

    /**
     * Make a PUT Authorized API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void putDontCache(String endpoint, HashMap<String, Object> params, String tag,
                             VolleyResponseListener<?, JSONObject> responseListener) {
        putDontCache(endpoint, null, params, tag, responseListener);
    }

    /**
     * Make a DELETE Authorized API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void deleteDontCache(String endpoint, HashMap<String, String> params, String tag,
                                VolleyResponseListener<?, JSONObject> responseListener) {
        deleteDontCache(endpoint, null, params, tag, responseListener);
    }

    /**
     * Make a DELETE Authorized API call to the base url
     * This call is not cached.
     *
     * @param endpoint         api endpoint eg. "users/login"
     * @param params           params to add to the endpoint
     * @param tag              request identifier
     * @param responseListener Response handler
     */
    public void deleteWithHeaders(String endpoint, HashMap<String, String> headers, HashMap<String, String> params, String tag,
                                  VolleyResponseListener<?, JSONObject> responseListener) {
        deleteDontCache(endpoint, headers, params, tag, responseListener);
    }

    @Override
    protected void addRequestToQueue(final VolleyRequest request) {
        Context context = getApplicationContext();

        //Token Check

            //If has token app will proceed
            if (request.getListener() instanceof SPResponseListener) {
                ((SPResponseListener) request.getListener()).setVolleyRequest(context, request);
            }
            getRequestQueue().add(request);


    }


}
