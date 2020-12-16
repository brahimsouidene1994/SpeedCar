package com.example.speedcar.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.speedcar.global.Constants;
import com.example.speedcar.R;

public class LoginActivity extends AppCompatActivity {



        private EditText emailUser;
        private EditText passwordUser;
        private Button loginUser;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            emailUser = findViewById(R.id.editTextTextEmail);
            passwordUser = findViewById(R.id.editTextTextPassword);
            loginUser = findViewById(R.id.btnLogin);

            loginUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailUser.getText().toString();
                    String password = passwordUser.getText().toString();

                    SharedPreferences preferences = getSharedPreferences(Constants.MY_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(Constants.PREF_IS_CONNECTED, true);
                    editor.putString(Constants.USER_CONNECTED, email);
                    editor.apply();



                    if(controleSaisie(email, password)){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Please check your data", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        private boolean controleSaisie(String email, String password)
        {
            if(email.equals("") || password.equals(""))
            {
                return false;
            }
            else if(!isEmail(email) || !isPassword(password))
            {
                return false;
            }else
            {
                return true;
            }
        }

        private boolean isPassword(String password) {
            if(password.length() < 6)
            {
                return false;
            }
            else
            { return true;}
        }

        private boolean isEmail(String email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
}
