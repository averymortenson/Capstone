package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StatisticsActivity extends AppCompatActivity {

    ImageView backImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        backImg = (ImageView) findViewById(R.id.backButton);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrerequisiteActivity = new Intent(StatisticsActivity.this,PrerequisiteActivity.class);
                startActivity(toPrerequisiteActivity);
            }
        });
    }
}
