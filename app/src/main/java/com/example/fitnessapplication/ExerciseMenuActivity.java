package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExerciseMenuActivity extends AppCompatActivity {

    private String workoutDifficulties = "easy";
    private Intent currentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_menu);

        currentIntent = getIntent();

        ImageView exerciseImage = findViewById(R.id.exerciseImage);
        exerciseImage.setImageResource(Integer.parseInt(currentIntent.getStringExtra("exerciseImageSrc")));

        TextView exerciseTitle = findViewById(R.id.exerciseTitle);
        exerciseTitle.setText(currentIntent.getStringExtra("exerciseTitle"));

        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                String exerciseTitle = currentIntent.getStringExtra("exerciseTitle");
                if(exerciseTitle.equals("Abs \nExercise")){
                    intent = new Intent(ExerciseMenuActivity.this, AbsExerciseActivity.class);
                }
                else if(exerciseTitle.equals("Leg \nExercise")){
                    intent = new Intent(ExerciseMenuActivity.this, LegExerciseActivity.class);

                }
                else if(exerciseTitle.equals("Arm \nExercise")){
                    intent = new Intent(ExerciseMenuActivity.this, ArmExerciseActivity.class);
                }

                intent.putExtra("workoutDifficulties", workoutDifficulties);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.easyDifficulty:
                if (checked){
                    workoutDifficulties = "easy";
                }
                    // Pirates are the best
                    break;
            case R.id.mediumDifficulty:
                if (checked){
                    workoutDifficulties = "medium";
                }
                    // Ninjas rule
                    break;
            case R.id.hardDifficulty:
                if(checked){
                    workoutDifficulties = "hard";
                }
                break;
        }
    }
}