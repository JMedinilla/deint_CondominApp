package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class Activity_Main_List_Board_Communitary extends AppCompatActivity {

    private RelativeLayout main_board_community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_board_communitary);

        initializeComponents();
        Snackbar.make(main_board_community, "Community board", Snackbar.LENGTH_SHORT).show();
    }

    private void initializeComponents() {
        main_board_community = (RelativeLayout) findViewById(R.id.activity_main_list_board_communitary);
    }
}
