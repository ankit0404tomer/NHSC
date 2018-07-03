package com.nhsc.networking;

import com.android.volley.Response;

/**
 * Created by ANKIT on 15/03/16.
 */
public abstract class VolleyResponseListener<K, T> implements Response.Listener<T>, Response.ErrorListener {
    /**
     * Function called when the response is a successful Nykaa API strucure
     *
     * @param response
     */
    public abstract void onSuccess(K response);

    /**
     * Function is called if the response is an error
     *
     * @param error
     */
    public abstract void onError(SPError error);

    /**
     * Function is called regardless of a onSuccess or onFailure Response.
     */
    public void onCompletion() {
    }


}
