package com.nhsc.base;

import com.nhsc.networking.SPError;

import org.json.JSONObject;


/**
 * The interface Generic response listener.
 * <p>
 * Created by Ankti Tomer.
 */
public interface GenericResponseListener {

    /**
     * On error.
     *
     * @param spError the sp error
     */
    void onError(SPError spError);

    /**
     * On success.
     *
     * @param response the response
     */
    void onSuccess(JSONObject response);

}
