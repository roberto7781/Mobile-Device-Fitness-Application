package com.example.fitnessapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_splash.xml
@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    public SplashScreen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Initializing variables
        ImageView imageView = findViewById(R.id.appsplash);
        Animation up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
        imageView.setAnimation(up);

        TextView textView = findViewById(R.id.appname);
        Animation down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down);
        textView.setAnimation(down);


        //Creating a new handler to run the animation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Starting an new activity based on the intent//
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 3500);
    }
}