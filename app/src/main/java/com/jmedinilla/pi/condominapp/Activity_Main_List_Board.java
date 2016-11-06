package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class Activity_Main_List_Board extends AppCompatActivity {

    private RelativeLayout main_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_board);

        initializeComponents();
        Snackbar.make(main_board, "Board", Snackbar.LENGTH_SHORT).show();
    }

    private void initializeComponents() {
        main_board = (RelativeLayout) findViewById(R.id.activity_main_list_board);
    }
}
