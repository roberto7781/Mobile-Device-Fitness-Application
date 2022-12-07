package com.example.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ArmExerciseActivity extends AppCompatActivity {

    private int[] exerciseList;
    private TextView[] exerciseTextView;
    private String repeatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_exercise);

        exerciseList = new int[]{
                R.id.exercise_8, R.id.exercise_9, R.id.exercise_10, R.id.exercise_11, R.id.exercise_12, R.id.exercise_13, R.id.exercise_14
        };
        exerciseTextView = new TextView[]{
               findViewById(R.id.pushUpText), findViewById(R.id.tricepsDipText), findViewById(R.id.pullUpText), findViewById(R.id.cactusArmText),
                findViewById(R.id.mountainClimberText), findViewById(R.id.bentOverLateralRaiseText), findViewById(R.id.alternateArmLegRaiseText)
        };

        TextView[] exerciseAmountTextView = new TextView[]{
                findViewById(R.id.pushUpAmountText), findViewById(R.id.tricepsDipAmountText), findViewById(R.id.pullUpAmountText), findViewById(R.id.cactusArmAmountText),
                findViewById(R.id.mountainClimberAmountText), findViewById(R.id.bentOverLateralRaiseAmountText), findViewById(R.id.alternateArmLegRaiseAmountText)
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
                Intent newIntent = new Intent(ArmExerciseActivity.this, ActivityExercise.class);

                newIntent.putExtra("value", String.valueOf(i+7));
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