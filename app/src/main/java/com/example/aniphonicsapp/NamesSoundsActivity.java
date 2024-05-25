package com.example.aniphonicsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NamesSoundsActivity extends AppCompatActivity {

    private Button back, next;
    private Animation scaleUp, scaleDown;
    private ImageButton farm, forest, pet;
    private MediaPlayer click, voice;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_sounds);

        back = findViewById(R.id.Back);
        next = findViewById(R.id.Next);
        farm = findViewById(R.id.farm);
        pet = findViewById(R.id.pet);
        forest = findViewById(R.id.forest);

        playAudio();

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        back.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                back.startAnimation(scaleUp);
                click = MediaPlayer.create(NamesSoundsActivity.this, R.raw.click);
                playAudioClick();
                stopAudio();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                back.startAnimation(scaleDown);
                Intent intent = new Intent(NamesSoundsActivity.this, StartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        farm.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                farm.startAnimation(scaleUp);
                playAudioClick();
                stopAudio();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                farm.startAnimation(scaleDown);
                Intent intent = new Intent(NamesSoundsActivity.this, FarmActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            return true;
        });

        pet.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                pet.startAnimation(scaleUp);
                playAudioClick();
                stopAudio();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                pet.startAnimation(scaleDown);
                Intent intent = new Intent(NamesSoundsActivity.this, PetActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            return true;
        });

        forest.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                forest.startAnimation(scaleUp);
                playAudioClick();
                stopAudio();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                forest.startAnimation(scaleDown);
                Intent intent = new Intent(NamesSoundsActivity.this, ForestActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            return true;
        });

        next.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                next.startAnimation(scaleUp);
                playAudioClick();
                stopAudio();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                next.startAnimation(scaleDown);
                Intent intent = new Intent(NamesSoundsActivity.this, GamesActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(NamesSoundsActivity.this, StartActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudio();
    }

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            voice = MediaPlayer.create(NamesSoundsActivity.this, R.raw.welcome_voice);
            voice.start();
            voice.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                voice.release();
                voice = null;
            });
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }

        public void stopAudio() {
            if (voice != null) {
                voice.stop();
                voice.release();
                voice = null;
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioClickTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            click = MediaPlayer.create(NamesSoundsActivity.this, R.raw.click);
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

        public void stopAudio() {
            if (click != null) {
                click.stop();
                click.release();
                click = null;
            }
        }
    }

    private void playAudio() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioTask task = new PlayAudioTask();
        task.execute();
    }

    private void stopAudio() {
        PlayAudioTask task = new PlayAudioTask();
        task.stopAudio();
    }

    private void playAudioClick() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioClickTask task = new PlayAudioClickTask();
        task.execute();
    }
}
