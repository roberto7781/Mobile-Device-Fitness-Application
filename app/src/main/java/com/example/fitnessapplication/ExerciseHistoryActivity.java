package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapplication.adapter.ActivityHistoryAdapter;
import com.example.fitnessapplication.model.ActivityHistoryModel;

import java.util.ArrayList;
import java.util.List;

//This class is the Java Class for the activity_history.xml
public class ExerciseHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //Initializing shared preferences from the default application context shared preferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //Initializing the exercise history db
        ExerciseHistoryDB exerciseHistoryDB = new ExerciseHistoryDB(this);

        //Getting the current logged in username from the shared preferences
        String username = sharedPreferences.getString("username", "Not Found");

        //Getting all user activity history by using a method from the ExerciseHistoryDB class.
        List<String> activityHistory = exerciseHistoryDB.getAllData(username);

        //Turn the List of Activity History to a List of ActivityHistoryModel
        List<ActivityHistoryModel> activityHistoryModelList = new ArrayList<>();
        for (int i = 0; i < activityHistory.size(); i++) {
            String[] messages = activityHistory.get(i).split(";");
            ActivityHistoryModel activityHistoryModel = new ActivityHistoryModel(messages[0], messages[1], messages[2], messages[3], Integer.parseInt(messages[4]));
            activityHistoryModelList.add(activityHistoryModel);
        }

        //Initializing the ActivityHistoryAdapter
        ActivityHistoryAdapter activityHistoryAdapter = new ActivityHistoryAdapter(this, activityHistoryModelList);

        //Initializing the ListView from the layout
        ListView listView = findViewById(R.id.list);

        //Setting the list view content by using an adapter
        listView.setAdapter(activityHistoryAdapter);
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

    public void goBack(View view){
        Intent intent = new Intent(ExerciseHistoryActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ExerciseHistoryActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}