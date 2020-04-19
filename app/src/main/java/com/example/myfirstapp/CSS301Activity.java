package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CSS301Activity extends AppCompatActivity {

    ImageView backImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css301);

        backImg = (ImageView) findViewById(R.id.backImage);

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCoreReqs = new Intent(CSS301Activity.this, CoreRequirementsActivity.class);
                startActivity(toCoreReqs);
            }
        });
    }
}
