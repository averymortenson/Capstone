package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    Button btnLogout;
    Button btnCoreRequirements;
    Button btnPrerequisites;
    Button btnMajorReviews;

    FirebaseAuth mFireBaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.logout);
        btnCoreRequirements = findViewById(R.id.coreRequirementsButton);
        btnPrerequisites = findViewById(R.id.prerequisiteButton);
        btnMajorReviews = findViewById(R.id.majorReviewsButton);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavBar);
        android.view.Menu menu = bottomNavigationView.getMenu();
        android.view.MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.searchIcon:
                        Intent toSearchActivity = new Intent(HomeActivity.this,SearchActivity.class);
                        startActivity(toSearchActivity);
                        break;
                    case R.id.homeIcon:
                        break;
                    case R.id.messageIcon:
                        Intent toMessageActivity = new Intent(HomeActivity.this, MessageActivity.class);
                        startActivity(toMessageActivity);
                        break;
                    case R.id.userIcon:
                        Intent toUserActivity = new Intent(HomeActivity.this,UserActivity.class);
                        startActivity(toUserActivity);
                        break;
                }
                return false;
            }
        });

        btnPrerequisites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrerequisiteScreen = new Intent(HomeActivity.this,PrerequisiteActivity.class);
                startActivity(toPrerequisiteScreen);
            }
        });

        btnCoreRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCoreReqsScreen = new Intent(HomeActivity.this, CoreRequirementsActivity.class);
                startActivity(toCoreReqsScreen);
            }
        });

        btnMajorReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMajorReviews = new Intent(HomeActivity.this, MajorReviewsActivity.class);
                startActivity(toMajorReviews);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToLogin = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intToLogin);
            }
        });


    }
}
