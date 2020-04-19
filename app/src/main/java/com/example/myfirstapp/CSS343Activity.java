package com.example.myfirstapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CSS343Activity extends AppCompatActivity {

    ImageView backI;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css343);

        backI = (ImageView) findViewById(R.id.backImage);

        backI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCoreReqs = new Intent(CSS343Activity.this, CoreRequirementsActivity.class);
                startActivity(toCoreReqs);
            }
        });


    }
}
