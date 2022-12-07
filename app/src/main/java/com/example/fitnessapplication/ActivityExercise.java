package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class ActivityExercise extends AppCompatActivity {

    private int buttonValue;
    private Button startBtn;
    private CountDownTimer countDownTimer;
    private TextView textView;
    private boolean isTimerRunning;
    private long timerLeftMillis;
    private double caloriesBurned;
    private String gifSrc;
    private String repeatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        GifImageView gifImageView = findViewById(R.id.exerciseGif);
        TextView howToDoText = findViewById(R.id.howToDoText);

        Intent intent = getIntent();
        buttonValue = Integer.parseInt(intent.getStringExtra("value"));
        repeatText = intent.getStringExtra("repeatText");

        TextView exerciseNameText = findViewById(R.id.exerciseRepeatText);
        exerciseNameText.setText(repeatText);

        switch (buttonValue) {
            case 1:
                gifImageView.setImageResource(R.drawable.exercise_12);
                howToDoText.setText(R.string.exercise_1_how_to);
//                Seated Rotation Calories Burned per minute
                caloriesBurned = 4;
//                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_12);
                break;
            case 2:
                gifImageView.setImageResource(R.drawable.exercise_2);
                howToDoText.setText(R.string.exercise_2_how_to);
//                Sit Up Calories Burned per minute
                caloriesBurned = 5;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_2);
                break;
            case 3:
                gifImageView.setImageResource(R.drawable.exercise_11);
                howToDoText.setText(R.string.exercise_3_how_to);
                //                Plank Calories Burned per minute
                caloriesBurned = 3;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_11);
                break;
            case 4:
                gifImageView.setImageResource(R.drawable.exercise_4);
                howToDoText.setText(R.string.exercise_4_how_to);
                //                Cross Knee to elbow Calories Burned per minute
                caloriesBurned = 3.5;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_4);
                break;
            case 5:
                gifImageView.setImageResource(R.drawable.exercise_5);
                howToDoText.setText(R.string.exercise_5_how_to);
                //                Leg Raise Calories Burned per minute
                caloriesBurned = 4;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_5);
                break;
            case 6:
                gifImageView.setImageResource(R.drawable.exercise_6);
                howToDoText.setText(R.string.exercise_6_how_to);
                //               Alternate Heel Touches Calories Burned per minute
                caloriesBurned = 3;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_6);
                break;
            case 7:
                gifImageView.setImageResource(R.drawable.exercise_7);
                howToDoText.setText(R.string.exercise_7_how_to);
                //               Crunch Calories Burned per minute
                caloriesBurned = 6;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.exercise_7);
                break;
            case 8:
                gifImageView.setImageResource(R.drawable.push_up);
                howToDoText.setText(R.string.exercise_8_how_to);
                //               Push Up Calories Burned per minute
                caloriesBurned = 7;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.push_up);
                break;
            case 9:
                gifImageView.setImageResource(R.drawable.triceps_dip);
                howToDoText.setText(R.string.exercise_9_how_to);
                //               Triceps Dip Calories Burned per minute
                caloriesBurned = 3.6;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.triceps_dip);
                break;
            case 10:
                gifImageView.setImageResource(R.drawable.pull_up);
                howToDoText.setText(R.string.exercise_10_how_to);
                //               Pull Up Calories Burned per minute (11 Pull Up Per minute)
                caloriesBurned = 11;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.pull_up);
                break;
            case 11:
                gifImageView.setImageResource(R.drawable.cactus_arm);
                howToDoText.setText(R.string.exercise_11_how_to);
                //               Cactus Arm Calories Burned per minute
                caloriesBurned = 3;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.cactus_arm);
                break;
            case 12:
                gifImageView.setImageResource(R.drawable.mountain_climber);
                howToDoText.setText(R.string.exercise_12_how_to);
                //               Mountain Climber Calories Burned per minute
                caloriesBurned = 11.4;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.mountain_climber);
                break;
            case 13:
                gifImageView.setImageResource(R.drawable.bent_over_lateral_raise);
                howToDoText.setText(R.string.exercise_13_how_to);
                //               Bent Over Lateral Raise Calories Burned per minute
                caloriesBurned = 5;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.bent_over_lateral_raise);
                break;
            case 14:
                gifImageView.setImageResource(R.drawable.alternate_arm_leg_raise);
                howToDoText.setText(R.string.exercise_14_how_to);
                //               Alternate Arm Leg Raise Calories Burned per minute
                caloriesBurned = 5;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.alternate_arm_leg_raise);
                break;
            case 15:
                gifImageView.setImageResource(R.drawable.jumping_jack);
                howToDoText.setText(R.string.exercise_15_how_to);
                //               Jumping Jack Calories Burned per minute
                caloriesBurned = 16;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.jumping_jack);
                break;
            case 16:
                gifImageView.setImageResource(R.drawable.stepup);
                howToDoText.setText(R.string.exercise_16_how_to);
                //              Step Up Calories Burned per minute
                caloriesBurned = 11.7;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.stepup);
                break;
            case 17:
                gifImageView.setImageResource(R.drawable.side_lunge);
                howToDoText.setText(R.string.exercise_17_how_to);
                //              Side Lunge Calories Burned per minute
                caloriesBurned = 6;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.side_lunge);
                break;
            case 18:
                gifImageView.setImageResource(R.drawable.bulgarian_split_squat);
                howToDoText.setText(R.string.exercise_18_how_to);
                //             Bulgarian Split Squat Calories Burned per minute
                caloriesBurned = 9;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.bulgarian_split_squat);
                break;
            case 19:
                gifImageView.setImageResource(R.drawable.glute_bridge);
                howToDoText.setText(R.string.exercise_19_how_to);
                //             Glute Bridge Calories Burned per minute
                caloriesBurned = 8;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.glute_bridge);
                break;
            case 20:
                gifImageView.setImageResource(R.drawable.squat);
                howToDoText.setText(R.string.exercise_20_how_to);
                //              Squat Calories Burned per minute
                caloriesBurned = 8;
                //                Image ID
                gifSrc = String.valueOf(R.drawable.squat);
                break;
        }

        startBtn = findViewById(R.id.startBtn);
        textView = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTimerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });


    }

    private void stopTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        startBtn.setText("Start");

    }

    private void startTimer() {
        final CharSequence value = textView.getText();

        String num1 = value.toString();
        System.out.println(num1);
        String num2 = num1.substring(0, 2);
        System.out.println("Num2: " + num2);
        String num3 = num1.substring(3, 5);
        System.out.println("Num3: " + num3);

        final int number = Integer.parseInt(num2) * 1 + Integer.parseInt(num3);
        timerLeftMillis = number * 1000L;
        System.out.println("Timer Left: " + timerLeftMillis);


        countDownTimer = new CountDownTimer(timerLeftMillis, 1000) {
            @Override
            public void onTick(long l) {
                timerLeftMillis = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newValue = buttonValue;
                if (newValue <= 20) {
                    Intent currentIntent = getIntent();
                    String userName = currentIntent.getStringExtra("username");
                    String activityName = currentIntent.getStringExtra("activityName");
                    Intent newIntent = new Intent(ActivityExercise.this, ExerciseResultActivity.class);
                    newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    newIntent.putExtra("username", userName);
                    newIntent.putExtra("value", String.valueOf(newValue));
                    newIntent.putExtra("caloriesPerMinute", caloriesBurned);
                    newIntent.putExtra("activityName", activityName);
                    newIntent.putExtra("gifSrc", gifSrc);
                    newIntent.putExtra("repeatText", repeatText);
                    startActivity(newIntent);
                } else {
                    newValue = 1;
                    Intent currentIntent = getIntent();
                    String userName = currentIntent.getStringExtra("username");
                    String activityName = currentIntent.getStringExtra("activityName");
                    Intent newIntent = new Intent(ActivityExercise.this, ExerciseResultActivity.class);
                    newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    newIntent.putExtra("username", userName);
                    newIntent.putExtra("value", String.valueOf(newValue));
                    newIntent.putExtra("caloriesPerMinute", caloriesBurned);
                    newIntent.putExtra("activityName", activityName);
                    newIntent.putExtra("gifSrc", gifSrc);
                    newIntent.putExtra("repeatText", repeatText);
                    startActivity(newIntent);
                }
            }
        }.start();
        isTimerRunning = true;
        startBtn.setText("Pause");

    }

    private void updateTimer() {
        int minutes = (int) timerLeftMillis / 60000;
        int seconds = (int) timerLeftMillis % 60000 / 1000;
        System.out.println("Timer Left2: " + timerLeftMillis);
        System.out.println("Seconds: " + seconds);
        String timeLeftText = "";

        if (minutes < 10) {
            timeLeftText = "0";
            timeLeftText += minutes + ":";
        } else {
            timeLeftText += minutes + ":";
        }

        if (seconds < 10) {
            timeLeftText += "0";
            timeLeftText += seconds;
        } else {
            timeLeftText += seconds;
        }

        textView.setText(timeLeftText);
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