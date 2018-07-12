package com.nhsc.base;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.nhsc.networking.SPRestClient;

/**
 * Created by Puneet Ahuja on 13/6/17.
 */
public abstract class BaseFragmentV4 extends Fragment {


    private static final String TAG = BaseFragmentV4.class.getSimpleName();
    /**
     * The Root view.
     */
    protected View rootView;
    private ProgressDialog mProgressDialog;
    private LayoutTransition lt;
    private AlertDialog.Builder mAlertDialogBuilder;
    private AlertDialog mAlertDialog;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResId(), container, false);

        lt = new LayoutTransition();
        lt.enableTransitionType(LayoutTransition.CHANGING);
        return rootView;
    }

    protected View getRootView() {
        return rootView;
    }

    /**
     * Gets layout res id.
     *
     * @return the layout res id
     */
    protected abstract int getLayoutResId();


    /**
     * Gets sp rest client instance.
     *
     * @return the sp rest client instance
     */
    public SPRestClient getSPRestClientInstance() {

        if (getActivity() != null) {

            return SPRestClient.getInstance(getActivity());
        }
        return null;
    }


    /**
     * Hide soft keyboard.
     */
    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }


    /**
     * Show key board.
     *
     * @param activity
     */
    public void showKeyBoard(Activity activity) {
        InputMethodManager inputMethodManager = null;
        if (activity != null)
            inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    /**
     * Gets mobile network type.
     *
     * @param context the context
     * @return the mobile network type
     */
    public String getMobileNetworkType(Context context) {

        TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int networkType = mTelephonyManager.getNetworkType();
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return "2g";
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:

            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return "3g";
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "4g";
            default:
                return "";
        }
    }

    /**
     * Is alert dialog showing boolean.
     *
     * @param thisAlertDialog the this alert dialog
     * @return the boolean
     */
    public boolean isAlertDialogShowing(AlertDialog thisAlertDialog) {
        if (thisAlertDialog != null) {
            return thisAlertDialog.isShowing();
        }
        return false;
    }


}
