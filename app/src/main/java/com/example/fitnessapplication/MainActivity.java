package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the main_activity.xml
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    //The implementation of an onClick from an element in the activity_main.xml
    public void tips(View view) {
        //Creating a new intent to activity_tips.xml
        Intent intent = new Intent(MainActivity.this, TipsActivity.class);

        //Starting an new activity based on the intent
        startActivity(intent);
    }

    //The implementation of an onClick from an element in the activity_main.xml
    public void goToProfilePage(View view) {
        //Creating a new intent to activity_edit_profile.xml
        Intent newIntent = new Intent(MainActivity.this, EditProfileActivity.class);

        //Starting an new activity based on the intent
        startActivity(newIntent);
    }

    //The implementation of an onClick from an element in the activity_main.xml
    public void absWorkout(View view) {
        //Creating a new intent to activity_abs_workout.xml
        Intent newIntent = new Intent(MainActivity.this, ExerciseMenuActivity.class);

        //Putting some values that will be used in the next activity
        newIntent.putExtra("exerciseImageSrc", String.valueOf(R.drawable.abs_exercise_image));
        newIntent.putExtra("exerciseTitle", "Abs \nExercise");

        //Starting an new activity based on the intent
        startActivity(newIntent);
    }

    //The implementation of an onClick from an element in the activity_main.xml
    public void armWorkout(View view) {
        //Creating a new intent to activity_arm_workout.xml
        Intent newIntent = new Intent(MainActivity.this, ExerciseMenuActivity.class);

        //Putting some values that will be used in the next activity
        newIntent.putExtra("exerciseImageSrc", String.valueOf(R.drawable.arm_exercise_image));
        newIntent.putExtra("exerciseTitle", "Arm \nExercise");

        //Starting an new activity based on the intent
        startActivity(newIntent);

    }

    //The implementation of an onClick from an element in the activity_main.xml
    public void legWorkout(View view) {
        //Creating a new intent to activity_leg_workout.xml
        Intent newIntent = new Intent(MainActivity.this, ExerciseMenuActivity.class);

        //Putting some values that will be used in the next activity
        newIntent.putExtra("exerciseImageSrc", String.valueOf(R.drawable.leg_exercise_image));
        newIntent.putExtra("exerciseTitle", "Leg \nExercise");

        //Starting an new activity based on the intent
        startActivity(newIntent);
    }

    //The implementation of an onClick from an element in the activity_main.xml
    public void activityHistory(View view) {
        //Creating a new intent to activity_history.xml
        Intent newIntent = new Intent(MainActivity.this, ExerciseHistoryActivity.class);

        //Starting an new activity based on the intent
        startActivity(newIntent);
    }
}