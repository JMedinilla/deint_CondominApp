package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Activity_Main_Profile extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.profile_setting);
    }
}
