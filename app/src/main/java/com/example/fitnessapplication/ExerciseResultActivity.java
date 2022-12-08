package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_result.xml
public class ExerciseResultActivity extends AppCompatActivity {

    //Creating variables that will be used in the class
    private ExerciseHistoryDB exerciseHistoryDB;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //Initializing shared preferences from the default application context shared preferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //Getting the Intent that started the activity
        Intent intent = getIntent();

        //Getting double from the previous Activity by using the Intent that started the activity
        double caloryCalculation = intent.getDoubleExtra("caloriesPerMinute", 0.0);

        //Initialize the value from the id of the elements in the layout
        TextView textView = findViewById(R.id.totalCaloriesText);
        textView.setText(String.valueOf(Math.ceil(caloryCalculation)));

        Button button = findViewById(R.id.startBtn);

        //Initializing the exercise history db
        exerciseHistoryDB = new ExerciseHistoryDB(this);

        //Create an on click listener when the start button is clicked
        button.setOnClickListener(view -> {
            //Getting the current logged in username from the shared preferences
            String username = sharedPreferences.getString("username", "Not Found");

            //Getting String from the previous Activity by using the Intent that started the activity
            String currentActivityName = intent.getStringExtra("activityName");
            String caloriesBurned = String.valueOf(intent.getDoubleExtra("caloriesPerMinute", 0.0));
            String gifSRc = intent.getStringExtra("gifSrc");
            String repeatText = intent.getStringExtra("repeatText");

            //Inserting the user activity by using a method from the ExerciseHistoryDB class.
            exerciseHistoryDB.insertData(username, currentActivityName, caloriesBurned + " KCAL", repeatText, "01:00 Min", gifSRc);

            //Creating a new intent to activity_main.xml
            Intent newIntent = new Intent(ExerciseResultActivity.this, MainActivity.class);

            //Starting an new activity based on the intent
            startActivity(newIntent);
        });

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
            return true;
        }

        if (id == R.id.termAndCondition) {
            return true;
        }

        if (id == R.id.share) {
            return true;
        }

        return true;
    }
}