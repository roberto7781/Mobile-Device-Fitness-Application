package com.example.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LegExerciseActivity extends AppCompatActivity {

    private int[] exerciseList;
    private TextView[] exerciseTextView;
    private String repeatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_exercise);

        exerciseList = new int[]{
                R.id.exercise_15, R.id.exercise_16, R.id.exercise_17, R.id.exercise_18, R.id.exercise_19, R.id.exercise_20
        };

        exerciseTextView = new TextView[]{
                findViewById(R.id.jumpingJackText), findViewById(R.id.steUpText), findViewById(R.id.sideLungeText),
                findViewById(R.id.bulgarianSplitSquatText), findViewById(R.id.gluteBridgeText), findViewById(R.id.squatText)
        };

        TextView[] exerciseAmountTextView = new TextView[]{
                findViewById(R.id.jumpingJackAmountText), findViewById(R.id.steUpAmountText), findViewById(R.id.sideLungeAmountText),
                findViewById(R.id.bulgarianSplitSquatAmountText), findViewById(R.id.gluteBridgeAmountText), findViewById(R.id.squatAmountText)
        };

        Intent currentIntent = getIntent();

        String workoutDifficulties = currentIntent.getStringExtra("workoutDifficulties");

        if(workoutDifficulties.equals("easy")){
            for (int i = 0; i < exerciseAmountTextView.length; i++) {
                repeatText = "Repeat 4 Times";
                exerciseAmountTextView[i].setText("Repeat 4 Times");
            }
        }
        else if(workoutDifficulties.equals("medium")){
            for (int i = 0; i < exerciseAmountTextView.length; i++) {
                repeatText = "Repeat 6 Times";
                exerciseAmountTextView[i].setText("Repeat 6 Times");
            }
        }
        else if(workoutDifficulties.equals("hard")){
            for (int i = 0; i < exerciseAmountTextView.length; i++) {
                repeatText = "Repeat 8 Times";
                exerciseAmountTextView[i].setText("Repeat 8 Times");
            }
        }


    }


    public void imageButtonClicked(View view) {
        for (int i = 1; i <= exerciseList.length; i++) {
            System.out.println("Testing" + i);
            if (view.getId() == exerciseList[i-1]) {
                System.out.println("Value+ " + i);
                Log.i("FIRST", String.valueOf(i));
                Intent newIntent = new Intent(LegExerciseActivity.this, ActivityExercise.class);
                newIntent.putExtra("value", String.valueOf(i+14));
                newIntent.putExtra("activityName", exerciseTextView[i-1].getText().toString());
                newIntent.putExtra("repeatText", repeatText);
                startActivity(newIntent);
                break;
            }
        }
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