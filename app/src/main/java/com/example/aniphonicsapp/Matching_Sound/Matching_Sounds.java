package com.example.aniphonicsapp.Matching_Sound;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aniphonicsapp.GamesActivity;
import com.example.aniphonicsapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Matching_Sounds extends AppCompatActivity {
    private ArrayList<Sound> allSounds;
    private Random random = new Random();
    private ImageView imageSound, correctWrong1, correctWrong2, correctWrong3;
    private ImageButton imageGuess1, imageGuess2, imageGuess3;
    private MediaPlayer voice, click, correct;
    private Button back;
    private Animation scaleUp,scaleDown, zoom_in, no_zoom, shake;
    private Sound sounds;
    private MediaPlayer media;
    private AlertDialog alertDialog;
    private int imageGuess1ResourceIdName,imageGuess2ResourceIdName,imageGuess3ResourceIdName,imageSoundResourceId;

    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching_sound);

        allSounds = new ArrayList<>();
        allSounds.add(new Sound(R.drawable.dog, R.raw.dog_sound));
        allSounds.add(new Sound(R.drawable.cat,  R.raw.cat_sound));
        allSounds.add(new Sound(R.drawable.bird,  R.raw.bird_sound));
        allSounds.add(new Sound(R.drawable.turtle,  R.raw.turtle_sound));
        allSounds.add(new Sound(R.drawable.frog,  R.raw.frog_sound));
        allSounds.add(new Sound(R.drawable.parrot,  R.raw.parrot_sound));
        allSounds.add(new Sound(R.drawable.mouse,  R.raw.mouse_sound));
        allSounds.add(new Sound(R.drawable.hamster,  R.raw.hamster_sound));
        allSounds.add(new Sound(R.drawable.squirrel,  R.raw.squirrel_sound));
        allSounds.add(new Sound(R.drawable.rabbit,  R.raw.rabbit_sound));
        allSounds.add(new Sound(R.drawable.lion,  R.raw.lion_sound));
        allSounds.add(new Sound(R.drawable.monkey,  R.raw.monkey_sound));
        allSounds.add(new Sound(R.drawable.elephant,  R.raw.elephant_sound));
        allSounds.add(new Sound(R.drawable.hippo,  R.raw.hippo_sound));
        allSounds.add(new Sound(R.drawable.zebra,  R.raw.zebra_sound));
        allSounds.add(new Sound(R.drawable.wolf,  R.raw.wolf_sound));
        allSounds.add(new Sound(R.drawable.giraffe,  R.raw.giraffe_sound));
        allSounds.add(new Sound(R.drawable.tiger,  R.raw.tiger_sound));
        allSounds.add(new Sound(R.drawable.bear,  R.raw.bear_sound));
        allSounds.add(new Sound(R.drawable.kangaroo,  R.raw.kangaroo_sound));
        allSounds.add(new Sound(R.drawable.panda,  R.raw.panda_sound));
        allSounds.add(new Sound(R.drawable.snake,  R.raw.snake_sound));
        allSounds.add(new Sound(R.drawable.cow,  R.raw.cow_sound));
        allSounds.add(new Sound(R.drawable.pig,  R.raw.pig_sound));
        allSounds.add(new Sound(R.drawable.fish,  R.raw.fish_sound));
        allSounds.add(new Sound(R.drawable.horse,  R.raw.horse_sound));
        allSounds.add(new Sound(R.drawable.hen,  R.raw.hen_sound));
        allSounds.add(new Sound(R.drawable.turkey,  R.raw.turkey_sound));
        allSounds.add(new Sound(R.drawable.duck,  R.raw.duck_sound));
        allSounds.add(new Sound(R.drawable.rooster,  R.raw.rooster_sound));
        allSounds.add(new Sound(R.drawable.goat,  R.raw.goat_sound));
        allSounds.add(new Sound(R.drawable.sheep,  R.raw.sheep_sound));
        // add more pictures to the array

        // Get references to the UI widgets
        imageGuess1 = findViewById(R.id.imageGuess1);
        imageGuess2 = findViewById(R.id.imageGuess2);
        imageGuess3 = findViewById(R.id.imageGuess3);
        imageSound = findViewById(R.id.imageSound);
        correctWrong1 = findViewById(R.id.correctWrong1);
        correctWrong2 = findViewById(R.id.correctWrong2);
        correctWrong3 = findViewById(R.id.correctWrong3);

        playAudioVoice();
        // Start the game
        playGame();

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        zoom_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        no_zoom = AnimationUtils.loadAnimation(this,R.anim.no_zoom);
        shake = AnimationUtils.loadAnimation(this,R.anim.shake);

        back = findViewById(R.id.Back);
        back.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                back.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                back.startAnimation(scaleDown);
                Intent intent = new Intent(Matching_Sounds.this, GamesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        imageGuess1.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                imageGuess1.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            } else if(event.getAction()== MotionEvent.ACTION_UP){
                imageGuess1.startAnimation(scaleDown);
                if (imageGuess1ResourceIdName == imageSoundResourceId) {
                    // Correct match
                    correctWrong1.setImageResource(R.mipmap.correct_1);
                    correctWrong1.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess2.setEnabled(false); imageGuess3.setEnabled(false); imageSound.setEnabled(false);
                    playAudioCorrect(); imageGuess1.startAnimation(zoom_in);
                    imageGuess2.startAnimation(no_zoom); imageGuess3.startAnimation(no_zoom);
                } else {
                    // Incorrect match
                    correctWrong1.setImageResource(R.mipmap.wrong_1);
                    correctWrong1.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess1.setEnabled(false); imageGuess1.startAnimation(shake);
                }
            }
            return true;
        });

        imageGuess2.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                imageGuess2.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            } else if(event.getAction()== MotionEvent.ACTION_UP){
                imageGuess2.startAnimation(scaleDown);
                if (imageGuess2ResourceIdName == imageSoundResourceId) {
                    correctWrong2.setImageResource(R.mipmap.correct_1);
                    correctWrong2.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess3.setEnabled(false); imageGuess1.setEnabled(false); imageSound.setEnabled(false);
                    playAudioCorrect(); imageGuess2.startAnimation(zoom_in);
                    imageGuess1.startAnimation(no_zoom); imageGuess3.startAnimation(no_zoom);

                } else {
                    // Incorrect match
                    imageGuess2.setEnabled(false); imageGuess2.startAnimation(shake);
                    correctWrong2.setImageResource(R.mipmap.wrong_1);
                    correctWrong2.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                }
            }
            return true;
        });

        imageGuess3.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                imageGuess3.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            } else if(event.getAction()== MotionEvent.ACTION_UP){
                imageGuess3.startAnimation(scaleDown);
                if (imageGuess3ResourceIdName == imageSoundResourceId) {
                    correctWrong3.setImageResource(R.mipmap.correct_1);
                    correctWrong3.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess2.setEnabled(false); imageGuess1.setEnabled(false); imageSound.setEnabled(false);
                    playAudioCorrect(); imageGuess3.startAnimation(zoom_in);
                    imageGuess2.startAnimation(no_zoom); imageGuess1.startAnimation(no_zoom);
                } else {
                    // Incorrect match
                    correctWrong3.setImageResource(R.mipmap.wrong_1);
                    imageGuess3.setEnabled(false);
                    imageGuess3.startAnimation(shake);
                    correctWrong3.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                }
            }
            return true;
        });

        imageSound.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                imageSound.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();
                media.start();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                imageSound.startAnimation(scaleDown);
                imageSound.setEnabled(false);
                media.setOnCompletionListener(mediaPlayer -> {
                    imageSound.setEnabled(true);
                });
            }
            return true;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void playGame() {
        // Select three random pictures
        List<Sound> images = new ArrayList<>(allSounds);
        Collections.shuffle(images);
        List<Sound> randomImages = images.subList(0, 3);

        sounds = randomImages.get(random.nextInt(randomImages.size()));
        int soundResourceId = sounds.getSoundResourcesId();
        for (Sound sound : allSounds) {
            if (sound.getSoundResourcesId() == soundResourceId && !randomImages.contains(sound)) {
                sounds = sound;
                break;
            }
        }
        // Display the selected pictures
        imageGuess1.setImageResource(randomImages.get(0).getImageResourceId());
        imageGuess2.setImageResource(randomImages.get(1).getImageResourceId());
        imageGuess3.setImageResource(randomImages.get(2).getImageResourceId());

        media = MediaPlayer.create(Matching_Sounds.this, sounds.getSoundResourcesId());

        imageGuess1ResourceIdName = randomImages.get(0).getSoundResourcesId();
        imageGuess2ResourceIdName = randomImages.get(1).getSoundResourcesId();
        imageGuess3ResourceIdName = randomImages.get(2).getSoundResourcesId();
        imageSoundResourceId = sounds.getSoundResourcesId();

    }

    private void dialog() {
        View alertCustomDialog = LayoutInflater.from(Matching_Sounds.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(Matching_Sounds.this);
        builder.setView(alertCustomDialog);

        Button go_back = alertCustomDialog.findViewById(R.id.Red_BT);
        Button new_game = alertCustomDialog.findViewById(R.id.Green_BT);

        alertDialog = builder.create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().getAttributes().windowAnimations = R.anim.scale_up;

        // show your alert dialog
        alertDialog.show();

        go_back.setOnClickListener(v -> {
            playAudioClick();
            Intent intent = new Intent(Matching_Sounds.this, GamesActivity.class);
            startActivity(intent);
            alertDialog.dismiss();
        });

        new_game.setOnClickListener(v -> {
            playAudioClick();
            alertDialog.dismiss();
            // Reset the UI widgets for the next round of the game
            media.reset();
            imageGuess1.setEnabled(true); imageGuess2.setEnabled(true); imageGuess3.setEnabled(true); imageSound.setEnabled(true);
            imageGuess1.setImageResource(0);
            imageGuess2.setImageResource(0);
            imageGuess3.setImageResource(0);
            correctWrong1.setImageResource(0);
            correctWrong2.setImageResource(0);
            correctWrong3.setImageResource(0);

            // Start the next round of the game
            playGame();
        });
    }

    public void finish() {
        super.finish();
        Intent intent = new Intent(Matching_Sounds.this, GamesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            voice = MediaPlayer.create(Matching_Sounds.this, R.raw.match_sound_voice);
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
            click = MediaPlayer.create(Matching_Sounds.this, R.raw.click);
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

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioCorrectTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            correct = MediaPlayer.create(Matching_Sounds.this, R.raw.correct);
            correct.start();
            correct.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                correct.release();
                correct = null;
                dialog();
            });
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
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

    private void playAudioCorrect() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioCorrectTask task = new PlayAudioCorrectTask();
        task.execute();
    }
}
