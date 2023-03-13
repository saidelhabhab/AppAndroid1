package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edituser,editemail,editpassword,editconfirm_password;
    Button btnRegister;
    TextView gotologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edituser = findViewById(R.id.editTextusername);
        editemail = findViewById(R.id.editTextemail);
        editpassword = findViewById(R.id.editTextpassword);
        editconfirm_password = findViewById(R.id.editTextconfirm_password);
        btnRegister = findViewById(R.id.buttonregister);
        gotologin = findViewById(R.id.gotoemail);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edituser.getText().toString();
                String email = editemail.getText().toString();
                String password = editpassword.getText().toString();
                String config_password = editconfirm_password.getText().toString();

                if(username.length()==0 || email.length()==0 || password.length()==0 || config_password.length()==0){

                    Toast.makeText(getApplicationContext(),"Please fill all detais",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(config_password) == 0){

                        if(isValid(password)){

                        }else{
                            Toast.makeText(getApplicationContext(),"password must contain at least 8 characters, havinn letter, digital and number",Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(),"Password and confirm password didin't match",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        ////////////////////////////////////
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    public boolean isValid(String passwordHere){

        int f1=0,f2=0,f3=0;
        if (passwordHere.length()<8){
            return false;
        }else {
            for (int p=0;p<passwordHere.length();p++){
                if (Character.isLetter(passwordHere.charAt(p))) f1=1;
            }

            for (int r=0;r<passwordHere.length();r++){
                if (Character.isDigit(passwordHere.charAt(r))) f2=1;
            }

            for (int s=0;s<passwordHere.length();s++){
                char c = passwordHere.charAt(s);
                if (c>=33 && c<=46 || c==64)   f3=1;

            }
        }

        if (f1== 1 && f2==1 && f3 ==1) return true;

        return false;
    }
}