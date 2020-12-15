package com.example.speedcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(Constants.SPLASH_DELAY);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    SharedPreferences preferences= getSharedPreferences(Constants.MY_PREFS, MODE_PRIVATE);
                    boolean is_connected = preferences.getBoolean(Constants.PREF_IS_CONNECTED, false);
                    if(is_connected)
                    {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        intent.putExtra("user", Constants.USER_CONNECTED);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
