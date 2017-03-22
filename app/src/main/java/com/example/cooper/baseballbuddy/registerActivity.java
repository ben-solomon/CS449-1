package com.example.cooper.baseballbuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Cooper1 on 3/17/2017.
 */

public class registerActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmailAddress;
    private EditText etPassword;
    private Button registerBtn;
    private ProgressDialog progressDialog;
    private FirebaseAuth fireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog = new ProgressDialog(this);
        fireBaseAuth = FirebaseAuth.getInstance();
         etEmailAddress = (EditText)findViewById(R.id.etNameRegister);
         etPassword = (EditText)findViewById(R.id.etPasswordRegister);
         //final EditText etFavoriteTeam1ID = (EditText)findViewById(R.id.etFavoriteTeam1ID); // Take their team and get its ID later
         registerBtn = (Button)findViewById(R.id.registerActivityBtn);
        registerBtn.setOnClickListener(this);

        /*registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                final String username = etEmailAddress.getText().toString();
                final String password = etPassword.getText().toString();
               // final String favoriteTeam1ID = etFavoriteTeam1ID.getText().toString();
                final String favoriteTeam2ID = null;
                final String favoriteTeam3ID = null;

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                Intent intent = new Intent(registerActivity.this,loginActivity.class);
                                registerActivity.this.startActivity(intent);

                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(registerActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(password,username,favoriteTeam1ID,favoriteTeam2ID,favoriteTeam3ID,responseListener);
                RequestQueue queue = Volley.newRequestQueue(registerActivity.this);
                queue.add(registerRequest);
            }
        });*/

    }
    private void registerUser(){
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
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        fireBaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            //later will trigger a new activity, just adding a toast for now to checkpoint it
                            Toast.makeText(registerActivity.this, "Register successful", Toast.LENGTH_SHORT).show();
                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(registerActivity.this, "Register UNsuccessful", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    @Override
    public void onClick(View v){
        if (v == registerBtn){
            registerUser();
        }
    }
}
