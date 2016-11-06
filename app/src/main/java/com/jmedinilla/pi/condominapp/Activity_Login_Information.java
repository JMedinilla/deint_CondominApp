package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_Login_Information extends AppCompatActivity {

    private RelativeLayout login_information;
    private TextView login_info_txtAdminName;
    private TextView login_info_txtAdminPhone;
    private TextView login_info_txtAdminMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_information);

        initializeComponents();
    }

    private void initializeComponents() {
        login_information = (RelativeLayout) findViewById(R.id.activity_login_main);
        login_info_txtAdminName = (TextView) findViewById(R.id.login_info_txtAdminName);
        login_info_txtAdminPhone = (TextView) findViewById(R.id.login_info_txtAdminPhone);
        login_info_txtAdminMail = (TextView) findViewById(R.id.login_info_txtAdminMail);
    }

    public void getOnClickLoginInformation(View view) {
        switch (view.getId()) {
            case R.id.login_info_btnClose:
                finish();
                System.exit(0);
                break;
        }
    }
}
