package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.clans.fab.FloatingActionMenu;

public class Activity_Home extends AppCompatActivity {

    private RelativeLayout home;
    private FloatingActionMenu home_btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_profile:
                intent = new Intent(Activity_Home.this, Activity_Main_Profile.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                intent = new Intent(Activity_Home.this, Activity_Main_Settings.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeComponents() {
        home = (RelativeLayout) findViewById(R.id.activity_home);
        home_btnMenu = (FloatingActionMenu) findViewById(R.id.home_btnMenu);
    }

    public void getOnClickHome(View view) {
        home_btnMenu.close(false);
        switch (view.getId()) {
            case R.id.home_btnMenu_Incident:
                startActivity(new Intent(Activity_Home.this, Activity_Main_List_Incidents.class));
                break;
            case R.id.home_btnMenu_Diary:
                startActivity(new Intent(Activity_Home.this, Activity_Main_List_Diary.class));
                break;
            case R.id.home_btnMenu_Board:
                startActivity(new Intent(Activity_Home.this, Activity_Main_List_Board.class));
                break;
            case R.id.home_btnMenu_BoardCommunity:
                startActivity(new Intent(Activity_Home.this, Activity_Main_List_Board_Community.class));
                break;
            case R.id.home_btnMenu_Document:
                startActivity(new Intent(Activity_Home.this, Activity_Main_List_Documents.class));
                break;
            case R.id.home_btnMenu_Meeting:
                startActivity(new Intent(Activity_Home.this, Activity_Main_List_Meetings.class));
                break;
            case R.id.home_btnMenu_Information:
                startActivity(new Intent(Activity_Home.this, Activity_Main_Information.class));
                break;
        }
    }
}
