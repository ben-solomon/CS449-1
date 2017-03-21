package com.example.cooper.baseballbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Cooper1 on 3/17/2017.
 */


public class loginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText etUsername = (EditText)findViewById(R.id.etUsernameLogin);
        final EditText etPassword = (EditText)findViewById(R.id.etPasswordLogin);
        final Button loginBtn = (Button)findViewById(R.id.loginBtn);
        final Button registerBtn = (Button)findViewById(R.id.loginRegisterNowBtn);
        registerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(loginActivity.this, registerActivity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                final String username = etUsername.toString();
                final String password = etPassword.toString();

            }
        });
    }
}
