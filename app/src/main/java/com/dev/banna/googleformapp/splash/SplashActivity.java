package com.dev.banna.googleformapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.banna.googleformapp.R;
import com.dev.banna.googleformapp.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(this::setUp, SPLASH_TIME_OUT);
    }

    private void setUp() {
        openMainActivity();
    }

    public void openMainActivity() {
//        startActivity(IntroActivity.getStartIntent(this));
        startActivity(MainActivity.getStartIntent(this).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY));

        finish();
    }

}