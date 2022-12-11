package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        //Initialize an array of string by getting their values from the strings.xml file
        String[] tstory = getResources().getStringArray(R.array.titleStory);
        final String[] dstory = getResources().getStringArray(R.array.detailStory);

        //Initialize the value from the id of the elements in the layout
        ListView listView = findViewById(R.id.list);

        //Create a new ArrayAdapter to adapt the activity_row layout to replace the ListView
        //design on the current layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, R.id.rowtxt, tstory);
        listView.setAdapter(adapter);

        //Create an on click listener when the ListView is clicked
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            //Getting the Tips Details from the List that the user clicked
            String t = dstory[i];

            //Creating a new intent to activity_tips_detail.xml
            Intent intent = new Intent(TipsActivity.this, TipsDetail.class);

            //Putting some values that will be used in the next activity
            intent.putExtra("story", t);

            //Starting an new activity based on the intent
            startActivity(intent);
        });

    }

    //The implementation of an onClick from an element in the activity_tips.xml
    public void goBack(View view) {
        //Creating a new intent to activity_main.xml
        Intent intent = new Intent(TipsActivity.this, MainActivity.class);

        //Starting an new activity based on the intent
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        //Creating a new intent to activity_main.xml
        Intent intent = new Intent(TipsActivity.this, MainActivity.class);
        startActivity(intent);

        //Starting an new activity based on the intent
        finish();
    }

}