package com.nhsc.registration.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.base.BaseActivity;
import com.nhsc.base.CustomSharedPreff;
import com.nhsc.home.activities.Home_Screen;
import com.nhsc.login.activities.Sign_in;
import com.nhsc.registration.presenters.RegisterPresenter;
import com.nhsc.registration.presenters.RegisterPresenterImpl;
import com.nhsc.registration.views.RegisterView;

import org.json.JSONObject;

import static com.nhsc.Utils.AppConstants.registrationValues;

/**
 * Created by balu on 07/04/18.
 */

public class Register3 extends BaseActivity implements View.OnClickListener, RegisterView {


    Button register;

    EditText password_edit, confirm_password_edit;
    CheckBox newsletter_check, terms_conditions_check;

    TextView newsletter_text, terms_text, sign_up_text;
    CustomSharedPreff sharedPreff;

    public ProgressBar progressBar;

    String password, confirm_password;

    Utils utils;
    private RegisterPresenter registerPresenter;


    @Override
    protected int getLayoutResId() {
        return R.layout.register3;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        sharedPreff=new CustomSharedPreff(Register3.this);

        registerPresenter = new RegisterPresenterImpl(this, this, getSPRestClientInstance());
        ui_set();

        onclickMethods();


    }

    public void ui_set() {


        utils = new Utils(Register3.this);

        register = (Button) findViewById(R.id.sign_up_register);
        progressBar = (ProgressBar) findViewById(R.id.progress_view);


        password_edit = (EditText) findViewById(R.id.sign_up_password);
        confirm_password_edit = (EditText) findViewById(R.id.sign_up_confirm_password);

        newsletter_check = (CheckBox) findViewById(R.id.newsletter_check);
        terms_conditions_check = (CheckBox) findViewById(R.id.sign_up_termsconditions_check);


        sign_up_text = (TextView) findViewById(R.id.sign_up_text3);
        newsletter_text = (TextView) findViewById(R.id.newsletter_text);
        terms_text = (TextView) findViewById(R.id.terms_text);

        utils.setUbuntu_Light(register);

        utils.setUbuntu_Light(newsletter_text);
        utils.setUbuntu_Light(password_edit);
        utils.setUbuntu_Light(confirm_password_edit);
        utils.setUbuntu_Light(terms_text);

        utils.setUbuntu_Regular(sign_up_text);


    }

    public void onclickMethods() {

        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_register:

                password = password_edit.getText().toString();
                confirm_password = confirm_password_edit.getText().toString();

                if (password.length() == 0 && confirm_password.length() == 0) {
                    utils.AlertDialogue("Please enter all fields");
                } else if (password.length() == 0) {

                    utils.AlertDialogue("Please enter password");

                } else if (confirm_password.length() == 0) {

                    utils.AlertDialogue("Please enter confirm password");

                } else {


                    registrationValues.put("password", password);

                    registerPresenter.onRegister();


                }


                break;

        }
    }

    @Override
    public void onRegisterSuccess(JSONObject userName) {
        sharedPreff.setLoginSucess(true);
        Intent login_intent = new Intent(Register3.this, Home_Screen.class);
        login_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(login_intent);
    }

    @Override
    public void onRegisterFailure(String message) {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }
}
