package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

public class Activity_Main_List_Board_Communitary extends AppCompatActivity {

    private RelativeLayout main_board_community;
    private AutoCompleteTextView main_cboard_atxtSearch;
    private RecyclerView main_cboard_rcvCboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_board_communitary);

        initializeComponents();
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
                //intent = new Intent(Activity_Main_List_Board_Communitary.this, [FORMULARIO].class);
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
