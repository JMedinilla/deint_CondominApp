package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.jmedinilla.pi.condominapp.adapters.Adapter_List_Meetings;
import com.jmedinilla.pi.condominapp.adapters.Adapter_List_Meetings_ListView;
import com.jmedinilla.pi.condominapp.forms.Form_Meetings;

public class Activity_Main_List_Meetings extends AppCompatActivity {

    private static final int TYPE_MEETING_DATE = 50;

    private RelativeLayout main_meetings;
    private AutoCompleteTextView main_meetings_atxtSearch;
    //private RecyclerView main_meetings_rcvMeetings;
    private ListView main_meetings_listview;

    private Adapter_List_Meetings adapter_list_meetings;
    private Adapter_List_Meetings_ListView adapter_list_meetings_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_meetings);

        initializeComponents();

        /*
        adapter_list_meetings = new Adapter_List_Meetings(Activity_Main_List_Meetings.this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (main_meetings_rcvMeetings != null) {
            main_meetings_rcvMeetings.setLayoutManager(llm);
            main_meetings_rcvMeetings.setAdapter(adapter_list_meetings);
        }
        */


        adapter_list_meetings_listView = new Adapter_List_Meetings_ListView(Activity_Main_List_Meetings.this);
        main_meetings_listview.setAdapter(adapter_list_meetings_listView);
    }

    private void initializeComponents() {
        main_meetings = (RelativeLayout) findViewById(R.id.activity_main_list_meetings);
        main_meetings_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_meetings_atxtSearch);
        //main_meetings_rcvMeetings = (RecyclerView) findViewById(R.id.main_meetings_rcvMeetings);
        main_meetings_listview = (ListView) findViewById(R.id.main_meetings_rcvMeetings);
    }

    /* VOLVER A ACTIVAR CUANDO SE PONGA EL RECYCLER DE NUEVO
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
                adapter_list_meetings.sortMeeting(TYPE_MEETING_DATE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //adapter_list_meetings.meetingAddedNotify();
        adapter_list_meetings_listView.notifyDataSetChanged();
    }
}
