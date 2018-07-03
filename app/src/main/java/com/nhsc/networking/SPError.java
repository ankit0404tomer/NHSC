package com.nhsc.networking;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by ANKIT on 19/5/17.
 */

public class SPError {
    int code;
    String message;
    String type;
    JSONObject response;
    VolleyError error;

    public SPError(VolleyError error, String message) {
        this.message = message;
        this.error = error;
        this.type = "";
    }

    public SPError(VolleyError error, String message, int code) {
        this.message = message;
        this.code = code;
        this.error = error;
    }


    public SPError(VolleyError error, String type, String message, int code) {
        this.message = message;
        this.type = type;
        this.code = code;
        this.error = error;
    }

    public SPError(VolleyError error, String message, int code, JSONObject response) {
        this.message = message;
        this.code = code;
        this.response = response;
        this.error = error;
    }

    public SPError(String message) {
        this.message = message;
    }

    public VolleyError getVolleyError() {
        return error;
    }

    public String getMessage() {
        return (message == null ? "" : message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JSONObject getResponse() {
        return response;
    }

    public void setResponse(JSONObject response) {
        this.response = response;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SPError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
