package com.jmedinilla.pi.condominapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.jmedinilla.pi.condominapp.models.Model_User;

/**
 * Class created by JMedinilla on 2016-11-12
 */
public class Preferences_Profile {
    private static final int MODE = Context.MODE_PRIVATE;
    private static final String FILE = "com.jmedinilla.pi.condominapp_preferences";

    private static final String ACCESS = "accesskey";
    private static final String USER_COMMUNITY = "user_data_community"; //int
    private static final String USER_FLOOR = "user_data_floor";
    private static final String USER_DOOR = "user_data_door";
    private static final String USER_PHONE = "user_data_phone";
    private static final String USER_MAIL = "user_data_mail";
    private static final String USER_NAME = "user_data_name";
    private static final String USER_CATEGORY = "user_data_category"; //int

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

    public int getUserCommunity() {
        return sharedPreferences.getInt(USER_COMMUNITY, 999999999);
    }

    public void setUserCommunity(int value) {
        editor.putInt(USER_COMMUNITY, value).commit();
    }

    public String getUserFloor() {
        return sharedPreferences.getString(USER_FLOOR, "default");
    }

    public void setUserFloor(String value) {
        editor.putString(USER_FLOOR, value).commit();
    }

    public String getUserDoor() {
        return sharedPreferences.getString(USER_DOOR, "default");
    }

    public void setUserDoor(String value) {
        editor.putString(USER_DOOR, value).commit();
    }

    public String getUserPhone() {
        return sharedPreferences.getString(USER_PHONE, "default");
    }

    public void setUserPhone(String value) {
        editor.putString(USER_PHONE, value).commit();
    }

    public String getUserMail() {
        return sharedPreferences.getString(USER_MAIL, "default");
    }

    public void setUserMail(String value) {
        editor.putString(USER_MAIL, value).commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(USER_NAME, "default");
    }

    public void setUserName(String value) {
        editor.putString(USER_NAME, value).commit();
    }

    public int getUserCategory() {
        return sharedPreferences.getInt(USER_CATEGORY, Model_User.NEIGHBOUR);
    }

    public void setUserCategory(int value) {
        editor.putInt(USER_CATEGORY, value).commit();
    }
}
