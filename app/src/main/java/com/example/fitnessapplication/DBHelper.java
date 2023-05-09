package com.example.fitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //Constant variable for the database name
    public static final String DBNAME = "Login.db";

    //This the constructor of the class
    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    //This method is used to create a database by running an SQLite query
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT)");
    }

    //This method is used to drop a database by running an SQLite query
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
    }

    //This method is used to insert the user data
    public Boolean insertData(String username, String password) {
        //Initialize an SQLiteDatabase by calling the getWritableDatabase method
        //Because we will be writing to the database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Creating variable for content value
        ContentValues contentValues = new ContentValues();

        //Putting a key, value pair for the content value
        contentValues.put("userName", username);
        contentValues.put("password", password);

        //Inserting the content value into the database
        //Assigning the a result variable to determine whether the insert
        //is successful or not
        long result = sqLiteDatabase.insert("users", null, contentValues);

        return result != -1;

    }

    //This method is used to check whether the passed username is
    //found on the database or not.
    public Boolean isUserNameAvailable(String username) {
        //Initialize an SQLiteDatabase by calling the getReadableDatabase method
        //Because we will be reading to the database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Initializing a cursor which as a middleware between SQLite database
        //and SQL query
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users where username = ?", new String[]{username});

        //Selection to determine whether the cursor which contain the result set
        //is empty or not
        if (cursor.getCount() > 0) {
            //Closing the cursor because it won't be use anymore
            cursor.close();

            //Return false because the username is not available
            return false;
        }

        //Closing the cursor because it won't be use anymore
        cursor.close();

        //Return true because the username is available.
        return true;
    }

    //This method is used to validate user account
    public Boolean validateAccount(String username, String password) {
        //Initialize an SQLiteDatabase by calling the getReadableDatabase method
        //Because we will be reading to the database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Initializing a cursor which as a middleware between SQLite database
        //and SQL query
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE userName = ? AND password = ?", new String[]{username, password});

        //Selection to determine whether the cursor which contain the result set
        //is empty or not
        if (cursor.getCount() > 0) {
            //Closing the cursor because it won't be use anymore
            cursor.close();

            //Return true because the account is available
            return true;
        }

        //Closing the cursor because it won't be use anymore
        cursor.close();

        //Return false because the account is not available.
        return false;
    }

    //This method is used to update account data.
    public Boolean updateAccountData(String oldUsername, String newUsername, String password) {
        //Initialize an SQLiteDatabase by calling the getWritableDatabase method
        //Because we will be writing to the database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Creating variable for content value
        ContentValues contentValues = new ContentValues();

        //Putting a key, value pair for the content value
        contentValues.put("userName", newUsername);
        contentValues.put("password", password);

        //Inserting the content value into the database
        //Assigning the a result variable to determine whether the insert
        //is successful or not
        long result = sqLiteDatabase.update("users", contentValues, "userName=?", new String[]{oldUsername});
        return result != -1;
    }
}
