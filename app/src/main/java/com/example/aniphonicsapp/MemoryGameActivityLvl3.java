package com.example.aniphonicsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;


public class MemoryGameActivityLvl3 extends AppCompatActivity {

    private Button back;
    private MediaPlayer voice, click, correct, win;
    private Animation scaleUp, scaleDown;
    private ImageView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20;
    private final Integer[] cardsArray = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    private int image10, image11, image12, image13, image14, image15, image16, image17, image18, image19, image20, image21, image22, image23, image24, image25, image26, image27, image28, image29;
    private int firstCard, secondCard;
    private int clickedFirst, clickedSecond;
    private int cardNumber = 1;
    private AlertDialog alertDialog;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize_game_lvl3);

        playAudioVoice();

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        card9 = findViewById(R.id.card9);
        card10 = findViewById(R.id.card10);
        card11 = findViewById(R.id.card11);
        card12 = findViewById(R.id.card12);
        card13 = findViewById(R.id.card13);
        card14 = findViewById(R.id.card14);
        card15 = findViewById(R.id.card15);
        card16 = findViewById(R.id.card16);
        card17 = findViewById(R.id.card17);
        card18 = findViewById(R.id.card18);
        card19 = findViewById(R.id.card19);
        card20 = findViewById(R.id.card20);

        card1.setTag("0");
            card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");
        card5.setTag("4");
        card6.setTag("5");
        card7.setTag("6");
        card8.setTag("7");
        card9.setTag("8");
        card10.setTag("9");
        card11.setTag("10");
        card12.setTag("11");
        card13.setTag("12");
        card14.setTag("13");
        card15.setTag("14");
        card16.setTag("15");
        card17.setTag("16");
        card18.setTag("17");
        card19.setTag("18");
        card20.setTag("19");

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        back = findViewById(R.id.Back);
        back.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN) {
                back.startAnimation(scaleUp);
                stopAudioVoice();
                playAudioClick();

            }else if(event.getAction()== MotionEvent.ACTION_UP){
                back.startAnimation(scaleDown);
                Intent intent = new Intent(MemoryGameActivityLvl3.this, GamesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });

        card1.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card1, theCard);
            playAudioClick();
        });

        card2.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card2, theCard);
            playAudioClick();
        });

        card3.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card3, theCard);
            playAudioClick();
        });

        card4.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card4, theCard);
            playAudioClick();
        });

        card5.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card5, theCard);
            playAudioClick();
        });

        card6.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card6, theCard);
            playAudioClick();
        });

        card7.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card7, theCard);
            playAudioClick();
        });

        card8.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card8, theCard);
            playAudioClick();
        });

        card9.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card9, theCard);
            playAudioClick();
        });

        card10.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card10, theCard);
            playAudioClick();
        });

        card11.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card11, theCard);
            playAudioClick();
        });

        card12.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card12, theCard);
            playAudioClick();
        });

        card13.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card13, theCard);
            playAudioClick();
        });

        card14.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card14, theCard);
            playAudioClick();
        });

        card15.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card15, theCard);
            playAudioClick();
        });

        card16.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card16, theCard);
            playAudioClick();
        });

        card17.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card17, theCard);
            playAudioClick();
        });

        card18.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card18, theCard);
            playAudioClick();
        });

        card19.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card19, theCard);
            playAudioClick();
        });

        card20.setOnClickListener(v -> {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(card20, theCard);
            playAudioClick();
        });
    }

    private void doStuff(ImageView iv, int card) {
        if(cardsArray[card] == 10) {
            iv.setImageResource(image10);
        } else if(cardsArray[card] == 11) {
            iv.setImageResource(image11);
        } else if(cardsArray[card] == 12) {
            iv.setImageResource(image12);
        } else if(cardsArray[card] == 13) {
            iv.setImageResource(image13);
        } else if(cardsArray[card] == 14) {
            iv.setImageResource(image14);
        } else if(cardsArray[card] == 15) {
            iv.setImageResource(image15);
        } else if(cardsArray[card] == 16) {
            iv.setImageResource(image16);
        } else if(cardsArray[card] == 17) {
            iv.setImageResource(image17);
        } else if(cardsArray[card] == 18) {
            iv.setImageResource(image18);
        } else if(cardsArray[card] == 19) {
            iv.setImageResource(image19);
        } else if(cardsArray[card] == 20) {
            iv.setImageResource(image20);
        } else if(cardsArray[card] == 21) {
            iv.setImageResource(image21);
        } else if(cardsArray[card] == 22) {
            iv.setImageResource(image22);
        } else if(cardsArray[card] == 23) {
            iv.setImageResource(image23);
        } else if(cardsArray[card] == 24) {
            iv.setImageResource(image24);
        } else if(cardsArray[card] == 25) {
            iv.setImageResource(image25);
        } else if(cardsArray[card] == 26) {
            iv.setImageResource(image26);
        } else if(cardsArray[card] == 27) {
            iv.setImageResource(image27);
        } else if(cardsArray[card] == 28) {
            iv.setImageResource(image28);
        } else if(cardsArray[card] == 29) {
            iv.setImageResource(image29);
        }

        if(cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard >= 20) {
                firstCard = firstCard - 10;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if(cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard >= 20) {
                secondCard = secondCard - 10;
            }
            cardNumber = 1;
            clickedSecond = card;

            card1.setEnabled(false);
            card2.setEnabled(false);
            card3.setEnabled(false);
            card4.setEnabled(false);
            card5.setEnabled(false);
            card6.setEnabled(false);
            card7.setEnabled(false);
            card8.setEnabled(false);
            card9.setEnabled(false);
            card10.setEnabled(false);
            card11.setEnabled(false);
            card12.setEnabled(false);
            card13.setEnabled(false);
            card14.setEnabled(false);
            card15.setEnabled(false);
            card16.setEnabled(false);
            card17.setEnabled(false);
            card18.setEnabled(false);
            card19.setEnabled(false);
            card20.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(this::calculate, 500);
        }
    }

    private void calculate() {
        if(firstCard == secondCard) {
            playAudioCorrect();
            if (clickedFirst == 0) {
                card1.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                card2.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                card3.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                card4.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                card5.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                card6.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                card7.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                card8.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                card9.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                card10.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                card11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                card12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                card13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                card14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                card15.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                card16.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {
                card17.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {
                card18.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {
                card19.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {
                card20.setVisibility(View.INVISIBLE);
            }





            if (clickedSecond == 0) {
                card1.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 1) {
                card2.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 2) {
                card3.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 3) {
                card4.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 4) {
                card5.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 5) {
                card6.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 6) {
                card7.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 7) {
                card8.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 8) {
                card9.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 9) {
                card10.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 10) {
                card11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 11) {
                card12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 12) {
                card13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 13) {
                card14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 14) {
                card15.setVisibility(View.INVISIBLE);
            } else if (clickedSecond  == 15) {
                card16.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {
                card17.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {
                card18.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {
                card19.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {
                card20.setVisibility(View.INVISIBLE);
            }

        } else {
            card1.setImageResource(R.drawable.back_card);
            card2.setImageResource(R.drawable.back_card);
            card3.setImageResource(R.drawable.back_card);
            card4.setImageResource(R.drawable.back_card);
            card5.setImageResource(R.drawable.back_card);
            card6.setImageResource(R.drawable.back_card);
            card7.setImageResource(R.drawable.back_card);
            card8.setImageResource(R.drawable.back_card);
            card9.setImageResource(R.drawable.back_card);
            card10.setImageResource(R.drawable.back_card);
            card11.setImageResource(R.drawable.back_card);
            card12.setImageResource(R.drawable.back_card);
            card13.setImageResource(R.drawable.back_card);
            card14.setImageResource(R.drawable.back_card);
            card15.setImageResource(R.drawable.back_card);
            card16.setImageResource(R.drawable.back_card);
            card17.setImageResource(R.drawable.back_card);
            card18.setImageResource(R.drawable.back_card);
            card19.setImageResource(R.drawable.back_card);
            card20.setImageResource(R.drawable.back_card);
        }

        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
        card5.setEnabled(true);
        card6.setEnabled(true);
        card7.setEnabled(true);
        card8.setEnabled(true);
        card9.setEnabled(true);
        card10.setEnabled(true);
        card11.setEnabled(true);
        card12.setEnabled(true);
        card13.setEnabled(true);
        card14.setEnabled(true);
        card15.setEnabled(true);
        card16.setEnabled(true);
        card17.setEnabled(true);
        card18.setEnabled(true);
        card19.setEnabled(true);
        card20.setEnabled(true);

        checkEnd();
    }

    private void checkEnd() {
        if (card1.getVisibility() == View.INVISIBLE &&
                card1.getVisibility() == View.INVISIBLE &&
                card2.getVisibility() == View.INVISIBLE &&
                card3.getVisibility() == View.INVISIBLE &&
                card4.getVisibility() == View.INVISIBLE &&
                card5.getVisibility() == View.INVISIBLE &&
                card6.getVisibility() == View.INVISIBLE &&
                card7.getVisibility() == View.INVISIBLE &&
                card8.getVisibility() == View.INVISIBLE &&
                card9.getVisibility() == View.INVISIBLE &&
                card10.getVisibility() == View.INVISIBLE &&
                card11.getVisibility() == View.INVISIBLE &&
                card12.getVisibility() == View.INVISIBLE &&
                card13.getVisibility() == View.INVISIBLE &&
                card14.getVisibility() == View.INVISIBLE &&
                card15.getVisibility() == View.INVISIBLE &&
                card16.getVisibility() == View.INVISIBLE &&
                card17.getVisibility() == View.INVISIBLE &&
                card18.getVisibility() == View.INVISIBLE &&
                card19.getVisibility() == View.INVISIBLE &&
                card20.getVisibility() == View.INVISIBLE) {

            View alertCustomDialog = LayoutInflater.from(MemoryGameActivityLvl3.this).inflate(R.layout.custom_dialog, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(MemoryGameActivityLvl3.this);
            builder.setView(alertCustomDialog);

            Button go_back = alertCustomDialog.findViewById(R.id.Red_BT);
            Button new_game = alertCustomDialog.findViewById(R.id.Green_BT);

            alertDialog = builder.create();

            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;


            // show your alert dialog
            alertDialog.show();

            playAudioWin();

            go_back.setOnClickListener(v -> {
                playAudioClick();
                Intent intent = new Intent(MemoryGameActivityLvl3.this, GamesActivity.class);
                startActivity(intent);
                finish();
            });

            new_game.setOnClickListener(v -> {
                playAudioClick();
                Intent intent = new Intent(getApplicationContext(), MemoryGameActivityLvl1.class);
                startActivity(intent);
                alertDialog.dismiss();
            });
        }

    }


    private void frontOfCardsResources() {
        image10 = R.drawable.front_card_monkey1;
        image11 = R.drawable.front_card_cat1;
        image12 = R.drawable.front_card_dog1;
        image13 = R.drawable.front_card_cow1;
        image14 = R.drawable.front_card_goat1;
        image15 = R.drawable.front_card_duck1;
        image16 = R.drawable.front_card_lion1;
        image17 = R.drawable.front_card_elephant1;
        image18 = R.drawable.front_card_giraffe1;
        image19 = R.drawable.front_card_parrot1;
        image20 = R.drawable.front_card_monkey2;
        image21 = R.drawable.front_card_cat2;
        image22 = R.drawable.front_card_dog2;
        image23 = R.drawable.front_card_cow2;
        image24 = R.drawable.front_card_goat2;
        image25 = R.drawable.front_card_duck2;
        image26 = R.drawable.front_card_lion2;
        image27 = R.drawable.front_card_elephant2;
        image28 = R.drawable.front_card_giraffe2;
        image29 = R.drawable.front_card_parrot2;

    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(MemoryGameActivityLvl3.this, GamesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    protected void onDestroy() {
        super.onDestroy();

        // dismiss your alert dialog if it is showing
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }


    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            voice = MediaPlayer.create(MemoryGameActivityLvl3.this, R.raw.memory_voice);
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
            click = MediaPlayer.create(MemoryGameActivityLvl3.this, R.raw.click);
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

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioCorrectTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            correct = MediaPlayer.create(MemoryGameActivityLvl3.this, R.raw.correct);
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

    @SuppressLint("StaticFieldLeak")
    private final class PlayAudioWinTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            win = MediaPlayer.create(MemoryGameActivityLvl3.this, R.raw.win_game);
            win.start();
            win.setOnCompletionListener(mediaPlayer -> {
                // Release the MediaPlayer resources when the audio playback is complete
                win.release();
                win = null;
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

    private void playAudioWin() {
        // Create and execute a new instance of PlayAudioTask
        PlayAudioWinTask task = new PlayAudioWinTask();
        task.execute();
    }
}