package com.example.cooper.baseballbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class profileActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private Button logoutBtn;
    private TextView tvEmailAddress;
    private DatabaseReference databaseReference;
    private Button addBtn;
    private Spinner spinner;
    String []  SPINNERLIST ={"Arizona Diamondbacks", "Atlanta Braves", "Baltimore Orioles","Boston Red Sox","Chicago Cubs","Chicago White Sox","Cincinnati Reds","Cleveland Indians","Colorado Rockies"," Detroit Tigers","Miami Marlins","Houston Astros"," Kansas City Royals","Los Angeles Angels of Anaheim","Los Angeles Dodgers","Milwaukee Brewers","Minnesota Twins","New York Mets","New York Yankees","Oakland Athletics","Philadelphia Phillies","Pittsburgh Pirates","Saint (St.) Louis Cardinals","San Diego Padres","San Francisco Giants","Seattle Mariners","Tampa Bay Rays","Texas Rangers"," Toronto Blue Jays","Washington Nationals"};
    //List of all MLB teams, will take the selected ones from user and use the teamID from fantasydata API to get relevant info to selected teams
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, loginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        spinner = (Spinner)findViewById(R.id.teamSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(profileActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.teamList));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //need to set spinner team as favorite team


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner)findViewById(R.id.materialBetterSpinner);
        betterSpinner.setAdapter(arrayAdapter);

        logoutBtn = (Button)findViewById(R.id.logoutBtn);
        addBtn = (Button)findViewById(R.id.addFavoriteTeamBtn);
        tvEmailAddress = (TextView)findViewById(R.id.tvEmail);

        tvEmailAddress.setText("Welcome " +user.getEmail());
        addBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
    }
    private void saveUserInfo(){
        //need to get text format of dropdown box
    }
    @Override
    public void onClick(View v){
        if (v == logoutBtn){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        if (v == addBtn){

        }
    }
}
