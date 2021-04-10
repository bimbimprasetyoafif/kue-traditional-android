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
    TextView tResult2;
    TextView tResult3;
    ImageView rImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tResult = findViewById(R.id.tResult);
        tResult2 = findViewById(R.id.tResult2);
        tResult3 = findViewById(R.id.tResult3);
        rImage = findViewById(R.id.rImage);

        rImage.setImageBitmap(getIntent().getParcelableExtra("IMAGE_RESULT"));
        tResult.setText(getIntent().getStringExtra("LABEL_RESULT"));
        tResult2.setText(getIntent().getStringExtra("LABEL_RESULT2"));
        tResult3.setText(getIntent().getStringExtra("LABEL_RESULT3"));


    }
}