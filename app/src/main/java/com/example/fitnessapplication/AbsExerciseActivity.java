package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_abs_exercise.xml
public class AbsExerciseActivity extends AppCompatActivity {

    //Creating variables that will be used in the class
    private int[] exerciseList;
    private TextView[] exerciseTextView;
    private String repeatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_exercise);

        //Initializing all of the variables
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

        //Getting the Intent that started the activity
        Intent currentIntent = getIntent();

        //Getting String from the previous Activity by using the Intent that started the activity
        String workoutDifficulties = currentIntent.getStringExtra("workoutDifficulties");

        // Selection to determine whether the user choose easy, medium, or hard difficulty.
        // Set the number of exercise done according to the difficulty.
        switch (workoutDifficulties) {
            case "easy":
                for (TextView view : exerciseAmountTextView) {
                    repeatText = "Repeat 4 Times";
                    view.setText("Repeat 4 Times");
                }
                break;
            case "medium":
                for (TextView textView : exerciseAmountTextView) {
                    repeatText = "Repeat 6 Times";
                    textView.setText("Repeat 6 Times");
                }
                break;
            case "hard":
                for (TextView textView : exerciseAmountTextView) {
                    repeatText = "Repeat 8 Times";
                    textView.setText("Repeat 8 Times");
                }
                break;
        }

    }

    //The implementation of an onClick from an element in the activity_abs_exercise.xml
    public void imageButtonClicked(View view) {
        for (int i = 1; i <= exerciseList.length; i++) {
            if (view.getId() == exerciseList[i - 1]) {
                //Creating a new intent to activity_exercise.xml
                Intent newIntent = new Intent(AbsExerciseActivity.this, ActivityExercise.class);

                //Putting some values that will be used in the next activity
                newIntent.putExtra("value", String.valueOf(i));
                newIntent.putExtra("activityName", exerciseTextView[i - 1].getText().toString());
                newIntent.putExtra("repeatText", repeatText);

                //Starting an new activity based on the intent
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