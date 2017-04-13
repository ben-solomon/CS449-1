package com.example.cooper.baseballbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class profileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private Button logoutBtn;
    private TextView tvEmailAddress;
    private DatabaseReference databaseReference;
    private Button addBtn;
    private Spinner spinner;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        //later want to make already favorited teams turn the textviews from invisible to visible on creation.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, loginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference("teams");

        spinner = (Spinner)findViewById(R.id.teamSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(profileActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.teamList));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //need to set spinner team as favorite team
        //String teamSelected = spinner.getSelectedItem().toString();
        //Toast.makeText(this, teamSelected, Toast.LENGTH_SHORT).show();;

        logoutBtn = (Button)findViewById(R.id.logoutBtn);
        addBtn = (Button)findViewById(R.id.addFavoriteTeamBtn);
        tvEmailAddress = (TextView)findViewById(R.id.tvEmail);

        tvEmailAddress.setText("Welcome " +user.getEmail());
        addBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String teamSelected = spinner.getSelectedItem().toString();
                if (teamSelected == null || teamSelected == "Choose a team"){
                    return;
                }
                //move team into database
                Toast.makeText(getApplicationContext(), teamSelected+" added.",Toast.LENGTH_LONG);
                saveUserInfo();
                //userInformation thisProfile = new userInformation();
                //thisProfile.favoriteTeams.add(teamSelected);
                //FirebaseUser user = firebaseAuth.getCurrentUser();
               // databaseReference.child(user.getUid()).setValue(thisProfile);
               // databaseReference.child(user.getUid()).setValue(teamSelected);


            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                firebaseAuth.signOut();
                finish();
                Toast.makeText(getApplicationContext(),"User is signed out.",Toast.LENGTH_LONG);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }
    private void saveUserInfo(){
        String teamName = spinner.getSelectedItem().toString();
        if (!TextUtils.isEmpty(teamName)){
            String id = databaseReference.push().getKey();

            userInformation user = new userInformation(teamName);
            databaseReference.child(id).setValue(user);
        }
    }
    //@Override
    //public void onClick(View v){
     /*   if (v == logoutBtn){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        if (v == addBtn){

        }*/
    }

