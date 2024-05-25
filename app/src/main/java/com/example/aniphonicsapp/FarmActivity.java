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
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FarmActivity extends AppCompatActivity {

    private Button back;
    private ImageView pigText, horseText, cowText, henText, roosterText, turkeyText, sheepText, goatText, fishText, duckText;
    private MediaPlayer click, farm;
    private MediaPlayer pigName, cowName, horseName, henName, roosterName, turkeyName, sheepName, goatName, fishName, duckName;
    private MediaPlayer pigSound, cowSound, horseSound, henSound, roosterSound, turkeySound, sheepSound, goatSound, fishSound, duckSound;
    private Animation scaleUp, scaleDown, button_up, shake;
    private ImageButton pig, cow, horse, hen, rooster, turkey, sheep, goat, fish, duck;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        back = findViewById(R.id.Back);
        pig = findViewById(R.id.Pig);
        cow = findViewById(R.id.Cow);
        horse = findViewById(R.id.Horse);
        hen = findViewById(R.id.Hen);
        rooster = findViewById(R.id.Rooster);
        turkey = findViewById(R.id.Turkey);
        sheep = findViewById(R.id.Sheep);
        goat = findViewById(R.id.Goat);
        fish = findViewById(R.id.Fish);
        duck = findViewById(R.id.Duck);
        pigText = findViewById(R.id.PigText);
        horseText = findViewById(R.id.HorseText);
        cowText = findViewById(R.id.CowText);
        henText = findViewById(R.id.HenText);
        roosterText = findViewById(R.id.RoosterText);
        turkeyText = findViewById(R.id.TurkeyText);
        sheepText = findViewById(R.id.SheepText);
        goatText = findViewById(R.id.GoatText);
        fishText = findViewById(R.id.FishText);
        duckText = findViewById(R.id.DuckText);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        button_up = AnimationUtils.loadAnimation(this, R.anim.button_up);
        shake = AnimationUtils.loadAnimation(this,R.anim.shake);

        sheepName = MediaPlayer.create(FarmActivity.this, R.raw.sheep_name);
        sheepSound = MediaPlayer.create(FarmActivity.this, R.raw.sheep_sound);

        playAudioVoice();

        pigName = MediaPlayer.create(FarmActivity.this, R.raw.pig_name);
        pigSound = MediaPlayer.create(FarmActivity.this, R.raw.pig_sound);
        horseName = MediaPlayer.create(FarmActivity.this, R.raw.horse_name);
        horseSound = MediaPlayer.create(FarmActivity.this, R.raw.horse_sound);
        cowName = MediaPlayer.create(FarmActivity.this, R.raw.cow_name);
        cowSound = MediaPlayer.create(FarmActivity.this, R.raw.cow_sound);
        henName = MediaPlayer.create(FarmActivity.this, R.raw.hen_name);
        henSound = MediaPlayer.create(FarmActivity.this, R.raw.hen_sound);
        roosterName = MediaPlayer.create(FarmActivity.this, R.raw.rooster_name);
        roosterSound = MediaPlayer.create(FarmActivity.this, R.raw.rooster_sound);
        turkeyName = MediaPlayer.create(FarmActivity.this, R.raw.turkey_name);
        turkeySound = MediaPlayer.create(FarmActivity.this, R.raw.turkey_sound);
        fishName = MediaPlayer.create(FarmActivity.this, R.raw.fish_name);
        fishSound = MediaPlayer.create(FarmActivity.this, R.raw.fish_sound);
        duckName = MediaPlayer.create(FarmActivity.this, R.raw.duck_name);
        duckSound = MediaPlayer.create(FarmActivity.this, R.raw.duck_sound);
        goatName = MediaPlayer.create(FarmActivity.this, R.raw.goat_name);
        goatSound = MediaPlayer.create(FarmActivity.this, R.raw.goat_sound);
        sheepName = MediaPlayer.create(FarmActivity.this, R.raw.sheep_name);
        sheepSound = MediaPlayer.create(FarmActivity.this, R.raw.sheep_sound);

        ImageButton[] imageButtons = {pig, cow, horse, hen, rooster, turkey,sheep, goat, fish, duck};
        MediaPlayer[] names = {pigName, cowName, horseName, henName, roosterName, turkeyName, sheepName, goatName, fishName, duckName};
        MediaPlayer[] sounds = {pigSound, cowSound, horseSound, henSound, roosterSound, turkeySound, sheepSound, goatSound, fishSound, duckSound};

        back.setOnTouchListener((v, event) -> {

            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                back.startAnimation(scaleUp);
                playAudioClick(); stopAudioVoice();
                for (MediaPlayer name : names) {
                    name.stop();
                }
                for (MediaPlayer sound : sounds) {
                    sound.stop();
                }
            }else if(event.getAction()== MotionEvent.ACTION_UP){
                back.startAnimation(scaleDown);
                Intent intent = new Intent(FarmActivity.this, NamesSoundsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        pig.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            pig.startAnimation(button_up); pigText.startAnimation(shake);
            pigName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            pigName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    pigSound.start();
                }
            });
            pigSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        horse.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            horse.startAnimation(button_up); horseText.startAnimation(shake);
            horseName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            horseName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    horseSound.start();
                }
            });
            horseSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        cow.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            cow.startAnimation(button_up); cowText.startAnimation(shake);
            cowName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            cowName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    cowSound.start();
                }
            });
            cowSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        hen.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            hen.startAnimation(button_up); henText.startAnimation(shake);
            henName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            henName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    henSound.start();
                }
            });
            henSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        rooster.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            rooster.startAnimation(button_up); roosterText.startAnimation(shake);
            roosterName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            roosterName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    roosterSound.start();
                }
            });
            roosterSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        turkey.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            turkey.startAnimation(button_up); turkeyText.startAnimation(shake);
            turkeyName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            turkeyName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    turkeySound.start();
                }
            });
            turkeySound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        fish.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            fish.startAnimation(button_up); fishText.startAnimation(shake);
            fishName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            fishName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    fishSound.start();
                }
            });
            fishSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        duck.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            duck.startAnimation(button_up); duckText.startAnimation(shake);
            duckName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            duckName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    duckSound.start();
                }
            });
            duckSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        goat.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            goat.startAnimation(button_up); goatText.startAnimation(shake);
            goatName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            goatName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    goatSound.start();
                }
            });
            goatSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        sheep.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            sheep.startAnimation(button_up); sheepText.startAnimation(shake);
            sheepName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            sheepName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    sheepSound.start();
                }
            });
            sheepSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(FarmActivity.this, NamesSoundsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            farm = MediaPlayer.create(FarmActivity.this, R.raw.farm_voice);
            farm.start();
            farm.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                farm.release();
                farm = null;
            });
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }
        public void stopAudio() {
            if (farm != null) {
                farm.stop();
                farm.release();
                farm = null;
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioClickTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            click = MediaPlayer.create(FarmActivity.this, R.raw.click);
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