package com.dedsec.materialui;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.dedsec.materialui.activity.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Calling Method check and run Activity.....
        checkAndRunActivityForFirstTime();

    }

    public void checkAndRunActivityForFirstTime() {

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {

            //show app Intro Activity For First Time
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent splashScreen = new Intent(SplashActivity.this, SliderActivity.class);
                    startActivity(splashScreen);
                    finish();
                }
            },800);
            Toast.makeText(SplashActivity.this, "First Run", Toast.LENGTH_LONG).show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();
        } else {
            // otherwise Show Direct Home Activity
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent splashScreen = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(splashScreen);
                    finish();
                }
            },800);
        }

    }
}
