package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

public class Activity_Main_List_Documents extends AppCompatActivity {

    private RelativeLayout main_documents;
    private AutoCompleteTextView main_documents_atxtSearch;
    private RecyclerView main_documents_rcvDocuments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_documents);

        initializeComponents();
    }

    private void initializeComponents() {
        main_documents = (RelativeLayout) findViewById(R.id.activity_main_list_documents);
        main_documents_atxtSearch = (AutoCompleteTextView) findViewById(R.id.main_documents_atxtSearch);
        main_documents_rcvDocuments = (RecyclerView) findViewById(R.id.main_documents_rcvDocuments);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_documents, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_documents_add:
                intent = new Intent(Activity_Main_List_Documents.this, Form_Documents.class);
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
