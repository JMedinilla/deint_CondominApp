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
import com.jmedinilla.pi.condominapp.models.Model_Note;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

import java.util.Calendar;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-11-06
 * <p>
 * Form for diary
 */
public class Form_Diary extends AppCompatActivity {

    private TextInputLayout formDiary_tilTitle;
    private TextInputLayout formDiary_tilContent;
    private EditText formDiary_edtTitle;
    private EditText formDiary_edtContent;
    private ImageView formDiary_btnAdd;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_diary);

        preferences_profile = new Preferences_Profile(Form_Diary.this);

        formDiary_tilTitle = (TextInputLayout) findViewById(R.id.formDiary_tilTitle);
        formDiary_tilContent = (TextInputLayout) findViewById(R.id.formDiary_tilContent);
        formDiary_edtTitle = (EditText) findViewById(R.id.formDiary_edtTitle);
        formDiary_edtContent = (EditText) findViewById(R.id.formDiary_edtContent);
        formDiary_btnAdd = (ImageView) findViewById(R.id.formDiary_btnAdd);

        formDiary_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formDiary_edtTitle.getText().toString().length() == 0) {
                    formDiary_edtTitle.setText("default");
                }
                if (formDiary_edtContent.getText().toString().length() == 0) {
                    formDiary_edtContent.setText("default");
                }

                Calendar calendar = Calendar.getInstance();
                Date date = new Date(calendar.getTimeInMillis());

                Model_Note note = new Model_Note(preferences_profile.getUserCommunity(), date,
                        formDiary_edtTitle.getText().toString(),
                        formDiary_edtContent.getText().toString());

                if (!((ModelApplication) getApplication()).getNotes().contains(note)) {
                    ((ModelApplication) getApplication()).saveNote(note);
                    finish();
                } else
                    Snackbar.make(findViewById(R.id.form_diary), getString(R.string.app_invalid_element), Snackbar.LENGTH_SHORT).show();
            }
        });

        formDiary_edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formDiary_tilTitle.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        formDiary_edtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formDiary_tilContent.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }
}
