package com.example.aniphonicsapp.Puzzle_Game;

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

import com.example.aniphonicsapp.GamesActivity;
import com.example.aniphonicsapp.R;


public class Puzzle_Images extends AppCompatActivity {

    private MediaPlayer voice, click;
    private Button back;
    private Animation scaleUp,scaleDown;
    private ImageButton cat,cow,dog,duck,hamster,tiger;

    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_activity);

        playAudioVoice();

        cat = findViewById(R.id.puzzle1);
        cow = findViewById(R.id.puzzle2);
        dog = findViewById(R.id.puzzle3);
        duck = findViewById(R.id.puzzle4);
        hamster = findViewById(R.id.puzzle5);
        tiger = findViewById(R.id.puzzle6);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        back = findViewById(R.id.Back);
        back.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                back.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                back.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, GamesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        cat.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                cat.startAnimation(scaleUp);
                click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
                stopAudioVoice(); playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                cat.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, CatPuzzleActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });

        dog.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                dog.startAnimation(scaleUp);
                click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
                stopAudioVoice(); playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                dog.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, DogPuzzleActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });

        cow.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                cow.startAnimation(scaleUp);
                click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
                stopAudioVoice(); playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                cow.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, CowPuzzleActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });

        duck.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                duck.startAnimation(scaleUp);
                click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
                stopAudioVoice(); playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                duck.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, DuckPuzzleActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });

        hamster.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                hamster.startAnimation(scaleUp);
                click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
                stopAudioVoice(); playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                hamster.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, HamsPuzzleActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });

        tiger.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                tiger.startAnimation(scaleUp);
                click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
                stopAudioVoice(); playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                tiger.startAnimation(scaleDown);
                Intent intent = new Intent(Puzzle_Images.this, TigerPuzzleActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
            return true;
        });
    }

    public void finish() {
        super.finish();
        Intent intent = new Intent(Puzzle_Images.this, GamesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            voice = MediaPlayer.create(Puzzle_Images.this, R.raw.play_puzzle);
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
            click = MediaPlayer.create(Puzzle_Images.this, R.raw.click);
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

    private void playAudioVoice() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioTask task = new PlayAudioTask();
        task.execute();
    }

    private void stopAudioVoice() {
        PlayAudioTask task = new PlayAudioTask();
        task.stopAudio();
    }

    private void playAudioClick() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioClickTask task = new PlayAudioClickTask();
        task.execute();
    }
}
