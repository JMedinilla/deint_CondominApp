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

import com.jmedinilla.pi.condominapp.adapters.Adapter_List_Diary;
import com.jmedinilla.pi.condominapp.forms.Form_Diary;

public class Activity_Main_List_Diary extends AppCompatActivity {

    private static final int TYPE_NOTE_DATE = 60;
    private static final int TYPE_NOTE_TITLE = 61;

    private RelativeLayout main_diary;
    private AutoCompleteTextView main_diary_atxtSearch;
    private RecyclerView main_diary_rcvDiary;

    private Adapter_List_Diary adapter_list_diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_diary);

        initializeComponents();

        adapter_list_diary = new Adapter_List_Diary(Activity_Main_List_Diary.this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (main_diary_rcvDiary != null) {
            main_diary_rcvDiary.setLayoutManager(llm);
            main_diary_rcvDiary.setAdapter(adapter_list_diary);
        }
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
                intent = new Intent(Activity_Main_List_Diary.this, Form_Diary.class);
                startActivity(intent);
                break;
            case R.id.action_diary_sortDate:
                adapter_list_diary.sortDiary(TYPE_NOTE_DATE);
                break;
            case R.id.action_diary_sortTitle:
                adapter_list_diary.sortDiary(TYPE_NOTE_TITLE);
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
        adapter_list_diary.noteAddedNotify();
    }
}
