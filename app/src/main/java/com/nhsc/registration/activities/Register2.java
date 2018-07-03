package com.nhsc.registration.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nhsc.R;
import com.nhsc.Utils.Utils;

import static com.nhsc.Utils.AppConstants.registrationValues;

/**
 * Created by balu on 07/04/18.
 */

public class Register2 extends AppCompatActivity implements View.OnClickListener {

    Button next;

    EditText email_edit, user_name_edit, flat_no_edit, building_no_edit, road_no_edit, block_no_edit, area_edit;

    String email, user_name, flat_no, building_no, road_no, block_no, area;
    TextView sign_up_text;

    Utils utils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register2);


        uiset();

        onclickmethods();

    }

    public void uiset() {

        utils = new Utils(Register2.this);

        next = (Button) findViewById(R.id.register2_next);


        email_edit = (EditText) findViewById(R.id.sign_up_email);
        user_name_edit = (EditText) findViewById(R.id.sign_up_username);
        flat_no_edit = (EditText) findViewById(R.id.sign_up_flat_num);
        building_no_edit = (EditText) findViewById(R.id.sign_up_building_num);
        road_no_edit = (EditText) findViewById(R.id.sign_up_road_num);
        block_no_edit = (EditText) findViewById(R.id.sign_up_block_num);
        area_edit = (EditText) findViewById(R.id.sign_up_area);

        sign_up_text = (TextView) findViewById(R.id.sign_up_text2);

        utils.setUbuntu_Light(next);

        utils.setUbuntu_Light(email_edit);
        utils.setUbuntu_Light(user_name_edit);
        utils.setUbuntu_Light(flat_no_edit);
        utils.setUbuntu_Light(building_no_edit);
        utils.setUbuntu_Light(road_no_edit);
        utils.setUbuntu_Light(block_no_edit);
        utils.setUbuntu_Light(area_edit);

        utils.setUbuntu_Regular(sign_up_text);


    }

    public void onclickmethods() {

        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register2_next:

                email = email_edit.getText().toString();
                user_name = user_name_edit.getText().toString();
                flat_no = flat_no_edit.getText().toString();
                building_no = building_no_edit.getText().toString();
                road_no = road_no_edit.getText().toString();
                block_no = block_no_edit.getText().toString();
                area = area_edit.getText().toString();


                if (email.length() == 0 && user_name.length() == 0 && flat_no.length() == 0 && building_no.length() == 0 && road_no.length() == 0 && block_no.length() == 0 && area.length() == 0) {

                    utils.AlertDialogue("Please enter all fields");

                } else if (email.length() == 0) {

                    utils.AlertDialogue("Please enter Email");

                } else if (user_name.length() == 0) {

                    utils.AlertDialogue("Please enter Username");

                } else if (flat_no.length() == 0) {

                    utils.AlertDialogue("Please enter Flat Number");

                } else if (building_no.length() == 0) {

                    utils.AlertDialogue("Please enter Building Number");

                } else if (road_no.length() == 0) {

                    utils.AlertDialogue("Please enter Road Number");

                } else if (block_no.length() == 0) {

                    utils.AlertDialogue("Please enter Block Number");

                } else if (area.length() == 0) {

                    utils.AlertDialogue("Please enter Area");

                } else {




                    registrationValues.put("email",email);
                    registrationValues.put("username",user_name);
                    registrationValues.put("FlatNumber",flat_no);
                    registrationValues.put("BuildingNumber",building_no);
                    registrationValues.put("RoadNumber",road_no);
                    registrationValues.put("BlockNumber",block_no);
                    registrationValues.put("Area",area);




                    Intent register_intent = new Intent(Register2.this, Register3.class);
                    startActivity(register_intent);
                }

                break;
        }
    }
}
