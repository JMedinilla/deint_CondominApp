package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

public class Activity_Main_List_Board extends AppCompatActivity {

    private RelativeLayout main_board;
    private AutoCompleteTextView main_board_atxtSearch;
    private RecyclerView main_board_rcvBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_board);

        initializeComponents();
    }

    private void initializeComponents() {
        main_board = (RelativeLayout) findViewById(R.id.activity_main_list_board);
        main_board_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_board_atxtSearch);
        main_board_rcvBoard = (RecyclerView) findViewById(R.id.main_board_rcvBoard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_board, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_board_add:
                intent = new Intent(Activity_Main_List_Board.this, Form_Board.class);
                startActivity(intent);
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
