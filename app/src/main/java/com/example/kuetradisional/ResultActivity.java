package com.example.kuetradisional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tResult;
    ImageView rImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tResult = findViewById(R.id.tResult);

        rImage = findViewById(R.id.rImage);

        rImage.setImageBitmap(getIntent().getParcelableExtra("IMAGE_RESULT"));
        tResult.setText(getIntent().getStringExtra("LABEL_RESULT"));



    }
}