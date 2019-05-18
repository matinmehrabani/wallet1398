package com.example.wallet1398.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.wallet1398.MainActivity;
import com.example.wallet1398.R;
import com.example.wallet1398.ui.pageActivity.PageActivity;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        CircularProgressBar circularProgressBar = findViewById(R.id.CircularProgressBar);
        circularProgressBar.setColor(ContextCompat.getColor(this, R.color.md_black_1000));
        circularProgressBar.setBackgroundColor(ContextCompat.getColor(this, R.color.md_blue_grey_50));
        circularProgressBar.setProgressBarWidth(getResources().getDimension(R.dimen.default_stroke_width));
        circularProgressBar.setBackgroundProgressBarWidth(getResources().getDimension(R.dimen.default_background_stroke_width));
        int animationDuration = 3000;
        circularProgressBar.setProgressWithAnimation(100, animationDuration);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                Boolean login = sharedPreferences.getBoolean("login", false);
                if (login == true) {
                    startActivity(new Intent(SplashActivity.this, PageActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }

                finish();

            }
        }, 2997);
    }
}
