package com.jmedinilla.pi.condominapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.clans.fab.FloatingActionMenu;
import com.jmedinilla.pi.condominapp.preferences.Preferences_General;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

public class Activity_Home extends AppCompatActivity {

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
            case R.id.action_home_profile:
                intent = new Intent(Activity_Home.this, Activity_Main_Profile.class);
                startActivity(intent);
                break;
            case R.id.action_home_settings:
                intent = new Intent(Activity_Home.this, Activity_Main_Settings.class);
                startActivity(intent);
                break;
            case R.id.action_home_about:
                final AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Home.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.dialog_about, null);
                builder.setTitle("About...").setCancelable(false);
                builder.setView(dialoglayout);
                builder.setPositiveButton(R.string.about_btnClose, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeComponents() {
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
