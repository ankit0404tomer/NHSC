package com.nhsc.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.nhsc.networking.SPRestClient;


/**
 * Base activity.
 * <p>
 * Created by ANKIT on 23/7/17.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private static final String TAG = BaseActivity.class.getSimpleName();
    /**
     * The View.
     */
    protected View view;
    private ProgressDialog mProgressDialog;
    private BroadcastReceiver mCartCountItemChangedReciver;

    /**
     * Gets layout res id.
     *
     * @return the layout res id
     */
    protected abstract int getLayoutResId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = this.getLayoutInflater();
        view = inflater.inflate(getLayoutResId(), null);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(view);
    }


    /**
     * to change title in activity, as required in Login
     *
     * @param title the title
     */
    protected void changeToolbarTitle(String title) {

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
        }


    }

    /**
     * to set the color of status bar
     *
     * @param theme the theme
     */
    protected void changeStatusColor(int theme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = BaseActivity.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(BaseActivity.this, theme));
        }
    }


    /**
     * Gets sp rest client instance.
     *
     * @return the sp rest client instance
     */
    public SPRestClient getSPRestClientInstance() {
        return SPRestClient.getInstance(this);
    }


    /**
     * Push screen view event.
     *
     * @param name the name
     */
    public void pushScreenViewEvent(String name) {

        Log.i(TAG, "Pushing Screen View Event: " + name);
    }

    /**
     * Hide soft keyboard.
     */
    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        View focusedView = this.getCurrentFocus();

        /**
         * creating a view , if view is !=null only then hide keyboard.
         */
        if (focusedView != null)
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
    }


    /**
     * Show dialog.
     *
     * @param message the message
     */
  /*  protected void showDialog(String message) {
        if (!isFinishing()){
            if (mProgressDialog == null) {
                mProgressDialog = CustomProgressDialog.create(this);
                mProgressDialog.show();
            }
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        }
    }*/

    /**
     * Hide dialog.
     */
    protected void hideDialog() {
        if (!isFinishing()) {
            if (mProgressDialog != null && mProgressDialog.isShowing())
                mProgressDialog.dismiss();
        }
    }
}
