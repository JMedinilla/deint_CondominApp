package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

public class Activity_Main_List_Incidents extends AppCompatActivity {

    private RelativeLayout main_incidents;
    private AutoCompleteTextView main_incidents_atxtSearch;
    private RecyclerView main_incidents_rcvIncidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_incidents);

        initializeComponents();
    }

    private void initializeComponents() {
        main_incidents = (RelativeLayout) findViewById(R.id.activity_main_list_incidents);
        main_incidents_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_incidents_atxtSearch);
        main_incidents_rcvIncidents = (RecyclerView) findViewById(R.id.main_incidents_rcvIncidents);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
