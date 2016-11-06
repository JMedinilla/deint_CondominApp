package com.jmedinilla.pi.condominapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

public class Activity_Login_Admin extends AppCompatActivity {

    private RelativeLayout activity_login_admin;
    private RecyclerView login_admin_rcvCommunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        initializeComponents();
    }

    private void initializeComponents() {
        activity_login_admin = (RelativeLayout)findViewById(R.id.activity_login_admin);
        login_admin_rcvCommunity = (RecyclerView)findViewById(R.id.login_admin_rcvCommunity);
    }
}
