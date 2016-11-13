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
 * Form for community board
 */
public class Form_Board_Community extends AppCompatActivity {

    private TextInputLayout formCboard_tilTitle;
    private TextInputLayout formCboard_tilContent;
    private EditText formCboard_edtTitle;
    private EditText formCboard_edtContent;
    private ImageView formCboard_btnAdd;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_board_community);

        preferences_profile = new Preferences_Profile(Form_Board_Community.this);

        formCboard_tilTitle = (TextInputLayout) findViewById(R.id.formCboard_tilTitle);
        formCboard_tilContent = (TextInputLayout) findViewById(R.id.formCboard_tilContent);
        formCboard_edtTitle = (EditText) findViewById(R.id.formCboard_edtTitle);
        formCboard_edtContent = (EditText) findViewById(R.id.formCboard_edtContent);
        formCboard_btnAdd = (ImageView) findViewById(R.id.formCboard_btnAdd);

        final Model_User user = new Model_User(
                preferences_profile.getAccess(), preferences_profile.getUserCommunity(),
                preferences_profile.getUserFloor(), preferences_profile.getUserDoor(),
                preferences_profile.getUserPhone(), preferences_profile.getUserMail(),
                preferences_profile.getUserName(), preferences_profile.getUserCategory());

        formCboard_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formCboard_edtTitle.getText().toString().length() == 0) {
                    formCboard_edtTitle.setText("default");
                }
                if (formCboard_edtContent.getText().toString().length() == 0) {
                    formCboard_edtContent.setText("default");
                }

                Calendar calendar = Calendar.getInstance();
                Date date = new Date(calendar.getTimeInMillis());

                Model_Entry entry = new Model_Entry(
                        user, formCboard_edtTitle.getText().toString(),
                        formCboard_edtContent.getText().toString(), date, Model_Entry.SECOND);

                if (!((ModelApplication) getApplication()).getSecondEntries().contains(entry)) {
                    ((ModelApplication) getApplication()).saveSecondEntry(entry);
                    finish();
                } else
                    Snackbar.make(findViewById(R.id.form_board_community), getString(R.string.app_invalid_element), Snackbar.LENGTH_SHORT).show();
            }
        });

        formCboard_edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formCboard_tilTitle.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        formCboard_edtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formCboard_tilContent.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }
}
