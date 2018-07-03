package com.nhsc.login.views;


import com.nhsc.base.BaseView;

import org.json.JSONObject;

public interface SignInView extends BaseView {

    void onSignInSuccess(JSONObject userName);

    void onSignInFailure(String message);


}
