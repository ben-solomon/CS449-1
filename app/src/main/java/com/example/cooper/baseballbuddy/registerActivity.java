package com.example.cooper.baseballbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Cooper1 on 3/17/2017.
 */

public class registerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         final EditText etUsername = (EditText)findViewById(R.id.etNameRegister);
         final EditText etPassword = (EditText)findViewById(R.id.etPasswordRegister);
         final EditText etFavoriteTeam1ID = (EditText)findViewById(R.id.etFavoriteTeam1ID); // Take their team and get its ID later
         final Button registerBtn = (Button)findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String favoriteTeam1ID = etFavoriteTeam1ID.getText().toString();
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
        });

    }
}
