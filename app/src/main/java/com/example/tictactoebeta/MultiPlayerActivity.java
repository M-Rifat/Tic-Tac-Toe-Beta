package com.example.tictactoebeta;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MultiPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    private TextView statusTextView,statusTextView2;
    private Button buttonNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_multi_player);

        buttonNew=findViewById(R.id.buttonId);
        buttonNew.setOnClickListener(MultiPlayerActivity.this);

        imageView1=findViewById(R.id.imageId1);
        imageView2=findViewById(R.id.imageId2);
        imageView3=findViewById(R.id.imageId3);
        imageView4=findViewById(R.id.imageId4);
        imageView5=findViewById(R.id.imageId5);
        imageView6=findViewById(R.id.imageId6);
        imageView7=findViewById(R.id.imageId7);
        imageView8=findViewById(R.id.imageId8);
        imageView9=findViewById(R.id.imageId9);

        statusTextView=findViewById(R.id.statusId);
        statusTextView2=findViewById(R.id.statusId2);

    }

    boolean gameActive = true;

    // Player representation
    // 0 - X
    // 1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // State meanings:
    // 0 - X
    // 1 - O
    // 2 - Null
    // put all win positions in a 2D array
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0;

    // this function will be called every time a
    // players tap in an empty box of the grid
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        // game reset function will be called
        // if someone wins or the boxes are full
        if (!gameActive) {
            gameReset(view);
        }

        // if the tapped image is empty
        if (gameState[tappedImage] == 2) {
            // increase the counter
            // after every tap
            counter++;

            // check if its the last box
            if (counter == 9) {
                // reset the game
                gameActive = false;
            }

            // mark this position
            gameState[tappedImage] = activePlayer;

            // this will give a motion
            // effect to the image
            img.setTranslationY(-1000f);

            // change the active player
            // from 0 to 1 or 1 to 0
            if (activePlayer == 0) {
                // set the image of x
                img.setImageResource(R.drawable.x);
                activePlayer = 1;

                // change the status
                statusTextView.setText("O's Turn - Tap to play");
            } else {
                // set the image of o
                img.setImageResource(R.drawable.o);
                activePlayer = 0;

                // change the status
                statusTextView.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(500);
        }
        int flag = 0;
        // Check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;

                // Somebody has won! - Find out who!

                // game reset function be called
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    // Update the status bar for winner announcement
                    statusTextView.setText("X has won");

                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("X has won");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    counter=0;
                } else {
                    statusTextView.setText("0 has won");
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("0 has won");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    counter=0;
                }
            }
        }
        // set the status if the match draw
        if (counter == 9 && flag == 0) {
            statusTextView.setText("Match Draw");
            statusTextView2.setVisibility(View.VISIBLE);
            statusTextView2.setText("Match Draw");
            statusTextView2.setTranslationY(-1000f);
            statusTextView2.animate().translationYBy(1000f).setDuration(900);
            counter=0;
        }
    }

    // reset the game
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        // remove all the images from the boxes inside the grid
        imageView1.setImageResource(0);
        imageView2.setImageResource(0);
        imageView3.setImageResource(0);
        imageView4.setImageResource(0);
        imageView5.setImageResource(0);
        imageView6.setImageResource(0);
        imageView7.setImageResource(0);
        imageView8.setImageResource(0);
        imageView9.setImageResource(0);

        statusTextView.setText("X's Turn - Tap to play");
    }

    @Override
    public void onClick(View v) {
        statusTextView2.setVisibility(View.GONE);
        gameReset(v);

    }
}
