package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavBar);
        android.view.Menu menu = bottomNavigationView.getMenu();
        android.view.MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.searchIcon:
                        break;
                    case R.id.homeIcon:
                        Intent toHomeActivity = new Intent(SearchActivity.this,HomeActivity.class);
                        startActivity(toHomeActivity);
                        break;
                    case R.id.messageIcon:
                        Intent toMessageActivity = new Intent(SearchActivity.this, MessageActivity.class);
                        startActivity(toMessageActivity);
                        break;
                    case R.id.userIcon:
                        Intent toUserActivity = new Intent(SearchActivity.this,UserActivity.class);
                        startActivity(toUserActivity);
                        break;
                }
                return false;
            }
        });
    }
}
