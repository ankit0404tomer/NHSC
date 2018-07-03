package com.nhsc.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;

import com.nhsc.R;

/**
 * Created by balu on 23/04/18.
 */

public class Utils {

    public static String base_url = "http://cipguru.com/nhsc/services/";
    public static String Reg_Url = "Login/adduser";
    public static String Login_Url = "Login/login";
    private Context mContext;


    public Utils(Context c) {
        this.mContext = c;
    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void AlertDialogue(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext, R.style.MyDialogTheme);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int arg1) {

                        dialog.cancel();
                    }
                });

        /*alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });*/

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void setUbuntu_Light(TextView tv) {

        Typeface face = Typeface.createFromAsset(mContext.getAssets(), "fonts/Ubuntu-Light.ttf");
        tv.setTypeface(face);


    }

    public void setUbuntu_Regular(TextView tv) {

        Typeface face = Typeface.createFromAsset(mContext.getAssets(), "fonts/Ubuntu-Regular.ttf");
        tv.setTypeface(face);


    }

    // used in forgot password class
    public void showForgotPasswordDialog(String message, final Class cls_name) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.MyDialogTheme);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();

                        Intent i = new Intent(mContext, cls_name);
                        mContext.startActivity(i);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }


}
