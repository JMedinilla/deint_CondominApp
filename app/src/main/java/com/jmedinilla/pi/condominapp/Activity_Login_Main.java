package com.jmedinilla.pi.condominapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.jmedinilla.pi.condominapp.models.Model_User;
import com.jmedinilla.pi.condominapp.preferences.Preferences_General;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

import java.util.List;

public class Activity_Login_Main extends AppCompatActivity {

    private TextInputLayout login_main_tilKey;
    private EditText login_main_edtKey;
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

        if (preferences_general.getRemember()) {
            login_main_edtKey.setText(preferences_profile.getAccess());
        } else {
            preferences_general.setStay(false);
        }
        if (preferences_general.getStay()) {
            startActivity(new Intent(Activity_Login_Main.this, Activity_Home.class));
            finish();
        }
        if (login_main_chbRemember.isChecked()) {
            login_main_chbStay.setEnabled(true);
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
                builder.setCancelable(false);
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
        login_main_tilKey = (TextInputLayout) findViewById(R.id.login_main_tilKey);
        login_main_edtKey = (EditText) findViewById(R.id.login_main_edtKey);
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
                if (isChecked) {
                    login_main_chbStay.setEnabled(true);
                } else {
                    login_main_chbStay.setChecked(false);
                    login_main_chbStay.setEnabled(false);
                }
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
                neighboutLogin(login_main_edtKey.getText().toString());
                break;
        }
    }

    private void neighboutLogin(String keyP) {
        boolean result = false;
        Model_User tmpUser;
        List<Model_User> tmpUsers = ((ModelApplication) getApplicationContext()).getUsers();
        for (int i = 0; i < tmpUsers.size(); i++) {
            if (keyP.equals(tmpUsers.get(i).getUs_id())) {
                tmpUser = new Model_User(
                        tmpUsers.get(i).getUs_id(),
                        tmpUsers.get(i).getUs_community(),
                        tmpUsers.get(i).getUs_floor(),
                        tmpUsers.get(i).getUs_door(),
                        tmpUsers.get(i).getUs_phone(),
                        tmpUsers.get(i).getUs_mail(),
                        tmpUsers.get(i).getUs_name(),
                        tmpUsers.get(i).getUs_category());

                preferences_profile.setAccess(tmpUser.getUs_id());
                preferences_profile.setUserCommunity(tmpUser.getUs_community());
                preferences_profile.setUserFloor(tmpUser.getUs_floor());
                preferences_profile.setUserDoor(tmpUser.getUs_door());
                preferences_profile.setUserPhone(tmpUser.getUs_phone());
                preferences_profile.setUserMail(tmpUser.getUs_mail());
                preferences_profile.setUserName(tmpUser.getUs_name());
                preferences_profile.setUserCategory(tmpUser.getUs_category());

                result = true;
                startActivity(new Intent(Activity_Login_Main.this, Activity_Home.class));
                finish();
            }
        }
        if (!result) {
            Model_User us = new Model_User("", 999999, "", "", "", "", "", Model_User.NEIGHBOUR);
            preferences_profile.setAccess(us.getUs_id());
            preferences_profile.setUserCommunity(us.getUs_community());
            preferences_profile.setUserFloor(us.getUs_floor());
            preferences_profile.setUserDoor(us.getUs_door());
            preferences_profile.setUserPhone(us.getUs_phone());
            preferences_profile.setUserMail(us.getUs_mail());
            preferences_profile.setUserName(us.getUs_name());
            preferences_profile.setUserCategory(us.getUs_category());
            Snackbar.make(findViewById(R.id.activity_login_main), R.string.app_invalid_user, Snackbar.LENGTH_LONG).show();
        }
    }
}
