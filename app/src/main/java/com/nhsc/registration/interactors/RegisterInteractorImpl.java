package com.nhsc.registration.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPResponseListener;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;

import java.util.HashMap;

import static com.nhsc.Utils.AppConstants.registrationValues;


public class RegisterInteractorImpl implements RegisterInteractor {


    @Override
    public void onRegister( SPRestClient mSpRestClientInstance, final GenericResponseListener listener) {
        HashMap<String, Object> params =registrationValues;

        mSpRestClientInstance.postDontCache("" + "http://cipguru.com/nhsc/services/Login/adduser", params, "login_user", new SPResponseListener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                listener.onSuccess(response);
            }

            @Override
            public void onError(SPError error) {
                listener.onError(error);
            }
        });
    }
}

