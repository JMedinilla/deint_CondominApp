package com.jmedinilla.pi.condominapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jmedinilla.pi.condominapp.preferences.Preferences_General;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

public class Activity_Login_Main extends AppCompatActivity {

    private RelativeLayout login_main;
    private TextInputLayout login_main_tilKey;
    private EditText login_main_edtKey;
    private Button login_main_btnLost;
    private CheckBox login_main_chbRemember;
    private CheckBox login_main_chbStay;
    private Preferences_General preferences_general;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        preferences_general = new Preferences_General(Activity_Login_Main.this);
        preferences_profile = new Preferences_Profile(Activity_Login_Main.this);

        initializeComponents();

        if (preferences_general.getStay()) {
            startActivity(new Intent(Activity_Login_Main.this, Activity_Home.class));
            finish();
        }
        else {
            if (preferences_general.getRemember()) {
                login_main_edtKey.setText(preferences_profile.getAccess());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                final AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Login_Main.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.dialog_about, null);
                builder.setTitle("About...").setCancelable(false);
                builder.setView(dialoglayout);
                builder.setPositiveButton(R.string.about_btnClose, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeComponents() {
        login_main = (RelativeLayout) findViewById(R.id.activity_login_main);
        login_main_tilKey = (TextInputLayout) findViewById(R.id.login_main_tilKey);
        login_main_edtKey = (EditText) findViewById(R.id.login_main_edtKey);
        login_main_btnLost = (Button) findViewById(R.id.login_main_btnLost);
        login_main_chbRemember = (CheckBox) findViewById(R.id.login_main_chbRemember);
        login_main_chbStay = (CheckBox) findViewById(R.id.login_main_chbStay);

        login_main_chbRemember.setChecked(preferences_general.getRemember());
        login_main_chbStay.setChecked(preferences_general.getStay());

        login_main_edtKey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login_main_tilKey.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        login_main_chbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences_general.setRemember(isChecked);
            }
        });
        login_main_chbStay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences_general.setStay(isChecked);
            }
        });
    }

    public void getOnClickLoginMain(View view) {
        switch (view.getId()) {
            case R.id.login_main_btnScan:
                //
                break;
            case R.id.login_main_btnJoin:
                //Si el usuario tiene categoría de administrador, se le pasa a la
                //ventana de selección de comunidad
                /*
                startActivity(new Intent(Activity_Login_Main.this, Activity_Login_Admin.class));
                finish();
                */
                //Si es un vecino, pos palante y tal
                preferences_profile.setAccess(login_main_edtKey.getText().toString());
                startActivity(new Intent(Activity_Login_Main.this, Activity_Home.class));
                finish();
                break;
            case R.id.login_main_btnLost:
                //Hay que enviar también el ID de la comunidad para que lea los datos
                //a mostrar en la siguiente ventana
                startActivity(new Intent(Activity_Login_Main.this, Activity_Login_Information.class));
                break;
        }
    }
}
