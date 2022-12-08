package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_register.xml
public class RegisterActivity extends AppCompatActivity {

    //Creating variables that will be used in the class
    private EditText userName, password, passwordConfirmation;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize the value from the id of the elements in the layout
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        passwordConfirmation = findViewById(R.id.passwordConfirmation);

        Button registerBtn = findViewById(R.id.registerBtn);

        //Initializing the db helper
        dbHelper = new DBHelper(this);

        //Create an on click listener when the register button is clicked
        registerBtn.setOnClickListener(view -> {
            //Initializing username, password, and passConf from the EditText elements.
            String user = userName.getText().toString();
            String pass = password.getText().toString();
            String passConf = passwordConfirmation.getText().toString();

            //Selection to determine whether the input is correct or not
            //Check whether the user hasn't inputted any value
            if (user.equals("") || pass.equals("") || passConf.equals("")) {
                //Create a toast to tell the user they haven't inputted some value
                Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                //Selection to determine password match passwordConfirmation or not
                if (pass.equals(passConf)) {

                    //Check available username by using a method from the DBHelper class.
                    Boolean isUserNameAvailable = dbHelper.isUserNameAvailable(user);

                    //Selection to check whether the username is available or not.
                    if (isUserNameAvailable) {
                        //Insert account data by using a method from the DBHelper class.
                        Boolean insert = dbHelper.insertData(user, pass);

                        //Selection to check whether the data is inserted successfully or not.
                        if (insert) {
                            //Create a toast to tell the user their data has been inserted successfully.
                            Toast.makeText(RegisterActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();

                            //Creating a new intent to activity_login.xml
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                            //Starting an new activity based on the intent
                            startActivity(intent);
                        } else {
                            //Create a toast to tell the user their account failed to be registered.
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //Create a toast to tell the user the account has been registered before.
                        Toast.makeText(RegisterActivity.this, "Account already exits!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Create a toast to tell the user the password doesn't match.
                    Toast.makeText(RegisterActivity.this, "Password doesn't match!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void goToLoginPage(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}