package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class Activity_Main_List_Documents extends AppCompatActivity {

    private RelativeLayout main_documents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_documents);

        initializeComponents();
        Snackbar.make(main_documents, "Documents", Snackbar.LENGTH_SHORT).show();
    }

    private void initializeComponents() {
        main_documents = (RelativeLayout) findViewById(R.id.activity_main_list_documents);
    }
}
