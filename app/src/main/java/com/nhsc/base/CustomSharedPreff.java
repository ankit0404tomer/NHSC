package com.nhsc.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CustomSharedPreff {

	public static final String KEY_LOGIN_SUCESS = "login_success";

	

	Context context;
	SharedPreferences prefs;
	private static final String PREF_NAME = "NHSCPreferences";
	private SharedPreferences.Editor editor;
	private int PRIVATE_MODE = 0;

	public CustomSharedPreff(Context c) {
		this.context = c;
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
		prefs = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = prefs.edit();
		editor.apply();
	}

	public void clear() {
		editor.clear();
		editor.commit();
	}

	public void setLoginSucess(boolean value) {
		editor.putBoolean(KEY_LOGIN_SUCESS, value);
		editor.commit();
	}

	public boolean isLoggedIn() {
		return prefs.getBoolean(KEY_LOGIN_SUCESS, false);
	}
}
