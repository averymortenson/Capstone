package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class STMATH125Activity extends AppCompatActivity {

    ImageView backImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stmath125);

        backImg = (ImageView) findViewById(R.id.backButton);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrerequisiteActivity = new Intent(STMATH125Activity.this,PrerequisiteActivity.class);
                startActivity(toPrerequisiteActivity);
            }
        });
    }
}
