package com.nhsc.registration.activities;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.registration.fragment.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.nhsc.Utils.AppConstants.registrationValues;

/**
 * Created by balu on 06/04/18.
 */

public class Register1 extends AppCompatActivity implements View.OnClickListener {


    Button next;

    EditText first_name_edit, last_name_edit, cpr_number_edit, mobile_num_edit, dob_edit;

    String first_name, last_name, cpr_num, mobile_num, dob;
    TextView sign_up_text;
    DatePickerDialog.OnDateSetListener date;
    Utils utils;
    LinearLayout lineraDob;
    Calendar myCalendar = Calendar.getInstance();
    private int mYear, mMonth, mDay, mHour, mMinute;
    static final int DATE_PICKER_ID = 1111;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register1);


        ui_set();

        onclickmethods();


    }

    public void ui_set() {


        utils = new Utils(Register1.this);

        next = (Button) findViewById(R.id.register1_next);
        lineraDob=(LinearLayout)findViewById(R.id.ll_dob);

        first_name_edit = (EditText) findViewById(R.id.sign_up_firstname);
        last_name_edit = (EditText) findViewById(R.id.sign_up_lastname);
        cpr_number_edit = (EditText) findViewById(R.id.sign_up_cpr_number);
        mobile_num_edit = (EditText) findViewById(R.id.sign_up_mobile_num);
        dob_edit = (EditText) findViewById(R.id.sign_up_dob);

        sign_up_text = (TextView) findViewById(R.id.sign_up_text);

        lineraDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(),"Date Picker");}

        });

        utils.setUbuntu_Regular(sign_up_text);

        utils.setUbuntu_Light(next);

        utils.setUbuntu_Light(first_name_edit);
        utils.setUbuntu_Light(last_name_edit);
        utils.setUbuntu_Light(cpr_number_edit);
        utils.setUbuntu_Light(mobile_num_edit);
        utils.setUbuntu_Light(dob_edit);

    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob_edit.setText(sdf.format(myCalendar.getTime()));
    }
    public void onclickmethods() {
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register1_next:

                first_name = first_name_edit.getText().toString();
                last_name = last_name_edit.getText().toString();
                cpr_num = cpr_number_edit.getText().toString();
                mobile_num = mobile_num_edit.getText().toString();
                dob = dob_edit.getText().toString();


                if (first_name.length() == 0 && last_name.length() == 0 && cpr_num.length() == 0 && mobile_num.length() == 0 && dob.length() == 0) {

                    utils.AlertDialogue("Please enter all fields");

                } else if (first_name.length() == 0) {
                    utils.AlertDialogue("Please enter First Name");
                } else if (last_name.length() == 0) {
                    utils.AlertDialogue("Please enter Last Name");
                } else if (cpr_num.length() == 0) {
                    utils.AlertDialogue("Please enter CPR Number");
                } else if (mobile_num.length() == 0) {
                    utils.AlertDialogue("Please enter Mobile Number");
                } else if (dob.length() == 0) {
                    utils.AlertDialogue("Please enter Date of Birth");
                } else {
                    registrationValues.put("fname",first_name);
                    registrationValues.put("lname",last_name);
                    registrationValues.put("CPRNumber",cpr_num);
                    registrationValues.put("phonenumber",mobile_num);
                    registrationValues.put("DOB",dob);
               Intent register_intent = new Intent(Register1.this, Register2.class);
                    startActivity(register_intent);
                }

                break;
        }
    }
}
