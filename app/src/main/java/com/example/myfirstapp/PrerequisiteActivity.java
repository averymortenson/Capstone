package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrerequisiteActivity extends AppCompatActivity {

    TextView tvEnglishComposition;
    TextView tvAdvancedComposition;
    TextView tvCSS142;
    TextView tvCSS143;
    TextView tvSTMATH124;
    TextView tvSTMATH125;
    TextView tvStatistics;
    ImageView backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prerequisite);

        tvEnglishComposition = findViewById(R.id.css301TV);
        tvAdvancedComposition = findViewById(R.id.css342TV);
        tvCSS142 = findViewById(R.id.css343TV);
        tvCSS143 = findViewById(R.id.css350TV);
        tvSTMATH124 = findViewById(R.id.css360TV);
        tvSTMATH125 = findViewById(R.id.css370TV);
        tvStatistics = findViewById(R.id.css422TV);
        backButton = (ImageView) findViewById(R.id.backImage);

        // go back to the home page via the back button.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomeActivity = new Intent(PrerequisiteActivity.this,HomeActivity.class);
                startActivity(toHomeActivity);
            }
        });

        // go to the english composition screen.
        tvEnglishComposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEnglishComp = new Intent(PrerequisiteActivity.this, EnglishCompActivity.class);
                startActivity(toEnglishComp);
            }
        });

        // go to the advanced composition screen.
        tvAdvancedComposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAdvancedComp = new Intent(PrerequisiteActivity.this,AdvancedCompActivity.class);
                startActivity(toAdvancedComp);
            }
        });

        // go to CSS142 screen
        tvCSS142.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS142 = new Intent(PrerequisiteActivity.this, CSS142Activity.class);
                startActivity(toCSS142);
            }
        });

        // go to CSS143 screen.
        tvCSS143.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS143 = new Intent(PrerequisiteActivity.this,CSS143Activity.class);
                startActivity(toCSS143);
            }
        });

        // go to STMATH 124 screen
        tvSTMATH124.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSTMATH124 = new Intent(PrerequisiteActivity.this, STMATH124Activity.class);
                startActivity(toSTMATH124);
            }
        });

        // go to STMATH 125 screen.
        tvSTMATH125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSTMATH125 = new Intent(PrerequisiteActivity.this, STMATH125Activity.class);
                startActivity(toSTMATH125);
            }
        });

        // go to the statistics screen.
        tvStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStatistics = new Intent(PrerequisiteActivity.this, StatisticsActivity.class);
                startActivity(toStatistics);
            }
        });

    }
}
