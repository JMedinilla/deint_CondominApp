package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class Activity_Main_List_Incidents extends AppCompatActivity {

    private RelativeLayout main_incidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_incidents);

        initializeComponents();
        Snackbar.make(main_incidents, "Incidents", Snackbar.LENGTH_SHORT).show();
    }

    private void initializeComponents() {
        main_incidents = (RelativeLayout) findViewById(R.id.activity_main_list_incidents);
    }
}
