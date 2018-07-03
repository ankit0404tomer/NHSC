package com.nhsc.login.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nhsc.Activities.Forgot_password;
import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.base.BaseActivity;
import com.nhsc.base.CustomSharedPreff;
import com.nhsc.home.activities.Home_Screen;
import com.nhsc.login.presenters.SignInPresenter;
import com.nhsc.login.presenters.SignInPresenterImpl;
import com.nhsc.login.views.SignInView;
import com.nhsc.registration.activities.Register1;

import org.json.JSONObject;


/**
 * Created by balu on 04/04/18.
 */

public class Sign_in extends BaseActivity implements View.OnClickListener, SignInView {

    Button register, login, visit_app;
    EditText email_edittext, password_edittext;
    TextView sign_in_text, sign_in_forgot_password;
    Utils utils;
   public ProgressBar progressBar;
    CustomSharedPreff sharedPreff;
    private SignInPresenter signInPresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.sign_in;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ui_set();
        onclickmethods();

    }

    public void ui_set() {
        sharedPreff=new CustomSharedPreff(Sign_in.this);
        utils = new Utils(Sign_in.this);
        signInPresenter = new SignInPresenterImpl(this, this, getSPRestClientInstance());
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        visit_app = (Button) findViewById(R.id.visit_app);

        sign_in_text = (TextView) findViewById(R.id.sign_in_text);
        sign_in_forgot_password = (TextView) findViewById(R.id.sign_in_forgot_password);

        email_edittext = (EditText) findViewById(R.id.sign_in_email_edit);
        password_edittext = (EditText) findViewById(R.id.sign_in_pass_edit);
        progressBar = (ProgressBar) findViewById(R.id.progress_view);

        utils.setUbuntu_Regular(sign_in_text);
        utils.setUbuntu_Regular(sign_in_forgot_password);
        utils.setUbuntu_Light(login);
        utils.setUbuntu_Light(register);
        utils.setUbuntu_Light(visit_app);

        utils.setUbuntu_Light(email_edittext);
        utils.setUbuntu_Light(password_edittext);


    }

    public void onclickmethods() {

        register.setOnClickListener(this);
        login.setOnClickListener(this);
        sign_in_forgot_password.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent register_intent = new Intent(Sign_in.this, Register1.class);
                startActivity(register_intent);


                break;
            case R.id.sign_in_forgot_password:

                Intent forgot_intent = new Intent(Sign_in.this, Forgot_password.class);
                startActivity(forgot_intent);

                break;
            case R.id.login:


                if (email_edittext.getText().toString().isEmpty() || email_edittext.getText().toString().length() == 0) {

                    utils.AlertDialogue("Please enter valid credentials");

                } else {

                    if (utils.isValidEmail(email_edittext.getText().toString())) {

                        if (password_edittext.getText().toString().length() > 6) {

                            signInPresenter.validateCredentials(email_edittext.getText().toString(), password_edittext.getText().toString());

                        } else {
                            utils.AlertDialogue("Password must be more than 6 characters");
                        }


                    } else {
                        utils.AlertDialogue("Please enter valid Email");
                    }
                }


               /* if(isValidEmail(email_edittext.getText().toString()) && password_edittext.getText().toString().length() > 6) {


                    Intent login_intent = new Intent(Sign_in.this, HomeScreen.class);
                    startActivity(login_intent);
                }else{

                    utils.AlertDialogue("Please enter valid credentials, Password must be more than 6 characters");

                    Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                }*/

                break;
        }
    }

    @Override
    public void onSignInSuccess(JSONObject userName) {

        sharedPreff.setLoginSucess(true);
        Intent login_intent = new Intent(Sign_in.this, Home_Screen.class);
        login_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(login_intent);
    }

    @Override
    public void onSignInFailure(String message) {

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
