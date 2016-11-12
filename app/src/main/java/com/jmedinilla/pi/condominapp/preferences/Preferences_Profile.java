package com.jmedinilla.pi.condominapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class created by JMedinilla on 2016-11-12
 */
public class Preferences_Profile {
    private static final int MODE = Context.MODE_PRIVATE;
    private static final String FILE = "com.jmedinilla.pi.condominapp_preferences";
    private static final String ACCESS = "accesskey";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Preferences_Profile(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE, MODE);
        editor = sharedPreferences.edit();
    }

    public String getAccess() {
        return sharedPreferences.getString(ACCESS, "default");
    }

    public void setAccess(String value) {
        editor.putString(ACCESS, value).commit();
    }
}
