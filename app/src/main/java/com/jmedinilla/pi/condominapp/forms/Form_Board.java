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
import com.jmedinilla.pi.condominapp.models.Model_Entry;
import com.jmedinilla.pi.condominapp.models.Model_User;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

import java.util.Calendar;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-11-06
 * <p>
 * Form for board
 */
public class Form_Board extends AppCompatActivity {

    private TextInputLayout formBoard_tilTitle;
    private TextInputLayout formBoard_tilContent;
    private EditText formBoard_edtTitle;
    private EditText formBoard_edtContent;
    private ImageView formBoard_btnAdd;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_board);

        preferences_profile = new Preferences_Profile(Form_Board.this);

        formBoard_tilTitle = (TextInputLayout) findViewById(R.id.formBoard_tilTitle);
        formBoard_tilContent = (TextInputLayout) findViewById(R.id.formBoard_tilContent);
        formBoard_edtTitle = (EditText) findViewById(R.id.formBoard_edtTitle);
        formBoard_edtContent = (EditText) findViewById(R.id.formBoard_edtContent);
        formBoard_btnAdd = (ImageView) findViewById(R.id.formBoard_btnAdd);

        final Model_User user = new Model_User(
                preferences_profile.getAccess(), preferences_profile.getUserCommunity(),
                preferences_profile.getUserFloor(), preferences_profile.getUserDoor(),
                preferences_profile.getUserPhone(), preferences_profile.getUserMail(),
                preferences_profile.getUserName(), preferences_profile.getUserCategory());

        formBoard_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formBoard_edtTitle.getText().toString().length() == 0) {
                    formBoard_edtTitle.setText("default");
                }
                if (formBoard_edtContent.getText().toString().length() == 0) {
                    formBoard_edtContent.setText("default");
                }

                Calendar calendar = Calendar.getInstance();
                Date date = new Date(calendar.getTimeInMillis());

                Model_Entry entry = new Model_Entry(
                        user, formBoard_edtTitle.getText().toString(),
                        formBoard_edtContent.getText().toString(), date, Model_Entry.FIRST);

                if (!((ModelApplication) getApplication()).getFirstEntries().contains(entry)) {
                    ((ModelApplication) getApplication()).saveFirstEntry(entry);
                    finish();
                } else
                    Snackbar.make(findViewById(R.id.form_board), "already exists", Snackbar.LENGTH_SHORT).show();
            }
        });

        formBoard_edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formBoard_tilTitle.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        formBoard_edtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formBoard_tilContent.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }
}
