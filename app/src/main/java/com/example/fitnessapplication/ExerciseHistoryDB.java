package com.example.fitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ExerciseHistoryDB extends SQLiteOpenHelper {

    //Constant variable for the database name
    public static final String DBNAME = "ActivityHistory.db";

    //This the constructor of the class
    public ExerciseHistoryDB(Context context) {
        super(context, DBNAME, null, 1);
    }

    //This method is used to create a database by running an SQLite query
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE activityHistory(username TEXT, caloriesBurned TEXT, activityName TEXT, amountDone TEXT, activityDuration TEXT, gifSrc TEXT)");
    }

    //This method is used to drop a database by running an SQLite query
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS activityHistory");
    }

    //This method is used to insert the activity history
    public void insertData(String username, String activityName, String caloriesBurned, String amountDone, String activityDuration, String gifSRc) {
        //Initialize an SQLiteDatabase by calling the getWritableDatabase method
        //Because we will be writing to the database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Creating variable for content value
        ContentValues contentValues = new ContentValues();

        //Putting a key, value pair for the content value
        contentValues.put("userName", username);
        contentValues.put("activityName", activityName);
        contentValues.put("caloriesBurned", caloriesBurned);
        contentValues.put("amountDone", amountDone);
        contentValues.put("activityDuration", activityDuration);
        contentValues.put("gifSrc", gifSRc);

        //Inserting the content value into the database
       sqLiteDatabase.insert("activityHistory", null, contentValues);

    }

    //This method is used to get all the user activity history
    public List<String> getAllData(String username) {
        //Initialize an array list
        List<String> activityHistoryList = new ArrayList<>();

        //Initialize an SQLiteDatabase by calling the getReadableDatabase method
        //Because we will be reading to the database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Initializing a cursor which as a middleware between SQLite database
        //and SQL query
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM activityHistory WHERE username = ?", new String[]{username});

        //Move the cursor to the first result set
        cursor.moveToFirst();

        String activityString;

        //Loop while the cursor is not in the last element
        while (!cursor.isAfterLast()) {

            //Assign a value to the activityString
            activityString = cursor.getString(1) + ";" + cursor.getString(2) + ";" + cursor.getString(3) + ";" + cursor.getString(4) + ";" + cursor.getString(5);

            //Add the value to the array list
            activityHistoryList.add(activityString);

            //Move the cursor to the next result set
            cursor.moveToNext();
        }

        //Closing the cursor because it won't be use anymore
        cursor.close();

        //Return the array list
        return activityHistoryList;
    }
}
