package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_login.xml
public class LoginActivity extends AppCompatActivity {

    //Creating variables that will be used in the class
    private EditText username, password;
    private DBHelper dbHelper;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize the value from the id of the elements in the layout
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Button loginBtn = findViewById(R.id.loginBtn);

        //Initializing the db helper
        dbHelper = new DBHelper(this);

        //Create an on click listener when the login button is clicked
        loginBtn.setOnClickListener(view -> {
            //Initializing username, and password from the EditText elements.
            String user = username.getText().toString();
            String pass = password.getText().toString();

            //Selection to determine whether the input is correct or not
            //Check whether the user hasn't inputted any value
            if (user.equals("") || pass.equals("")) {
                //Create a toast to tell the user they haven't inputted some value
                Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                //Validate user account by using a method from the DBHelper class.
                Boolean validateAccount = dbHelper.validateAccount(user, pass);

                //If the account information is valid
                if (validateAccount) {
                    //Create a toast to tell the user they have logged in successfully.
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    //Creating a new intent to activity_main.xml
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    //Initializing shared preferences from the default application context shared preferences
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                    //Initializing Editor
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Put username and password string into the editor
                    editor.putString("username", user);
                    editor.putString("password", pass);

                    //Apply the changes to the editor
                    editor.apply();

                    //Starting an new activity based on the intent
                    startActivity(intent);
                } else {
                    //Create a toast to show tell the user they inputted wrong credentials.
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //The implementation of an onClick from an element in the activity_login.xml
    public void goToRegisterPage(View view) {
        //Creating a new intent to activity_register.xml
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

        //Starting an new activity based on the intent
        startActivity(intent);
    }
}