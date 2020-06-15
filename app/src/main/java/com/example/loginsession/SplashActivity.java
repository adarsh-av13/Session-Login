package com.example.loginsession;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                session = new SessionManager(getApplicationContext());
                Intent intent;
                if (session.isLoggedIn()) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 1000);
    }
}