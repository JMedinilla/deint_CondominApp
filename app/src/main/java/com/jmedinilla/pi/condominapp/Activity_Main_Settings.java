package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class Activity_Main_Settings extends AppCompatActivity {

    private RelativeLayout main_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        initializeComponents();
        Snackbar.make(main_settings, "Settings", Snackbar.LENGTH_SHORT).show();
    }

    private void initializeComponents() {
        main_settings = (RelativeLayout) findViewById(R.id.activity_main_settings);
    }
}
