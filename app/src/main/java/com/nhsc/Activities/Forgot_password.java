package com.nhsc.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.login.activities.Sign_in;

/**
 * Created by balu on 10/05/18.
 */

public class Forgot_password extends AppCompatActivity {

    Button get_password;
    EditText mail_edittext;
    Utils utils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);


        ui_set();


        get_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (utils.isValidEmail(mail_edittext.getText().toString())) {

                    utils.showForgotPasswordDialog("Please check your mail id for password", Sign_in.class);

                } else {


                    utils.AlertDialogue("Please enter valid mail ID");
                }


            }
        });


    }

    public void ui_set() {

        utils = new Utils(Forgot_password.this);

        get_password = (Button) findViewById(R.id.forgot_password_get_password);
        mail_edittext = (EditText) findViewById(R.id.forgot_password_mail_edit);


    }
}
