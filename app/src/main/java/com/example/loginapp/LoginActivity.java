package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

                if(username.length()==0 || password.length()==0){

                    Toast.makeText(getApplicationContext(),"Please fill all detais",Toast.LENGTH_SHORT).show();
                }else{
                  if (username.equals("admin")&& password.equals("admin")){
                        Toast.makeText(getApplicationContext(),"login Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,ListViewActivity.class));
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