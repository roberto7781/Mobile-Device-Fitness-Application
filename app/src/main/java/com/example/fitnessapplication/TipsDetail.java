package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TipsDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_detail);

        //Initialize the value from the id of the elements in the layout
        TextView textView = findViewById(R.id.text);

        //Getting String from the previous Activity by using the Intent that started the activity
        String dstory = getIntent().getStringExtra("story");
        textView.setText(dstory);
    }

    //The implementation of an onClick from an element in the activity_tips.xml
    public void goBack(View view) {
        //Creating a new intent to activity_tips.xml
        Intent intent = new Intent(TipsDetail.this, TipsActivity.class);

        //Starting an new activity based on the intent
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        //Creating a new intent to activity_tips.xml
        Intent intent = new Intent(TipsDetail.this, TipsActivity.class);

        //Starting an new activity based on the intent
        startActivity(intent);
        finish();
    }

}