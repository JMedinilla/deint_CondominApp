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
import com.jmedinilla.pi.condominapp.models.Model_Incident;
import com.jmedinilla.pi.condominapp.models.Model_User;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

import java.util.Calendar;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-11-06
 * <p>
 * Form for meetings
 */
public class Form_Incidents extends AppCompatActivity {

    private TextInputLayout formIncident_tilTitle;
    private TextInputLayout formIncident_tilContent;
    private EditText formIncident_edtTitle;
    private EditText formIncident_edtContent;
    private ImageView formIncident_btnAdd;
    private ImageView formIncident_imgPhoto;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_incidents);

        preferences_profile = new Preferences_Profile(Form_Incidents.this);

        formIncident_tilTitle = (TextInputLayout) findViewById(R.id.formIncident_tilTitle);
        formIncident_tilContent = (TextInputLayout) findViewById(R.id.formIncident_tilContent);
        formIncident_edtTitle = (EditText) findViewById(R.id.formIncident_edtTitle);
        formIncident_edtContent = (EditText) findViewById(R.id.formIncident_edtContent);
        formIncident_btnAdd = (ImageView) findViewById(R.id.formIncident_btnAdd);
        formIncident_imgPhoto = (ImageView) findViewById(R.id.formIncident_imgPhoto);

        final Model_User user = new Model_User(
                preferences_profile.getAccess(), preferences_profile.getUserCommunity(),
                preferences_profile.getUserFloor(), preferences_profile.getUserDoor(),
                preferences_profile.getUserPhone(), preferences_profile.getUserMail(),
                preferences_profile.getUserName(), preferences_profile.getUserCategory());

        formIncident_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formIncident_edtTitle.getText().toString().length() == 0) {
                    formIncident_edtTitle.setText("default");
                }
                if (formIncident_edtContent.getText().toString().length() == 0) {
                    formIncident_edtContent.setText("default");
                }

                Calendar calendar = Calendar.getInstance();
                Date date = new Date(calendar.getTimeInMillis());

                Model_Incident incident = new Model_Incident(user, date, formIncident_edtTitle.getText().toString(),
                        formIncident_edtContent.getText().toString(), "link_link_link_link_link");

                if (!((ModelApplication) getApplication()).getIncidents().contains(incident)) {
                    ((ModelApplication) getApplication()).saveIncident(incident);
                    finish();
                } else
                    Snackbar.make(findViewById(R.id.form_incidents), "already exists", Snackbar.LENGTH_SHORT).show();
            }
        });

        formIncident_edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formIncident_tilTitle.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        formIncident_edtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                formIncident_tilContent.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }
}
