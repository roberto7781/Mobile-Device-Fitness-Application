package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_exercise_menu.xml
public class ExerciseMenuActivity extends AppCompatActivity {

    //Creating variables that will be used in the class

    //Initialize workoutDifficulties as "easy" when the user haven't choose
    //The difficulties
    private String workoutDifficulties = "easy";
    private Intent currentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_menu);

        //Getting the Intent that started the activity
        currentIntent = getIntent();

        //Initialize the value from the id of the elements in the layout
        ImageView exerciseImage = findViewById(R.id.exerciseImage);

        //Setting the image to the value from the Intent that started the activity
        exerciseImage.setImageResource(Integer.parseInt(currentIntent.getStringExtra("exerciseImageSrc")));

        //Initialize the value from the id of the elements in the layout
        TextView exerciseTitle = findViewById(R.id.exerciseTitle);

        //Setting the text to the value from the Intent that started the activity
        exerciseTitle.setText(currentIntent.getStringExtra("exerciseTitle"));

        //Initialize the value from the id of the elements in the layout
        Button startButton = findViewById(R.id.startButton);

        //Creating an on click listener when the start button is clicked
        startButton.setOnClickListener(view -> {
            //Creating variables
            Intent intent = null;

            //Initializing exerciseTitle
            //Getting String from the previous Activity by using the Intent that started the activity
            String exerciseTitle1 = currentIntent.getStringExtra("exerciseTitle");

            //Selection to determine whether the exercise that the user has chosen is
            //Abs exercise, Leg Exercise, Arm Exercise
            switch (exerciseTitle1) {
                case "Abs \nExercise":
                    //Creating new intent to activity_abs_exercise.xml
                    intent = new Intent(ExerciseMenuActivity.this, AbsExerciseActivity.class);
                    break;
                case "Leg \nExercise":
                    //Creating new intent to activity_leg_exercise.xml
                    intent = new Intent(ExerciseMenuActivity.this, LegExerciseActivity.class);

                    break;
                case "Arm \nExercise":
                    //Creating new intent to activity_arm_exercise.xml
                    intent = new Intent(ExerciseMenuActivity.this, ArmExerciseActivity.class);
                    break;
            }

            //Putting some values that will be used in the next activity
            intent.putExtra("workoutDifficulties", workoutDifficulties);

            //Starting an new activity based on the intent
            startActivity(intent);
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.easyDifficulty:
                if (checked) {
                    workoutDifficulties = "easy";
                }
                // Pirates are the best
                break;
            case R.id.mediumDifficulty:
                if (checked) {
                    workoutDifficulties = "medium";
                }
                // Ninjas rule
                break;
            case R.id.hardDifficulty:
                if (checked) {
                    workoutDifficulties = "hard";
                }
                break;
        }
    }
}