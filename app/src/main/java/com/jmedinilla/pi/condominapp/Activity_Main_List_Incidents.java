package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import com.jmedinilla.pi.condominapp.adapters.Adapter_List_Incidents;
import com.jmedinilla.pi.condominapp.forms.Form_Incidents;

public class Activity_Main_List_Incidents extends AppCompatActivity {

    private RelativeLayout main_incidents;
    private AutoCompleteTextView main_incidents_atxtSearch;
    private RecyclerView main_incidents_rcvIncidents;

    private Adapter_List_Incidents adapter_list_incidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_incidents);

        initializeComponents();

        adapter_list_incidents = new Adapter_List_Incidents(Activity_Main_List_Incidents.this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (main_incidents_rcvIncidents != null) {
            main_incidents_rcvIncidents.setLayoutManager(llm);
            main_incidents_rcvIncidents.setAdapter(adapter_list_incidents);
        }
    }

    private void initializeComponents() {
        main_incidents = (RelativeLayout) findViewById(R.id.activity_main_list_incidents);
        main_incidents_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_incidents_atxtSearch);
        main_incidents_rcvIncidents = (RecyclerView) findViewById(R.id.main_incidents_rcvIncidents);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_incidents, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_incidents_add:
                intent = new Intent(Activity_Main_List_Incidents.this, Form_Incidents.class);
                startActivity(intent);
                break;
            case R.id.action_incidents_sortDate:
                break;
            case R.id.action_incidents_sortTitle:
                break;
        }
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
