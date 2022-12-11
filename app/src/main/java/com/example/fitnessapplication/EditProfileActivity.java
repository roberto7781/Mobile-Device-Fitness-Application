package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//This class is the Java Class for the activity_edit_profile.xml
public class EditProfileActivity extends AppCompatActivity {

    //Creating variables that will be used in the class
    private EditText userName, password, newPassword;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //Initializing shared preferences from the default application context shared preferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //Initialize the value from the id of the elements in the layout
        userName = findViewById(R.id.username);
        password = findViewById(R.id.oldpassword);
        newPassword = findViewById(R.id.newpassword);

        Button editProfileButton = findViewById(R.id.editProfileBtn);
        Button logoutButton = findViewById(R.id.logoutBtn);

        //Initializing the db helper
        dbHelper = new DBHelper(this);

        //Getting the current logged in username from the shared preferences
        String currentUsername = sharedPreferences.getString("username", "Not Found");

        userName.setText(currentUsername);

        //Create an on click listener when the edit profile button is clicked
        editProfileButton.setOnClickListener(view -> {
            //Initializing username, password, and new password from the EditText elements.
            String user = userName.getText().toString();
            String pass = password.getText().toString();
            String newPass = newPassword.getText().toString();

            //Selection to determine whether the input is correct or not
            //Check whether the user hasn't inputted any value
            if (user.equals("") || pass.equals("") || newPass.equals("")) {
                //Create a toast to tell the user they haven't inputted some value
                Toast.makeText(EditProfileActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                //Validate user account by using a method from the DBHelper class.
                Boolean validateAccount = dbHelper.validateAccount(currentUsername, pass);

                //If the account information is valid
                if (validateAccount) {
                    //Selection to check whether the current username match the new username or not
                    if (!currentUsername.equals(user)) {

                        //Check available username by using a method from the DBHelper class.
                        Boolean isUserNameAvailable = dbHelper.isUserNameAvailable(user);

                        //Selection to check whether the username is available or not.
                        if (isUserNameAvailable) {
                            //Update account data by using a method from the DBHelper class.
                            Boolean update = dbHelper.updateAccountData(currentUsername, user, newPass);

                            //Selection to check whether the data is updated successfully or not.
                            if (update) {
                                //Create a toast to tell the user their data has been updated successfully.
                                Toast.makeText(EditProfileActivity.this, "Account Updated Successfully", Toast.LENGTH_SHORT).show();

                                //Creating a new intent to activity_login.xml
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                                //Starting an new activity based on the intent
                                startActivity(intent);
                            } else {
                                //Create a toast to tell the user their data failed to be updated.
                                Toast.makeText(EditProfileActivity.this, "Account Update Failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    } else {
                        Boolean update = dbHelper.updateAccountData(currentUsername, user, newPass);

                        //Selection to check whether the data is update successfully or not.
                        if (update) {
                            //Create a toast to tell the user their data has been updated successfully.
                            Toast.makeText(EditProfileActivity.this, "Account Updated Successfully", Toast.LENGTH_SHORT).show();

                            //Creating a new intent to activity_login.xml
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                            //Starting an new activity based on the intent
                            startActivity(intent);
                        } else {
                            //Create a toast to tell the user their data failed to be updated.
                            Toast.makeText(EditProfileActivity.this, "Account Update Failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                } else {
                    //Create a toast to tell the user their password is wrong.
                    Toast.makeText(EditProfileActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Create an on c
        // lick listener when the log out button is clicked
        logoutButton.setOnClickListener(view -> {
            //Creating a new intent to activity_login.xml
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

            //Starting an new activity based on the intent
            startActivity(intent);
        });

    }
}