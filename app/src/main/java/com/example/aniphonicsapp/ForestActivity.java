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

public class ForestActivity extends AppCompatActivity {

    private Button back;
    private ImageView elephantText, hippoText, lionText, zebraText, wolfText, giraffeText, tigerText, bearText, kangarooText, monkeyText, pandaText, snakeText;
    private MediaPlayer click, forest;
    private MediaPlayer elephantName, hippoName, lionName, zebraName, wolfName, giraffeName, tigerName, bearName, kangarooName, monkeyName, pandaName, snakeName;
    private MediaPlayer elephantSound, hippoSound, lionSound, zebraSound, wolfSound, giraffeSound, tigerSound, bearSound, kangarooSound, monkeySound, pandaSound, snakeSound;
    private Animation scaleUp, scaleDown, button_up, shake;
    private ImageButton elephant, hippo, lion, zebra, wolf, giraffe, tiger, bear,kangaroo, monkey, panda, snake;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forest);

        back = findViewById(R.id.Back);
        elephant  = findViewById(R.id.Elephant);
        hippo = findViewById(R.id.Hippo);
        lion = findViewById(R.id.Lion);
        zebra = findViewById(R.id.Zebra);
        wolf = findViewById(R.id.Wolf);
        giraffe = findViewById(R.id.Giraffe);
        tiger = findViewById(R.id.Tiger);
        bear = findViewById(R.id.Bear);
        kangaroo = findViewById(R.id.Kangaroo);
        monkey = findViewById(R.id.Monkey);
        panda = findViewById(R.id.Panda);
        snake = findViewById(R.id.Snake);

        elephantText = findViewById(R.id.ElephantText);
        hippoText = findViewById(R.id.HippoText);
        lionText = findViewById(R.id.LionText);
        zebraText = findViewById(R.id.ZebraText);
        wolfText = findViewById(R.id.WolfText);
        giraffeText = findViewById(R.id.GiraffeText);
        tigerText = findViewById(R.id.TigerText);
        bearText = findViewById(R.id.BearText);
        kangarooText = findViewById(R.id.KangarooText);
        monkeyText = findViewById(R.id.MonkeyText);
        pandaText = findViewById(R.id.PandaText);
        snakeText = findViewById(R.id.SnakeText);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        button_up = AnimationUtils.loadAnimation(this, R.anim.button_up);
        shake = AnimationUtils.loadAnimation(this,R.anim.shake);

        elephantName = MediaPlayer.create(ForestActivity.this, R.raw.elephant_name);
        elephantSound = MediaPlayer.create(ForestActivity.this, R.raw.elephant_sound);
        hippoName = MediaPlayer.create(ForestActivity.this, R.raw.hippo_name);
        hippoSound = MediaPlayer.create(ForestActivity.this, R.raw.hippo_sound);
        lionName = MediaPlayer.create(ForestActivity.this, R.raw.lion_name);
        lionSound = MediaPlayer.create(ForestActivity.this, R.raw.lion_sound);
        zebraName = MediaPlayer.create(ForestActivity.this, R.raw.zebra_name);
        zebraSound = MediaPlayer.create(ForestActivity.this, R.raw.zebra_sound);
        wolfName = MediaPlayer.create(ForestActivity.this, R.raw.wolf_name);
        wolfSound = MediaPlayer.create(ForestActivity.this, R.raw.wolf_sound);
        giraffeName = MediaPlayer.create(ForestActivity.this, R.raw.giraffe_name);
        giraffeSound = MediaPlayer.create(ForestActivity.this, R.raw.giraffe_sound);
        tigerName = MediaPlayer.create(ForestActivity.this, R.raw.tiger_name);
        tigerSound = MediaPlayer.create(ForestActivity.this, R.raw.tiger_sound);
        bearName = MediaPlayer.create(ForestActivity.this, R.raw.bear_name);
        bearSound = MediaPlayer.create(ForestActivity.this, R.raw.bear_sound);
        kangarooName = MediaPlayer.create(ForestActivity.this, R.raw.kangaroo_name);
        kangarooSound = MediaPlayer.create(ForestActivity.this, R.raw.kangaroo_sound);
        monkeyName = MediaPlayer.create(ForestActivity.this, R.raw.monkey_name);
        monkeySound = MediaPlayer.create(ForestActivity.this, R.raw.monkey_sound);
        snakeName = MediaPlayer.create(ForestActivity.this, R.raw.snake_name);
        snakeSound = MediaPlayer.create(ForestActivity.this, R.raw.snake_sound);
        pandaName = MediaPlayer.create(ForestActivity.this, R.raw.panda_name);
        pandaSound = MediaPlayer.create(ForestActivity.this, R.raw.panda_sound);

        playAudioVoice();

        ImageButton[] imageButtons = {elephant, hippo, lion, zebra, wolf, giraffe, tiger, bear,kangaroo, monkey, panda, snake};
        MediaPlayer[] names = {elephantName, hippoName, lionName, zebraName, wolfName, giraffeName, tigerName, bearName, kangarooName, monkeyName, pandaName, snakeName};
        MediaPlayer[] sounds = {elephantSound, hippoSound, lionSound, zebraSound, wolfSound, giraffeSound, tigerSound, bearSound, kangarooSound, monkeySound, pandaSound, snakeSound};

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
                Intent intent = new Intent(ForestActivity.this, NamesSoundsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        elephant.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            elephant.startAnimation(button_up); elephantText.startAnimation(shake);
            elephantName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            elephantName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    elephantSound.start();
                }
            });
            elephantSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        hippo.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            hippo.startAnimation(button_up); hippoText.startAnimation(shake);
            hippoName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            hippoName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    hippoSound.start();
                }
            });
            hippoSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        lion.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            lion.startAnimation(button_up); lionText.startAnimation(shake);
            lionName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            lionName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    lionSound.start();
                }
            });
            lionSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        zebra.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            zebra.startAnimation(button_up); zebraText.startAnimation(shake);
            zebraName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            zebraName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    zebraSound.start();
                }
            });
            zebraSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        wolf.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            wolf.startAnimation(button_up); wolfText.startAnimation(shake);
            wolfName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            wolfName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    wolfSound.start();
                }
            });
            wolfSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        giraffe.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            giraffe.startAnimation(button_up); giraffeText.startAnimation(shake);
            giraffeName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            giraffeName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    giraffeSound.start();
                }
            });
            giraffeSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        tiger.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            tiger.startAnimation(button_up); tigerText.startAnimation(shake);
            tigerName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            tigerName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    tigerSound.start();
                }
            });
            tigerSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        bear.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            bear.startAnimation(button_up); bearText.startAnimation(shake);
            bearName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            bearName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    bearSound.start();
                }
            });
            bearSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        kangaroo.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            kangaroo.startAnimation(button_up); kangarooText.startAnimation(shake);
            kangarooName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            kangarooName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    kangarooSound.start();
                }
            });
            kangarooSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        monkey.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            monkey.startAnimation(button_up); monkeyText.startAnimation(shake);
            monkeyName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            monkeyName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    monkeySound.start();
                }
            });
            monkeySound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        snake.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            snake.startAnimation(button_up); snakeText.startAnimation(shake);
            snakeName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            snakeName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    snakeSound.start();
                }
            });
            snakeSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });

        panda.setOnClickListener(v -> {
            playAudioClick(); stopAudioVoice();
            panda.startAnimation(button_up); pandaText.startAnimation(shake);
            pandaName.start();
            for (ImageButton imageButton : imageButtons) {
                imageButton.setClickable(false);
            }
            pandaName.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    pandaSound.start();
                }
            });
            pandaSound.setOnCompletionListener(mp -> {
                for (ImageButton imageButton : imageButtons) {
                    imageButton.setClickable(true);
                }
            });
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(ForestActivity.this, NamesSoundsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            forest = MediaPlayer.create(ForestActivity.this, R.raw.forest_voice);
            forest.start();
            forest.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                forest.release();
                forest = null;
            });
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }

        public void stopAudio() {
            if (forest != null) {
                forest.stop();
                forest.release();
                forest = null;
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioClickTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            click = MediaPlayer.create(ForestActivity.this, R.raw.click);
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
