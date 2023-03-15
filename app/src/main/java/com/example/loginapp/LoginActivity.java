package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edituser,editpassword;
    Button btnlogin;
    TextView register,forgotPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edituser = findViewById(R.id.editTextusername);
        editpassword = findViewById(R.id.editTextpassword);
        btnlogin = findViewById(R.id.buttonlogin);
        register = findViewById(R.id.register);
        forgotPassword = findViewById(R.id.forgotPassword);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edituser.getText().toString();
                String password = editpassword.getText().toString();
                Database db = new Database(getApplicationContext(),"firstAppMobile",null,1); // instituation db

                if(username.length()==0 || password.length()==0){

                    Toast.makeText(getApplicationContext(),"Please fill all detais",Toast.LENGTH_SHORT).show();
                }else{
                  if (db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(),"login Successfully",Toast.LENGTH_SHORT).show();
                      SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                      SharedPreferences.Editor editor = sharedPreferences.edit();
                      editor.putString("username",username);
                      // to save our data with key and value
                      editor.apply();


                        startActivity(new Intent(LoginActivity.this,ListViewActivity.class));
                  }else {
                      Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_SHORT).show();
                  }

                 }
            }
        });

        ////////////////////////////////////
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


        ////////////////////////////////////
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}