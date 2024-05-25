package com.example.aniphonicsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button start;
    private Button volume;
    private boolean isMute;
    private MediaPlayer player, click;
    private Animation scaleUp, scaleDown;

    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(StartActivity.this, R.raw.bg_music);
        player.start();
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);

        start=findViewById(R.id.Start);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        start.setOnTouchListener((v, event) -> {

            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                start.startAnimation(scaleUp);
                playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                start.startAnimation(scaleDown);
                Intent intent = new Intent(StartActivity.this, NamesSoundsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            return true;
        });

        volume=findViewById(R.id.Volume);
        volume.setOnClickListener(v -> {
            if(!isMute){
                isMute=true;
                volume.setBackground(getResources().getDrawable(
                        R.drawable.vol_disable
                ));
                player.pause();
            }
            else{
                isMute=false;
                volume.setBackground(getResources().getDrawable(
                        R.drawable.vol_enable
                ));
                player.start();
            }
        });

        findViewById(R.id.imageView3).startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_in
        ));

        start.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_in
        ));
    }


    @Override
    public void onPause()
    {
        super.onPause();
        if(player.isPlaying())
            player.pause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(!player.isPlaying() && start.isClickable())
            player.start();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(StartActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit app?");
        alertDialog.setPositiveButton("Yes", (dialog, which) -> finishAffinity());
        alertDialog.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioClickTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            click = MediaPlayer.create(StartActivity.this, R.raw.click);
            click.start();
            click.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                click.release();
                click = null;
            });
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }
    }

    private void playAudioClick() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioClickTask task = new PlayAudioClickTask();
        task.execute();
    }
}