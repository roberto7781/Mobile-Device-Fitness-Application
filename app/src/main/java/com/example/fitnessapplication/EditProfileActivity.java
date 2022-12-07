package com.example.fitnessapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private EditText userName, password, newPassword;
    private DBHelper dbHelper;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        userName = findViewById(R.id.username);
        password = findViewById(R.id.oldpassword);
        newPassword = findViewById(R.id.newpassword);

        Button editProfileButton = findViewById(R.id.editProfileBtn);
        Button logoutButton = findViewById(R.id.logoutBtn);

        dbHelper = new DBHelper(this);

        Intent currentIntent = getIntent();

        String currentUsername = sharedPreferences.getString("username", "Not Found");

        userName.setText(currentUsername);


        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                String newPass = newPassword.getText().toString();

                if (user.equals("") || pass.equals("") || newPass.equals("")) {
                    Toast.makeText(EditProfileActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean validateAccount = dbHelper.validateAccount(currentUsername, pass);

                    if (validateAccount) {
                        if (!currentUsername.equals(user)) {
                            Boolean isUserNameAvailable = dbHelper.isUserNameAvailable(user);

                            if (isUserNameAvailable) {
                                Boolean update = dbHelper.updateAccountData(currentUsername, user, newPass);

                                if (update) {
                                    Toast.makeText(EditProfileActivity.this, "Account Updated Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(EditProfileActivity.this, "Account Update Failed", Toast.LENGTH_SHORT).show();

                                }
                            }
                        } else {
                            Boolean update = dbHelper.updateAccountData(currentUsername, user, newPass);

                            if (update) {
                                Toast.makeText(EditProfileActivity.this, "Account Updated Successfully", Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username", user);
                                editor.putString("password", newPass);
                                editor.apply();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(EditProfileActivity.this, "Account Update Failed", Toast.LENGTH_SHORT).show();

                            }
                        }

                    } else {
                        Toast.makeText(EditProfileActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

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
}