package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseResultActivity extends AppCompatActivity {

    private ExerciseHistoryDB activityHistoryDB;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Intent currentIntent = getIntent();
        double caloryCalculation = currentIntent.getDoubleExtra("caloriesPerMinute", 0.0);

        TextView textView = findViewById(R.id.totalCaloriesText);
        textView.setText(String.valueOf(Math.ceil(caloryCalculation)));

        Button button = findViewById(R.id.startBtn);

        activityHistoryDB = new ExerciseHistoryDB(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String username = sharedPreferences.getString("username", "Not Found");

                String currentActivityName = intent.getStringExtra("activityName");
                String caloriesBurned = String.valueOf(intent.getDoubleExtra("caloriesPerMinute", 0.0));
                String gifSRc = intent.getStringExtra("gifSrc");
                String repeatText = intent.getStringExtra("repeatText");
                activityHistoryDB.insertData(username, currentActivityName, caloriesBurned + " KCAL", repeatText, "01:00 Min", gifSRc);

                Intent newIntent = new Intent(ExerciseResultActivity.this, MainActivity.class);
                newIntent.putExtra("username", username);
                startActivity(newIntent);
            }
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