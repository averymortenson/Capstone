package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CoreRequirementsActivity extends AppCompatActivity {

    TextView tvCSS301;
    TextView tvCSS342;
    TextView tvCSS343;
    TextView tvCSS350;
    TextView tvCSS360;
    TextView tvCSS370;
    TextView tvCSS422;
    TextView tvCSS430;
    TextView tvCSS497;
    ImageView backImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corerequirements);

        tvCSS301 = findViewById(R.id.css301TV);
        tvCSS342 = findViewById(R.id.css342TV);
        tvCSS343 = findViewById(R.id.css343TV);
        tvCSS350 = findViewById(R.id.css350TV);
        tvCSS360 = findViewById(R.id.css360TV);
        tvCSS370 = findViewById(R.id.css370TV);
        tvCSS422 = findViewById(R.id.css422TV);
        tvCSS430 = findViewById(R.id.css430TV);
        tvCSS497 = findViewById(R.id.css497TV);
        backImg = (ImageView) findViewById(R.id.backImage);

        // on click listeners to change screen view.

        // go to css301 screen.
        tvCSS301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS301 = new Intent(CoreRequirementsActivity.this, CSS301Activity.class);
                startActivity(toCSS301);
            }
        });

        // go to css342 screen.
        tvCSS342.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS342 = new Intent(CoreRequirementsActivity.this,CSS342Activity.class);
                startActivity(toCSS342);
            }
        });

        // go to css343 screen.
        tvCSS343.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS343 = new Intent(CoreRequirementsActivity.this,CSS343Activity.class);
                startActivity(toCSS343);
            }
        });

        // go to css350 screen.
        tvCSS350.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS350 = new Intent(CoreRequirementsActivity.this,CSS350Activity.class);
                startActivity(toCSS350);
            }
        });

        // go to css360 screen.
        tvCSS360.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS360 = new Intent(CoreRequirementsActivity.this, CSS360Activity.class);
                startActivity(toCSS360);
            }
        });

        // go to css370 screen.
        tvCSS370.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS370 = new Intent(CoreRequirementsActivity.this, CSS370Activity.class);
                startActivity(toCSS370);
            }
        });

        // go to css422 screen.
        tvCSS422.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS422 = new Intent(CoreRequirementsActivity.this, CSS422Activity.class);
                startActivity(toCSS422);
            }
        });

        // go to css420 screen.
        tvCSS430.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS430 = new Intent(CoreRequirementsActivity.this, CSS430Activity.class);
                startActivity(toCSS430);
            }
        });

        tvCSS497.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCSS497 = new Intent(CoreRequirementsActivity.this, CSS497Activity.class);
                startActivity(toCSS497);
            }
        });

        // go to the home screen.
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomeActivity = new Intent(CoreRequirementsActivity.this, HomeActivity.class);
                startActivity(toHomeActivity);
            }
        });
    }
}
