package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import com.jmedinilla.pi.condominapp.forms.Form_Meetings;

public class Activity_Main_List_Meetings extends AppCompatActivity {

    private RelativeLayout main_meetings;
    private AutoCompleteTextView main_meetings_atxtSearch;
    private RecyclerView main_meetings_rcvMeetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_meetings);

        initializeComponents();
    }

    private void initializeComponents() {
        main_meetings = (RelativeLayout) findViewById(R.id.activity_main_list_meetings);
        main_meetings_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_meetings_atxtSearch);
        main_meetings_rcvMeetings = (RecyclerView) findViewById(R.id.main_meetings_rcvMeetings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_meetings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_meetings_add:
                intent = new Intent(Activity_Main_List_Meetings.this, Form_Meetings.class);
                startActivity(intent);
                break;
            case R.id.action_meetings_sortDate:
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
