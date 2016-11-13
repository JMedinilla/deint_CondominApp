package com.jmedinilla.pi.condominapp.forms;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Document;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

/**
 * Class created by JMedinilla on 2016-11-06
 * <p>
 * Form for documents
 */
public class Form_Documents extends AppCompatActivity {

    private TextInputLayout formDocuments_tilTitle;
    private TextInputLayout formDocuments_tilDescription;
    private TextInputLayout formDocuments_tilLink;
    private EditText formDocuments_edtTitle;
    private EditText formDocuments_edtDescription;
    private EditText formDocuments_edtLink;
    private ImageView formDocuments_btnAdd;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_documents);

        preferences_profile = new Preferences_Profile(Form_Documents.this);

        formDocuments_tilTitle = (TextInputLayout) findViewById(R.id.formDocument_tilTitle);
        formDocuments_tilDescription = (TextInputLayout) findViewById(R.id.formDocument_tilDescription);
        formDocuments_tilLink = (TextInputLayout) findViewById(R.id.formDocument_tilLink);
        formDocuments_edtTitle = (EditText) findViewById(R.id.formDocument_edtTitle);
        formDocuments_edtDescription = (EditText) findViewById(R.id.formDocument_edtDescription);
        formDocuments_edtLink = (EditText) findViewById(R.id.formDocument_edtLink);
        formDocuments_btnAdd = (ImageView) findViewById(R.id.formDocument_btnAdd);

        formDocuments_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formDocuments_edtTitle.getText().toString().length() == 0) {
                    formDocuments_edtTitle.setText("default");
                }
                if (formDocuments_edtDescription.getText().toString().length() == 0) {
                    formDocuments_edtDescription.setText("default");
                }
                if (formDocuments_edtLink.getText().toString().length() == 0) {
                    formDocuments_edtLink.setText("default");
                }

                Model_Document document = new Model_Document(preferences_profile.getUserCommunity(), formDocuments_edtTitle.getText().toString(),
                        formDocuments_edtDescription.getText().toString(), formDocuments_edtLink.getText().toString());

                if (!((ModelApplication) getApplication()).getDocuments().contains(document)) {
                    ((ModelApplication) getApplication()).saveDocument(document);
                    finish();
                } else
                    Snackbar.make(findViewById(R.id.form_documents), "already exists", Snackbar.LENGTH_SHORT).show();
            }
        });

        formDocuments_edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formDocuments_tilTitle.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        formDocuments_edtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formDocuments_tilDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        formDocuments_edtLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formDocuments_tilLink.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }
}
