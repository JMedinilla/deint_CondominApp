package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class Activity_Main_Information extends AppCompatActivity {

    private RelativeLayout main_information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_information);

        initializeComponents();
        Snackbar.make(main_information, "Information", Snackbar.LENGTH_SHORT).show();
    }

    private void initializeComponents() {
        main_information = (RelativeLayout) findViewById(R.id.activity_main_information);
    }
}
