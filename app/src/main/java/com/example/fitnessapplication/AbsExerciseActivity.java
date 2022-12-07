package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AbsExerciseActivity extends AppCompatActivity {

    private int[] exerciseList;
    private TextView[] exerciseTextView;
    private String repeatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_exercise);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        exerciseList = new int[]{
                R.id.exercise_1, R.id.exercise_2, R.id.exercise_3, R.id.exercise_4, R.id.exercise_5, R.id.exercise_6, R.id.exercise_7
        };

        exerciseTextView = new TextView[]{
                findViewById(R.id.seatedRotationText), findViewById(R.id.sitUpText), findViewById(R.id.plankText),
                findViewById(R.id.crossKneeToElbowText), findViewById(R.id.legRaiseText), findViewById(R.id.alternateHeelTouchText),
                findViewById(R.id.crunchText)
        };

        TextView[] exerciseAmountTextView = new TextView[]{
                findViewById(R.id.seatedRotationAmountText), findViewById(R.id.sitUpAmountText), findViewById(R.id.plankAmountText),
                findViewById(R.id.crossKneeToElbowAmountText), findViewById(R.id.legRaiseAmountText), findViewById(R.id.alternateHeelTouchAmountText),
                findViewById(R.id.crunchAmountText)
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
            if (view.getId() == exerciseList[i - 1]) {
                Intent newIntent = new Intent(AbsExerciseActivity.this, ActivityExercise.class);
                newIntent.putExtra("value", String.valueOf(i));
                newIntent.putExtra("activityName", exerciseTextView[i - 1].getText().toString());
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