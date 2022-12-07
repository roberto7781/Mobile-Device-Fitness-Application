package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    final String[] workoutDifficulties = {
            "Easy", "Medium", "Hard"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.privacyPolicy) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);

            return true;
        }

        if (id == R.id.termAndCondition) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);

            return true;
        }

        if (id == R.id.share) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String shareBody = "Testing Share Application";
            String shareHub = "Test";
            intent.putExtra(Intent.EXTRA_SUBJECT, shareHub);
            intent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(intent, "Share Using"));

            return true;
        }

        return true;
    }


    public void tips(View view) {
        Intent intent = new Intent(MainActivity.this, TipsActivity.class);
        startActivity(intent);
    }

    public void goToProfilePage(View view) {
        Intent newIntent = new Intent(MainActivity.this, EditProfileActivity.class);
        startActivity(newIntent);
    }

    public void absWorkout(View view) {
        Intent newIntent = new Intent(MainActivity.this, ExerciseMenuActivity.class);

        newIntent.putExtra("exerciseImageSrc", String.valueOf(R.drawable.abs_exercise_image));
        newIntent.putExtra("exerciseTitle", "Abs \nExercise");
        startActivity(newIntent);


    }

    public void armWorkout(View view) {
        Intent newIntent = new Intent(MainActivity.this, ExerciseMenuActivity.class);

        newIntent.putExtra("exerciseImageSrc", String.valueOf(R.drawable.arm_exercise_image));
        newIntent.putExtra("exerciseTitle", "Arm \nExercise");
        startActivity(newIntent);

    }

    public void legWorkout(View view) {
        Intent newIntent = new Intent(MainActivity.this, ExerciseMenuActivity.class);

        newIntent.putExtra("exerciseImageSrc", String.valueOf(R.drawable.leg_exercise_image));
        newIntent.putExtra("exerciseTitle", "Leg \nExercise");
        startActivity(newIntent);
    }

    public void activityHistory(View view) {
        Intent newIntent = new Intent(MainActivity.this, ExerciseHistoryActivity.class);

        startActivity(newIntent);
    }
}