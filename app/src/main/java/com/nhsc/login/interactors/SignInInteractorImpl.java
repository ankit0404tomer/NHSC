package com.nhsc.login.interactors;

import com.nhsc.Utils.AppConstants;
import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPResponseListener;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;

import java.util.HashMap;



public class SignInInteractorImpl implements SignInInteractor {

    @Override
    public void singIn(final String username, final String password, final SPRestClient mSpRestClientInstance, final GenericResponseListener listener) {
        HashMap<String, Object> params = new HashMap<>();
        params.put(AppConstants.KEY_USER_NAME, username);
        params.put(AppConstants.KEY_PASSWORD, password);
        mSpRestClientInstance.postDontCache("" + "http://cipguru.com/nhsc/services/Login/login", params, "login_user", new SPResponseListener<JSONObject>() {
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
