package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavBar);
        android.view.Menu menu = bottomNavigationView.getMenu();
        android.view.MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.searchIcon:
                        Intent toSearchActivity = new Intent(UserActivity.this,SearchActivity.class);
                        startActivity(toSearchActivity);
                        break;
                    case R.id.homeIcon:
                        Intent toHomeActivity = new Intent(UserActivity.this,HomeActivity.class);
                        startActivity(toHomeActivity);
                        break;
                    case R.id.messageIcon:
                        Intent toMessageActivity = new Intent(UserActivity.this,MessageActivity.class);
                        startActivity(toMessageActivity);
                        break;
                    case R.id.userIcon:
                        break;
                }
                return false;
            }
        });
    }
}
