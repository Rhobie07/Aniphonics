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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PetActivity extends AppCompatActivity {

    private Button back;
    private ImageButton dog, cat, bird, parrot, mouse, squirrel, hamster, turtle, rabbit, frog;
    private MediaPlayer click, pet;
    private MediaPlayer dogName, catName, birdName, parrotName, mouseName, squirrelName, hamsterName, turtleName, rabbitName, frogName;
    private MediaPlayer dogSound, catSound, birdSound, parrotSound, mouseSound, squirrelSound, hamsterSound, turtleSound, rabbitSound, frogSound;
    private Animation scaleUp, scaleDown, button_up, shake;
    private ImageView dogText, catText, birdText, parrotText, mouseText, squirrelText, hamsterText, turtleText, rabbitText, frogText;


    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        back = findViewById(R.id.Back);
        dog = findViewById(R.id.Dog);
        cat = findViewById(R.id.Cat);
        bird = findViewById(R.id.Bird);
        parrot = findViewById(R.id.Parrot);
        mouse = findViewById(R.id.Mouse);
        squirrel = findViewById(R.id.Squirrel);
        hamster = findViewById(R.id.Hamster);
        turtle = findViewById(R.id.Turtle);
        rabbit = findViewById(R.id.Rabbit);
        frog = findViewById(R.id.Frog);
        dogText = findViewById(R.id.DogText);
        catText = findViewById(R.id.CatText);
        birdText = findViewById(R.id.BirdText);
        parrotText = findViewById(R.id.ParrotText);
        mouseText = findViewById(R.id.MouseText);
        squirrelText = findViewById(R.id.SquirrelText);
        hamsterText = findViewById(R.id.HamsterText);
        turtleText = findViewById(R.id.TurtleText);
        rabbitText = findViewById(R.id.RabbitText);
        frogText = findViewById(R.id.FrogText);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        button_up = AnimationUtils.loadAnimation(this, R.anim.button_up);
        shake = AnimationUtils.loadAnimation(this,R.anim.shake);

        dogName = MediaPlayer.create(PetActivity.this, R.raw.dog_name);
        dogSound = MediaPlayer.create(PetActivity.this, R.raw.dog_sound);
        catName = MediaPlayer.create(PetActivity.this, R.raw.cat_name);
        catSound = MediaPlayer.create(PetActivity.this, R.raw.cat_sound);
        birdName = MediaPlayer.create(PetActivity.this, R.raw.bird_name);
        birdSound = MediaPlayer.create(PetActivity.this, R.raw.bird_sound);
        parrotName = MediaPlayer.create(PetActivity.this, R.raw.parrot_name);
        parrotSound = MediaPlayer.create(PetActivity.this, R.raw.parrot_sound);
        mouseName = MediaPlayer.create(PetActivity.this, R.raw.mouse_name);
        mouseSound = MediaPlayer.create(PetActivity.this, R.raw.mouse_sound);
        squirrelName = MediaPlayer.create(PetActivity.this, R.raw.squirrel_name);
        squirrelSound = MediaPlayer.create(PetActivity.this, R.raw.squirrel_sound);
        hamsterName = MediaPlayer.create(PetActivity.this, R.raw.hamster_name);
        hamsterSound = MediaPlayer.create(PetActivity.this, R.raw.hamster_sound);
        turtleName = MediaPlayer.create(PetActivity.this, R.raw.turtle_name);
        turtleSound = MediaPlayer.create(PetActivity.this, R.raw.turtle_sound);
        rabbitName = MediaPlayer.create(PetActivity.this, R.raw.rabbit_name);
        rabbitSound = MediaPlayer.create(PetActivity.this, R.raw.rabbit_sound);
        frogName = MediaPlayer.create(PetActivity.this, R.raw.frog_name);
        frogSound = MediaPlayer.create(PetActivity.this, R.raw.frog_sound);

        playAudioVoice();

        ImageButton[] imageButtons = {dog, cat, bird, parrot, mouse, squirrel, hamster, turtle, rabbit, frog};
        MediaPlayer[] names = {dogName, catName, birdName, parrotName, mouseName, squirrelName, hamsterName, turtleName, rabbitName, frogName};
        MediaPlayer[] sounds = {dogSound, catSound, birdSound, parrotSound, mouseSound, squirrelSound, hamsterSound, turtleSound, rabbitSound, frogSound};

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
                Intent intent = new Intent(PetActivity.this, NamesSoundsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        dog.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            dog.startAnimation(button_up); dogText.startAnimation(shake);
            dogName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            dogName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    dogSound.start();
                }
            });
            dogSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        cat.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            cat.startAnimation(button_up); catText.startAnimation(shake);
            catName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            catName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    catSound.start();
                }
            });
            catSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        bird.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            bird.startAnimation(button_up); birdText.startAnimation(shake);
            birdName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            birdName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    birdSound.start();
                }
            });
            birdSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        parrot.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            parrot.startAnimation(button_up); parrotText.startAnimation(shake);
            parrotName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            parrotName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    parrotSound.start();
                }
            });
            parrotSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        mouse.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            mouse.startAnimation(button_up); mouseText.startAnimation(shake);
            mouseName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            mouseName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    mouseSound.start();
                }
            });
            mouseSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        squirrel.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            squirrel.startAnimation(button_up); squirrelText.startAnimation(shake);
            squirrelName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            squirrelName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    squirrelSound.start();
                }
            });
            squirrelSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        hamster.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            hamster.startAnimation(button_up); hamsterText.startAnimation(shake);
            hamsterName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            hamsterName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    hamsterSound.start();
                }
            });
            hamsterSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        turtle.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            turtle.startAnimation(button_up); turtleText.startAnimation(shake);
            turtleName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            turtleName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    turtleSound.start();
                }
            });
            turtleSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        rabbit.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            rabbit.startAnimation(button_up); rabbitText.startAnimation(shake);
            rabbitName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            rabbitName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    rabbitSound.start();
                }
            });
            rabbitSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        frog.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            frog.startAnimation(button_up); frogText.startAnimation(shake);
            frogName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            frogName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    frogSound.start();
                }
            });
            frogSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(PetActivity.this, NamesSoundsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            pet = MediaPlayer.create(PetActivity.this, R.raw.pet_voice);
            pet.start();
            pet.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                pet.release();
                pet= null;
            });
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }

        public void stopAudio() {
            if (pet != null) {
                pet.stop();
                pet.release();
                pet = null;
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioClickTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            click = MediaPlayer.create(PetActivity.this, R.raw.click);
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
