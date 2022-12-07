package com.example.fitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ExerciseHistoryDB extends SQLiteOpenHelper {

    public static final String DBNAME = "ActivityHistory.db";

    public ExerciseHistoryDB(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE activityHistory(username TEXT, caloriesBurned TEXT, activityName TEXT, amountDone TEXT, activityDuration TEXT, gifSrc TEXT)");
    }

    public void deleteTable() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS activityHistory");
        sqLiteDatabase.execSQL("CREATE TABLE activityHistory(userName TEXT, caloriesBurned TEXT, activityName TEXT, amountDone TEXT, activityDuration TEXT, gifSrc TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS activityHistory");
    }

    public void insertData(String username, String activityName, String caloriesBurned, String amountDone, String activityDuration, String gifSRc) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", username);
        contentValues.put("activityName", activityName);
        contentValues.put("caloriesBurned", caloriesBurned);
        contentValues.put("amountDone", amountDone);
        contentValues.put("activityDuration", activityDuration);
        contentValues.put("gifSrc", gifSRc);

        long result = sqLiteDatabase.insert("activityHistory", null, contentValues);
        System.out.println(result + "asdfasdfsda");

    }

    public List<String> getAllData(String username) {
        List<String> activityHistoryList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM activityHistory WHERE username = ?", new String[]{username});
        cursor.moveToFirst();
        String activityString;
        while (!cursor.isAfterLast()) {
            activityString = cursor.getString(1) + ";" + cursor.getString(2) + ";" + cursor.getString(3) + ";" + cursor.getString(4) + ";" + cursor.getString(5);
            System.out.println(activityString);
            activityHistoryList.add(activityString);
            cursor.moveToNext();
        }
        cursor.close();

        return activityHistoryList;
    }
}
