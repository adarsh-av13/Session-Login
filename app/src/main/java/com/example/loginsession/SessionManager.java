package com.example.loginsession;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String PREF_NAME = "user_details";
    private String IS_LOGGED = "isLoggedIn";
    private String USER_NAME = "username";
    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_details", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void session_start(String username) {
        editor.putBoolean(IS_LOGGED, true);
        editor.putString(USER_NAME, username);
        editor.commit();
    }

    public void session_stop() {
        editor.remove(USER_NAME);
        editor.remove(IS_LOGGED);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED, false);
    }

    public String geUsername() {
        return sharedPreferences.getString(USER_NAME, "");
    }
}
