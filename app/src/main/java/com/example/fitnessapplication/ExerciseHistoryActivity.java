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
import java.util.Arrays;
import java.util.List;

public class ExerciseHistoryActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ExerciseHistoryDB exerciseHistoryDB = new ExerciseHistoryDB(this);

        String username = sharedPreferences.getString("username", "Not Found");

        List<String> activityHistory = exerciseHistoryDB.getAllData(username);
        List<ActivityHistoryModel> activityHistoryModelList = new ArrayList<>();

        for (int i = 0; i < activityHistory.size(); i++) {
            String[] messages = activityHistory.get(i).split(";");
            System.out.println(Arrays.toString(messages) + "ActivityHistoryTest");
            ActivityHistoryModel activityHistoryModel = new ActivityHistoryModel(messages[0], messages[1], messages[2], messages[3], Integer.parseInt(messages[4]));
            activityHistoryModelList.add(activityHistoryModel);
        }

        ActivityHistoryAdapter activityHistoryAdapter = new ActivityHistoryAdapter(this, activityHistoryModelList);

        ListView listView = findViewById(R.id.list);
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