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

import com.jmedinilla.pi.condominapp.adapters.Adapter_List_Documents;
import com.jmedinilla.pi.condominapp.forms.Form_Documents;

public class Activity_Main_List_Documents extends AppCompatActivity {

    private RelativeLayout main_documents;
    private AutoCompleteTextView main_documents_atxtSearch;
    private RecyclerView main_documents_rcvDocuments;

    private Adapter_List_Documents adapter_list_documents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_documents);

        initializeComponents();

        adapter_list_documents = new Adapter_List_Documents(Activity_Main_List_Documents.this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (main_documents_rcvDocuments != null) {
            main_documents_rcvDocuments.setLayoutManager(llm);
            main_documents_rcvDocuments.setAdapter(adapter_list_documents);
        }
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
            case R.id.action_documents_sortTitle:
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
