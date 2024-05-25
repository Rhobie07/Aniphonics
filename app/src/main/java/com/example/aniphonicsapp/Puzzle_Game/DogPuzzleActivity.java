package com.example.aniphonicsapp.Puzzle_Game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aniphonicsapp.R;

import java.util.ArrayList;
import java.util.Random;

public class DogPuzzleActivity extends AppCompatActivity {

    private static DogGestureDetectGridView mGridView;
    private static final int COLUMNS = 3;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;
    private static int mColumnWidth, mColumnHeight;
    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";
    private static String[] tileList;
    private static boolean buttonsEnabled = true;
    private MediaPlayer voice, click;
    private Button back;
    private Animation scaleUp,scaleDown;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_dog);

        playAudioVoice();

        init();

        scramble();

        setDimensions();

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
                Intent intent = new Intent(DogPuzzleActivity.this, Puzzle_Images.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            return true;
        });
    }

    private void init() {
        mGridView = (DogGestureDetectGridView) findViewById(R.id.layout2);
        mGridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = tileList.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }

    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                mColumnWidth = displayWidth / COLUMNS;
                mColumnHeight = requiredHeight / COLUMNS;

                display(getApplicationContext());
            }
        });
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        @SuppressLint({"InternalInsetResource", "DiscouragedApi"}) int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;

            for (String s : tileList) {
                button = new Button(context);

                switch (s) {
                    case "0":
                        button.setBackgroundResource(R.mipmap.dog_1);
                        break;
                    case "1":
                        button.setBackgroundResource(R.mipmap.dog_2);
                        break;
                    case "2":
                        button.setBackgroundResource(R.mipmap.dog_3);
                        break;
                    case "3":
                        button.setBackgroundResource(R.mipmap.dog_4);
                        break;
                    case "4":
                        button.setBackgroundResource(R.mipmap.dog_5);
                        break;
                    case "5":
                        button.setBackgroundResource(R.mipmap.dog_6);
                        break;
                    case "6":
                        button.setBackgroundResource(R.mipmap.dog_7);
                        break;
                    case "7":
                        button.setBackgroundResource(R.mipmap.dog_8);
                        break;
                    case "8":
                        button.setBackgroundResource(R.mipmap.dog_9);
                        break;
                }

                buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));
    }


    private static void swap(Context context, int currentPosition, int swap) {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        if (isSolved()) {
            Toast.makeText(context, "PUZZLE SOLVED!", Toast.LENGTH_SHORT).show();
        }
    }

    public static void moveTiles(Context context, String direction, int position) {

        if(buttonsEnabled) {
            // Upper-left-corner tile
            if (position == 0) {

                if (direction.equals(right)) swap(context, position, 1);
                else if (direction.equals(down)) swap(context, position, COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Upper-center tiles
            } else if (position > 0 && position < COLUMNS - 1) {
                if (direction.equals(left)) swap(context, position, -1);
                else if (direction.equals(down)) swap(context, position, COLUMNS);
                else if (direction.equals(right)) swap(context, position, 1);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Upper-right-corner tile
            } else if (position == COLUMNS - 1) {
                if (direction.equals(left)) swap(context, position, -1);
                else if (direction.equals(down)) swap(context, position, COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Left-side tiles
            } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                    position % COLUMNS == 0) {
                if (direction.equals(up)) swap(context, position, -COLUMNS);
                else if (direction.equals(right)) swap(context, position, 1);
                else if (direction.equals(down)) swap(context, position, COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Right-side AND bottom-right-corner tiles
            } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
                if (direction.equals(up)) swap(context, position, -COLUMNS);
                else if (direction.equals(left)) swap(context, position, -1);
                else if (direction.equals(down)) {

                    // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                    // right-corner tile.
                    if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                            COLUMNS);
                    else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Bottom-left corner tile
            } else if (position == DIMENSIONS - COLUMNS) {
                if (direction.equals(up)) swap(context, position, -COLUMNS);
                else if (direction.equals(right)) swap(context, position, 1);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Bottom-center tiles
            } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
                if (direction.equals(up)) swap(context, position, -COLUMNS);
                else if (direction.equals(left)) swap(context, position, -1);
                else if (direction.equals(right)) swap(context, position, 1);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

                // Center tiles
            } else {
                if (direction.equals(up)) swap(context, position, -COLUMNS);
                else if (direction.equals(left)) swap(context, position, -1);
                else if (direction.equals(right)) swap(context, position, 1);
                else swap(context, position, COLUMNS);
            }
        } else {
            Toast.makeText(context, "The Puzzle was already solved!", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isSolved() {
        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }

        if (solved) {
            // Puzzle is solved, disable buttons
            buttonsEnabled = false;
        }

        return solved;
    }

    public void finish() {
        super.finish();
        Intent intent = new Intent(DogPuzzleActivity.this, Puzzle_Images.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        stopAudioVoice();
    }

    private final class PlayAudioTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Initialize the MediaPlayer and start playing the audio in the background
            voice = MediaPlayer.create(DogPuzzleActivity.this, R.raw.puzzle_voice);
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
            click = MediaPlayer.create(DogPuzzleActivity.this, R.raw.click);
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