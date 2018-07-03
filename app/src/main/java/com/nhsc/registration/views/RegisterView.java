package com.nhsc.registration.views;


import com.nhsc.base.BaseView;

import org.json.JSONObject;

public interface RegisterView extends BaseView {

    void onRegisterSuccess(JSONObject data);

    void onRegisterFailure(String message);


}
