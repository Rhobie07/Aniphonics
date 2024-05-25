package com.example.aniphonicsapp.Matching_Name;

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

public class Matching_Name extends AppCompatActivity {
    private ArrayList<Picture> allPictures;
    private Random random = new Random();
    private ImageView imageView4, correctWrong1, correctWrong2, correctWrong3;
    private ImageButton imageGuess1, imageGuess2, imageGuess3;
    private MediaPlayer voice, click, media, correct;
    private Button back;
    private Animation scaleUp, scaleDown, zoom_in, no_zoom, shake;
    private Picture fourthImage;
    private AlertDialog alertDialog;
    private int imageGuess1ResourceIdName,imageGuess2ResourceIdName,imageGuess3ResourceIdName,imageView4ResourceId;

    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching_name);

        allPictures = new ArrayList<>();
        allPictures.add(new Picture(R.drawable.dog, R.drawable.dog_text, R.raw.dog_name));
        allPictures.add(new Picture(R.drawable.cat,  R.drawable.cat_text, R.raw.cat_name));
        allPictures.add(new Picture(R.drawable.bird,  R.drawable.bird_text, R.raw.bird_name));
        allPictures.add(new Picture(R.drawable.turtle,  R.drawable.turtle_text, R.raw.turtle_name));
        allPictures.add(new Picture(R.drawable.frog,  R.drawable.frog_text, R.raw.frog_name));
        allPictures.add(new Picture(R.drawable.parrot,  R.drawable.parrot_text, R.raw.parrot_name));
        allPictures.add(new Picture(R.drawable.mouse,  R.drawable.mouse_text, R.raw.mouse_name));
        allPictures.add(new Picture(R.drawable.hamster,  R.drawable.hamster_text, R.raw.hamster_name));
        allPictures.add(new Picture(R.drawable.squirrel,  R.drawable.squirrel_text, R.raw.squirrel_name));
        allPictures.add(new Picture(R.drawable.rabbit,  R.drawable.rabbit_text, R.raw.rabbit_name));
        allPictures.add(new Picture(R.drawable.lion,  R.drawable.lion_text, R.raw.lion_name));
        allPictures.add(new Picture(R.drawable.monkey,  R.drawable.monkey_text, R.raw.monkey_name));
        allPictures.add(new Picture(R.drawable.elephant,  R.drawable.elephant_text, R.raw.elephant_name));
        allPictures.add(new Picture(R.drawable.hippo,  R.drawable.hippo_text, R.raw.hippo_name));
        allPictures.add(new Picture(R.drawable.zebra,  R.drawable.zebra_text, R.raw.zebra_name));
        allPictures.add(new Picture(R.drawable.wolf,  R.drawable.wolf_text, R.raw.wolf_name));
        allPictures.add(new Picture(R.drawable.giraffe,  R.drawable.giraffe_text, R.raw.giraffe_name));
        allPictures.add(new Picture(R.drawable.tiger,  R.drawable.tiger_text, R.raw.tiger_name));
        allPictures.add(new Picture(R.drawable.bear,  R.drawable.bear_text, R.raw.bear_name));
        allPictures.add(new Picture(R.drawable.kangaroo,  R.drawable.kangaroo_text, R.raw.kangaroo_name));
        allPictures.add(new Picture(R.drawable.panda,  R.drawable.panda_text, R.raw.panda_name));
        allPictures.add(new Picture(R.drawable.snake,  R.drawable.snake_text, R.raw.snake_name));
        allPictures.add(new Picture(R.drawable.cow,  R.drawable.cow_text, R.raw.cow_name));
        allPictures.add(new Picture(R.drawable.pig,  R.drawable.pig_text, R.raw.pig_name));
        allPictures.add(new Picture(R.drawable.fish,  R.drawable.fish_text, R.raw.fish_name));
        allPictures.add(new Picture(R.drawable.horse,  R.drawable.horse_text, R.raw.horse_name));
        allPictures.add(new Picture(R.drawable.hen,  R.drawable.hen_text, R.raw.hen_name));
        allPictures.add(new Picture(R.drawable.turkey,  R.drawable.turkey_text, R.raw.turkey_name));
        allPictures.add(new Picture(R.drawable.duck,  R.drawable.duck_text, R.raw.duck_name));
        allPictures.add(new Picture(R.drawable.rooster,  R.drawable.rooster_text, R.raw.rooster_name));
        allPictures.add(new Picture(R.drawable.goat,  R.drawable.goat_text, R.raw.goat_name));
        allPictures.add(new Picture(R.drawable.sheep,  R.drawable.sheep_text, R.raw.sheep_name));
        // add more pictures to the array

        // Get references to the UI widgets
        imageGuess1 = findViewById(R.id.imageGuess1);
        imageGuess2 = findViewById(R.id.imageGuess2);
        imageGuess3 = findViewById(R.id.imageGuess3);
        imageView4 = findViewById(R.id.imageView4);
        correctWrong1 = findViewById(R.id.correctWrong1);
        correctWrong2 = findViewById(R.id.correctWrong2);
        correctWrong3 = findViewById(R.id.correctWrong3);

        // Start the game
        playGame();


        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        zoom_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        no_zoom = AnimationUtils.loadAnimation(this, R.anim.no_zoom);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        back = findViewById(R.id.Back);
        back.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                back.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                back.startAnimation(scaleDown);
                Intent intent = new Intent(Matching_Name.this, GamesActivity.class);
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
                if (imageGuess1ResourceIdName == imageView4ResourceId) {
                    // Correct match
                    correctWrong1.setImageResource(R.mipmap.correct_1);
                    correctWrong1.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess2.setEnabled(false); imageGuess3.setEnabled(false);
                    playAudioCorrect(); imageGuess1.startAnimation(zoom_in);
                    imageGuess2.startAnimation(no_zoom); imageGuess3.startAnimation(no_zoom);
                    media.start();
                    media.setOnCompletionListener(mediaPlayer -> {
                        dialog();
                    });
                } else {
                    // Incorrect match
                    imageGuess1.setEnabled(false); imageGuess1.startAnimation(shake);
                    correctWrong1.setImageResource(R.mipmap.wrong_1);
                    correctWrong1.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
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
                if (imageGuess2ResourceIdName == imageView4ResourceId) {
                    correctWrong2.setImageResource(R.mipmap.correct_1);
                    correctWrong2.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess1.setEnabled(false); imageGuess3.setEnabled(false);
                    playAudioCorrect(); imageGuess2.startAnimation(zoom_in);
                    imageGuess1.startAnimation(no_zoom); imageGuess3.startAnimation(no_zoom);
                    media.start();
                    media.setOnCompletionListener(mediaPlayer -> {
                        dialog();
                    });
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
                if (imageGuess3ResourceIdName == imageView4ResourceId) {
                    correctWrong3.setImageResource(R.mipmap.correct_1);
                    correctWrong3.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                    imageGuess2.setEnabled(false); imageGuess1.setEnabled(false);
                    playAudioCorrect(); imageGuess3.startAnimation(zoom_in);
                    imageGuess2.startAnimation(no_zoom); imageGuess1.startAnimation(no_zoom);
                    media.start();
                    media.setOnCompletionListener(mediaPlayer -> {
                        dialog();
                    });
                } else {
                    // Incorrect match
                    imageGuess3.setEnabled(false); imageGuess3.startAnimation(shake);
                    correctWrong3.setImageResource(R.mipmap.wrong_1);
                    correctWrong3.startAnimation(AnimationUtils.loadAnimation(
                            getApplicationContext(),
                            R.anim.zoom_in_faster
                    ));
                }
            }
            return true;
        });
    }

    private void playGame() {
        // Select three random pictures
        List<Picture> pictures = new ArrayList<>(allPictures);
        Collections.shuffle(pictures);
        List<Picture> randomImages = pictures.subList(0, 3);

        fourthImage = randomImages.get(random.nextInt(randomImages.size()));
        int fourthImageNameResourceId = fourthImage.getImageResourcesIdName();
        for (Picture picture : allPictures) {
            if (picture.getImageResourcesIdName() == fourthImageNameResourceId && !randomImages.contains(picture)) {
                fourthImage = picture;
                break;
            }
        }


        // Display the selected pictures
        imageGuess1.setImageResource(randomImages.get(0).getImageResourceId());
        imageGuess2.setImageResource(randomImages.get(1).getImageResourceId());
        imageGuess3.setImageResource(randomImages.get(2).getImageResourceId());
        imageView4.setImageResource(fourthImage.getImageResourcesIdName());
        media = MediaPlayer.create(Matching_Name.this, fourthImage.getSoundNameResourceId());

        imageGuess1ResourceIdName = randomImages.get(0).getImageResourcesIdName();
        imageGuess2ResourceIdName = randomImages.get(1).getImageResourcesIdName();
        imageGuess3ResourceIdName = randomImages.get(2).getImageResourcesIdName();
        imageView4ResourceId = fourthImage.getImageResourcesIdName();

    }

    private void dialog() {
        View alertCustomDialog = LayoutInflater.from(Matching_Name.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(Matching_Name.this);
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
            Intent intent = new Intent(Matching_Name.this, GamesActivity.class);
            startActivity(intent);
            alertDialog.dismiss();
        });

        new_game.setOnClickListener(v -> {
            playAudioClick();
            alertDialog.dismiss();
            // Reset the UI widgets for the next round of the game
            media.stop();
            imageGuess1.setEnabled(true); imageGuess2.setEnabled(true); imageGuess3.setEnabled(true);
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
        Intent intent = new Intent(Matching_Name.this, GamesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            voice = MediaPlayer.create(Matching_Name.this, R.raw.match_name_voice);
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
            click = MediaPlayer.create(Matching_Name.this, R.raw.click);
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
            correct = MediaPlayer.create(Matching_Name.this, R.raw.correct);
            correct.start();
            correct.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                correct.release();
                correct = null;
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
