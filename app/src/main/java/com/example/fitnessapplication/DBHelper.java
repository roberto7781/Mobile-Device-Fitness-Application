package com.example.fitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", username);
        contentValues.put("password", password);

        long result = sqLiteDatabase.insert("users", null, contentValues);
        System.out.println(result);
        if (result == -1) {
            return false;
        }
        return true;

    }

    public Boolean isUserNameAvailable(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users where username = ?", new String[]{username});

        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public Boolean validateAccount(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE userName = ? AND password = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;

    }

    public Boolean updateAccountData(String oldUsername, String newUsername, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", newUsername);
        contentValues.put("password", password);

        long result = sqLiteDatabase.update("users", contentValues, "userName=?", new String[]{oldUsername});
        if (result == -1) {
            return false;
        }
        return true;
    }
}
