package com.nhsc.networking;

import android.content.Context;

import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.nhsc.Utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.UnknownHostException;

/**
 * Created by ANKIT on 10/2/16.
 */
public abstract class SPResponseListener<T> extends VolleyResponseListener<T, JSONObject> {


    protected Context mContext;
    protected VolleyRequest mRequest;

    /**
     * Handles the onResponse and checks for the regular API response types
     *
     * @param jsonObject
     */
    @Override
    public void onResponse(JSONObject jsonObject) {
        this.onCompletion();

        //try {
            String responseType = jsonObject.optString(AppConstants.KEY_STATUS, "");
            //Checking Weather the response is success or not.
            if (responseType.equals(AppConstants.KEY_STATUS_SUCCESS) || responseType.equals("true")) {

                try{
                    Object object = new JSONTokener(jsonObject.get(AppConstants.KEY_DATA).toString()).nextValue();
                    if (object instanceof JSONArray) {
                        //If it is instance of Array. Data Array is Empty
                        this.onSuccess((T) new JSONObject());
                    } else {
                        //If it is instance of Object. Data Array has something..
                        JSONObject dataObject = jsonObject.getJSONObject(AppConstants.KEY_DATA);
                        this.onSuccess((T) dataObject);
                    }
                }catch (JSONException j){
                    j.printStackTrace();
                    //Status is success but there is no data only message
                    this.onSuccess((T) jsonObject);
                }


            } else if (responseType.equals(AppConstants.KEY_STATUS_FAILURE) || responseType.equals("false")) {
                //If Failure Send a Failure message
                String errorMessage = jsonObject.optString(AppConstants.KEY_MESSAGE, "Some error occurred, please try again later.");
                String type = jsonObject.optString(AppConstants.KEY_TYPE, "Unknown");

                try{
                    //Check for data in case of failure
                    Object object = new JSONTokener(jsonObject.get(AppConstants.KEY_DATA).toString()).nextValue();
                    if (object instanceof JSONArray) {
                        //If it is instance of Array. Data Array is Empty
                        SPError error= new SPError(new VolleyError(),errorMessage);
                        error.setType(type);
                        onError(error);
                    } else {
                        //If it is instance of Object. Data Array has something..
                        JSONObject dataObject = jsonObject.getJSONObject(AppConstants.KEY_DATA);
                        SPError error= new SPError(new VolleyError(),errorMessage);
                        error.setResponse(dataObject);
                        error.setType(type);
                        onError(error);
                    }

                }catch (JSONException j){
                    j.printStackTrace();
                    //Status is failure but there is no data only message
                    SPError error= new SPError(new VolleyError(),errorMessage);
                    error.setType(type);
                    onError(error);
                }

            } else {
                //If Unknown status is coming from backend
                this.onSuccess((T) jsonObject);
            }

         /*catch (Exception e) {
            e.printStackTrace();
            onError(new SPError(new VolleyError(), "Response Format is wrong"));
        }*/

    }

    public void setVolleyRequest(Context context, VolleyRequest request) {
        this.mContext = context;
        this.mRequest = request;
    }


    /**
     * Default volley errorResoponse call. Prints stack trace and calls onError()
     *
     * @param volleyError
     */
    @Override
    public void onErrorResponse(VolleyError volleyError) {
        this.onCompletion();
        if (volleyError != null && volleyError.getCause() instanceof UnknownHostException) {
            volleyError.printStackTrace();
            SPError error= new SPError(new VolleyError(),"Please check your internet connection and retry.");
            error.setType("NO_INTERNET");
            onError(error);
        } else {

            try {
                if (volleyError instanceof TimeoutError){
                    SPError error= new SPError(new VolleyError(),"Request Time out..........");
                    error.setType("REQUEST_TIME_OUT");
                    onError(error);
                }else {
                    SPError error= new SPError(new VolleyError(),"Some error occurred, please try again later.");
                    error.setType("Unknown");
                    onError(error);
                }
              //  String responseBody = new String(volleyError.networkResponse.data, "utf-8");

              //  Log.e("ANKIT ", "Server Error :: " + responseBody);
                //onError(new SPError(volleyError, responseBody, volleyError.networkResponse.statusCode));

            } catch (Exception e) {
                //Handle a malformed json response
                e.printStackTrace();
                SPError error= new SPError(new VolleyError(),"Some error occurred, please try again later.");
                error.setType("Unknown");
                onError(error);
            }
        }
    }

}
