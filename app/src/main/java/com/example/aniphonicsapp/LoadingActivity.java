package com.example.aniphonicsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        setProgressBar();

    }

    public void setProgressBar () {
        progressBar = findViewById(R.id.progressBar);

        final Timer t = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);

                if (counter == 100) {
                    Intent intentLoadMainActivity = new Intent( LoadingActivity.this , StartActivity.class);
                    startActivity(intentLoadMainActivity);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
        t.schedule(timerTask, 0, 100);
    }
}
