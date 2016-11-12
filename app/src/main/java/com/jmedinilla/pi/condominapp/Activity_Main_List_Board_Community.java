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

import com.jmedinilla.pi.condominapp.adapters.Adapter_List_Board_Community;
import com.jmedinilla.pi.condominapp.forms.Form_Board_Community;

public class Activity_Main_List_Board_Community extends AppCompatActivity {

    private static final int TYPE_ENTRY_TITLE = 30;
    private static final int TYPE_ENTRY_DATE = 31;

    private RelativeLayout main_board_community;
    private AutoCompleteTextView main_cboard_atxtSearch;
    private RecyclerView main_cboard_rcvCboard;

    private Adapter_List_Board_Community adapter_list_board_community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_board_communitary);

        initializeComponents();

        adapter_list_board_community = new Adapter_List_Board_Community(Activity_Main_List_Board_Community.this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (main_cboard_rcvCboard != null) {
            main_cboard_rcvCboard.setLayoutManager(llm);
            main_cboard_rcvCboard.setAdapter(adapter_list_board_community);
        }
    }

    private void initializeComponents() {
        main_board_community = (RelativeLayout) findViewById(R.id.activity_main_list_board_communitary);
        main_cboard_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_cboard_atxtSearch);
        main_cboard_rcvCboard = (RecyclerView) findViewById(R.id.main_cboard_rcvCboard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_cboard_add:
                intent = new Intent(Activity_Main_List_Board_Community.this, Form_Board_Community.class);
                startActivity(intent);
                break;
            case R.id.action_cboard_sortDate:
                adapter_list_board_community.sortCboard(TYPE_ENTRY_DATE);
                break;
            case R.id.action_cboard_sortTitle:
                adapter_list_board_community.sortCboard(TYPE_ENTRY_TITLE);
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
