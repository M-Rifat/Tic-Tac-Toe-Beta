package com.example.tictactoebeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//Done
public class SinglePlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    private ImageView homeButton;
    private TextView statusTextView, statusTextView2;
    private Button buttonNewMatch;
    private View viewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_single_player);

        buttonNewMatch= findViewById(R.id.buttonNewMatchId);
        buttonNewMatch.setOnClickListener(SinglePlayerActivity.this);

        homeButton=findViewById(R.id.homeId);
        homeButton.setOnClickListener(SinglePlayerActivity.this);

        imageView1 = findViewById(R.id.imageId1);
        imageView2 = findViewById(R.id.imageId2);
        imageView3 = findViewById(R.id.imageId3);
        imageView4 = findViewById(R.id.imageId4);
        imageView5 = findViewById(R.id.imageId5);
        imageView6 = findViewById(R.id.imageId6);
        imageView7 = findViewById(R.id.imageId7);
        imageView8 = findViewById(R.id.imageId8);
        imageView9 = findViewById(R.id.imageId9);

        statusTextView = findViewById(R.id.statusId);
        statusTextView2 = findViewById(R.id.statusId2);

        imageView1.setImageResource(R.drawable.x);
        imageView1.setTranslationY(-1000f);
        imageView1.animate().translationYBy(1000f).setDuration(500);
        imageView1.setClickable(false);

        viewTest=findViewById(R.id.viewtest);


    }

    int counter = 0;

    public void playerTap(View view) {
        counter++;

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        img.setClickable(false);
        //number 1 count
        if (counter == 1) {

            if (tappedImage == 6 || tappedImage == 8 || tappedImage == 4 || tappedImage == 9) {
                imageView3.setImageResource(R.drawable.x);
                imageView3.setTranslationY(-1000f);
                imageView3.animate().translationYBy(1000f).setDuration(500);
                imageView3.setClickable(false);
                img.setImageResource(R.drawable.o);
            } else if (tappedImage == 2 || tappedImage == 3 || tappedImage == 5) {
                imageView7.setImageResource(R.drawable.x);
                imageView7.setTranslationY(-1000f);
                imageView7.animate().translationYBy(1000f).setDuration(500);
                imageView7.setClickable(false);
                img.setImageResource(R.drawable.o);
            } else if (tappedImage == 7) {
                imageView9.setImageResource(R.drawable.x);
                imageView9.setTranslationY(-1000f);
                imageView9.animate().translationYBy(1000f).setDuration(500);
                imageView9.setClickable(false);
                img.setImageResource(R.drawable.o);
            }
        }

        //number 2 count
        if (counter == 2) {

            if (tappedImage == 2) {
                if (imageView9.getDrawable() != null || imageView6.getDrawable() != null) {
                    img.setImageResource(R.drawable.o);
                    imageView7.setImageResource(R.drawable.x);
                    imageView7.setTranslationY(-1000f);
                    imageView7.animate().translationYBy(1000f).setDuration(500);
                    imageView7.setClickable(false);
                } else {
                    img.setImageResource(R.drawable.o);
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setTranslationY(-1000f);
                    imageView5.animate().translationYBy(1000f).setDuration(500);
                    imageView5.setClickable(false);
                }
            } else if (tappedImage == 4) {
                if (imageView2.getDrawable() != null && imageView7.getDrawable() != null) {
                    img.setImageResource(R.drawable.o);
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setTranslationY(-1000f);
                    imageView5.animate().translationYBy(1000f).setDuration(500);
                    imageView5.setClickable(false);
                } else if (imageView5.getDrawable() != null) {
                    img.setImageResource(R.drawable.o);
                    imageView6.setImageResource(R.drawable.x);
                    imageView6.setTranslationY(-1000f);
                    imageView6.animate().translationYBy(1000f).setDuration(500);
                    imageView6.setClickable(false);
                } else {
                    img.setImageResource(R.drawable.o);
                    imageView9.setImageResource(R.drawable.x);
                    imageView9.setTranslationY(-1000f);
                    imageView9.animate().translationYBy(1000f).setDuration(500);
                    imageView9.setClickable(false);
                }
            } else if (tappedImage == 5) {
                img.setImageResource(R.drawable.o);
                imageView3.setImageResource(R.drawable.x);
                imageView3.setTranslationY(-1000f);
                imageView3.animate().translationYBy(1000f).setDuration(500);
                imageView3.setClickable(false);
           }
            else if(tappedImage!=2||tappedImage!=5||tappedImage!=4){
                if (imageView7.getDrawable() != null && imageView9.getDrawable() != null) {
                    img.setImageResource(R.drawable.o);
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setTranslationY(-1000f);
                    imageView5.animate().translationYBy(1000f).setDuration(500);
                    imageView5.setClickable(false);
                } else if ((imageView2.getDrawable() != null && imageView7.getDrawable() != null) || (imageView3.getDrawable() != null
                        && imageView7.getDrawable() != null) || imageView5.getDrawable() != null && imageView7.getDrawable() != null) {
                    img.setImageResource(R.drawable.o);
                    imageView4.setImageResource(R.drawable.x);
                    imageView4.setTranslationY(-1000f);
                    imageView4.animate().translationYBy(1000f).setDuration(500);
                    imageView4.setClickable(false);
                } else {
                    img.setImageResource(R.drawable.o);
                    imageView2.setImageResource(R.drawable.x);
                    imageView2.setTranslationY(-1000f);
                    imageView2.animate().translationYBy(1000f).setDuration(500);
                    imageView2.setClickable(false);
                }
                statusTextView2.setVisibility(View.VISIBLE);
                statusTextView2.setText("You Lose.Try Again...");
                statusTextView2.setTranslationY(-1000f);
                statusTextView2.animate().translationYBy(1000f).setDuration(900);
                disAble();
            }
        }
        //number 3 count
        if (counter == 3) {

            if (imageView5.getDrawable() != null && imageView6.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 2) {
                    imageView8.setImageResource(R.drawable.x);
                    imageView8.setTranslationY(-1000f);
                    imageView8.animate().translationYBy(1000f).setDuration(500);
                    imageView8.setClickable(false);
                } else {
                    imageView2.setImageResource(R.drawable.x);
                    imageView2.setTranslationY(-1000f);
                    imageView2.animate().translationYBy(1000f).setDuration(500);
                    imageView2.setClickable(false);
                }

            } else if (imageView8.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 9) {
                    imageView7.setImageResource(R.drawable.x);
                    imageView7.setTranslationY(-1000f);
                    imageView7.animate().translationYBy(1000f).setDuration(500);
                    imageView7.setClickable(false);
                } else {
                    imageView9.setImageResource(R.drawable.x);
                    imageView9.setTranslationY(-1000f);
                    imageView9.animate().translationYBy(1000f).setDuration(500);
                    imageView9.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }
            } else if (imageView2.getDrawable() != null && imageView7.getDrawable() != null && imageView4.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 3) {
                    imageView9.setImageResource(R.drawable.x);
                    imageView9.setTranslationY(-1000f);
                    imageView9.animate().translationYBy(1000f).setDuration(500);
                    imageView9.setClickable(false);
                } else {
                    imageView3.setImageResource(R.drawable.x);
                    imageView3.setTranslationY(-1000f);
                    imageView3.animate().translationYBy(1000f).setDuration(500);
                    imageView3.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }
            } else if (imageView2.getDrawable() != null && imageView3.getDrawable() != null && imageView4.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 7) {
                    imageView9.setImageResource(R.drawable.x);
                    imageView9.setTranslationY(-1000f);
                    imageView9.animate().translationYBy(1000f).setDuration(500);
                    imageView9.setClickable(false);
                } else {
                    imageView7.setImageResource(R.drawable.x);
                    imageView7.setTranslationY(-1000f);
                    imageView7.animate().translationYBy(1000f).setDuration(500);
                    imageView7.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }
            } else if (imageView7.getDrawable() != null && imageView4.getDrawable() != null && imageView3.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 5) {
                    imageView8.setImageResource(R.drawable.x);
                    imageView8.setTranslationY(-1000f);
                    imageView8.animate().translationYBy(1000f).setDuration(500);
                    imageView8.setClickable(false);
                } else {
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setTranslationY(-1000f);
                    imageView5.animate().translationYBy(1000f).setDuration(500);
                    imageView5.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }
            } else if (imageView2.getDrawable() != null && imageView9.getDrawable() != null && imageView3.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 4) {
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setTranslationY(-1000f);
                    imageView5.animate().translationYBy(1000f).setDuration(500);
                    imageView5.setClickable(false);
                } else {
                    imageView4.setImageResource(R.drawable.x);
                    imageView4.setTranslationY(-1000f);
                    imageView4.animate().translationYBy(1000f).setDuration(500);
                    imageView4.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }
            } else if (imageView7.getDrawable() != null && imageView9.getDrawable() != null && imageView5.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 2) {
                    imageView6.setImageResource(R.drawable.x);
                    imageView6.setTranslationY(-1000f);
                    imageView6.animate().translationYBy(1000f).setDuration(500);
                    imageView6.setClickable(false);
                } else {
                    imageView2.setImageResource(R.drawable.x);
                    imageView2.setTranslationY(-1000f);
                    imageView2.animate().translationYBy(1000f).setDuration(500);
                    imageView2.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }
            } else if (imageView6.getDrawable() != null) {
                img.setImageResource(R.drawable.o);
                if (tappedImage == 4) {
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setTranslationY(-1000f);
                    imageView5.animate().translationYBy(1000f).setDuration(500);
                    imageView5.setClickable(false);
                } else {
                    imageView4.setImageResource(R.drawable.x);
                    imageView4.setTranslationY(-1000f);
                    imageView4.animate().translationYBy(1000f).setDuration(500);
                    imageView4.setClickable(false);
                }
                {
                    statusTextView2.setVisibility(View.VISIBLE);
                    statusTextView2.setText("You Lose.Try Again..");
                    statusTextView2.setTranslationY(-1000f);
                    statusTextView2.animate().translationYBy(1000f).setDuration(900);
                    disAble();
                }

            }
        }

        //number 4 count

        if (counter == 4) {
            img.setImageResource(R.drawable.o);

            statusTextView2.setVisibility(View.VISIBLE);
            statusTextView2.setText("Match Draw.Try Again...");
            statusTextView2.setTranslationY(-1000f);
            statusTextView2.animate().translationYBy(1000f).setDuration(900);
            disAble();
            viewTest.setVisibility(View.VISIBLE);
            viewTest.setTranslationX(-1000f);
            viewTest.animate().translationXBy(1000f).setDuration(900);

        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonNewMatchId) {
            imageView1.setTranslationY(-1000f);
            imageView1.animate().translationYBy(1000f).setDuration(500);
            imageView2.setImageResource(0);
            imageView3.setImageResource(0);
            imageView4.setImageResource(0);
            imageView5.setImageResource(0);
            imageView6.setImageResource(0);
            imageView7.setImageResource(0);
            imageView8.setImageResource(0);
            imageView9.setImageResource(0);
            statusTextView2.setVisibility(View.GONE);
            statusTextView.setText("");
            enAble();
            counter = 0;
        }
        if (v.getId()==R.id.homeId){
            Intent intent=new Intent(SinglePlayerActivity.this,HomeActivity.class);
            startActivity(intent);
        }

    }

    public void disAble() {
        imageView1.setClickable(false);
        imageView2.setClickable(false);
        imageView3.setClickable(false);
        imageView4.setClickable(false);
        imageView5.setClickable(false);
        imageView6.setClickable(false);
        imageView7.setClickable(false);
        imageView8.setClickable(false);
        imageView9.setClickable(false);

    }

    public void enAble() {
        imageView2.setClickable(true);
        imageView3.setClickable(true);
        imageView4.setClickable(true);
        imageView5.setClickable(true);
        imageView6.setClickable(true);
        imageView7.setClickable(true);
        imageView8.setClickable(true);
        imageView9.setClickable(true);

    }
}