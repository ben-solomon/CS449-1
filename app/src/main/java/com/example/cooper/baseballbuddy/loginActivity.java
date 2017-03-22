package com.example.cooper.baseballbuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Cooper1 on 3/17/2017.
 */


public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmailAddress;
    private EditText etPassword;
    private Button login;
    private Button registerBtn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmailAddress = (EditText)findViewById(R.id.etUsernameLogin);
        etPassword = (EditText)findViewById(R.id.etPasswordLogin);
        login = (Button)findViewById(R.id.loginActivityBtn);
        registerBtn = (Button)findViewById(R.id.loginRegisterNowBtn);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(this);
        if (firebaseAuth.getCurrentUser() != null){
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),profileActivity.class));
        }
    }
    private void userLogin(){
        String email = etEmailAddress.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email address is empty.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password is empty.", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logging in User...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            //start profile
                            finish();
                            startActivity(new Intent(getApplicationContext(),profileActivity.class));
                        }
                    }
                });
    }
    @Override
    public void onClick(View v){
        if (v == login){
            userLogin();

        }
        if (v == registerBtn){
            startActivity(new Intent(this, registerActivity.class));
        }
    }
}
