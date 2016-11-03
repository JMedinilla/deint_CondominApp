package com.jmedinilla.pi.condominapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DURATION_MS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //Logo scale animation
        Animation animation = AnimationUtils.loadAnimation(Activity_SplashScreen.this, R.anim.splashscreen_imglogo);

        ImageView imgLogo = (ImageView) findViewById(R.id.splashscreen_imgLogo);
        if (imgLogo != null) {
            imgLogo.setAnimation(animation);
        }

        /**
         * Waits X milliseconds before starting the other Activity
         * @see Handler
         */
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Activity_SplashScreen.this, Activity_Login_Main.class));
                finish();
            }
        }, SPLASH_DURATION_MS);
    }
}
