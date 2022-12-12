package com.example.tictactoebeta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1,button2;
    private TextView txtMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1=findViewById(R.id.buttonSingleId);
        button2=findViewById(R.id.buttonMultiId);

        button1.setOnClickListener(HomeActivity.this);
        button2.setOnClickListener(HomeActivity.this);

        txtMarquee = (TextView) findViewById(R.id.marqueeText);
        txtMarquee.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonMultiId){
            Intent intent=new Intent(HomeActivity.this, MultiPlayerActivity.class);
            startActivity(intent);
        }        if (v.getId()==R.id.buttonSingleId){
            Intent intent=new Intent(HomeActivity.this, SinglePlayerActivity.class);
            startActivity(intent);
        }
    }
    public void onBackPressed() {
        finishAffinity();
    }
}