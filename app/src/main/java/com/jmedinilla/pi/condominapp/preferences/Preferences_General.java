package com.jmedinilla.pi.condominapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class created by JMedinilla on 2016-11-12
 */
public class Preferences_General {
    private static final int MODE = Context.MODE_PRIVATE;
    private static final String FILE = "com.jmedinilla.pi.condominapp_preferences";
    private static final String REMEMBER = "rememberaccesskey";
    private static final String STAY = "keepuserconnected";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Preferences_General(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE, MODE);
        editor = sharedPreferences.edit();
    }

    public boolean getRemember() {
        return sharedPreferences.getBoolean(REMEMBER, false);
    }

    public void setRemember(boolean value) {
        editor.putBoolean(REMEMBER, value).commit();
    }

    public boolean getStay() {
        return sharedPreferences.getBoolean(STAY, false);
    }

    public void setStay(boolean value) {
        editor.putBoolean(STAY, value).commit();
    }
}
