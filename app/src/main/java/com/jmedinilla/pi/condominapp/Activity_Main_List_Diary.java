package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

public class Activity_Main_List_Diary extends AppCompatActivity {

    private RelativeLayout main_diary;
    private AutoCompleteTextView main_diary_atxtSearch;
    private RecyclerView main_diary_rcvDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_diary);

        initializeComponents();
    }

    private void initializeComponents() {
        main_diary = (RelativeLayout) findViewById(R.id.activity_main_list_diary);
        main_diary_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_diary_atxtSearch);
        main_diary_rcvDiary = (RecyclerView) findViewById(R.id.main_diary_rcvDiary);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_diary, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_diary_add:
                //intent = new Intent(Activity_Main_List_Diary.this, [FORMULARIO].class);
                //startActivity(intent);
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
