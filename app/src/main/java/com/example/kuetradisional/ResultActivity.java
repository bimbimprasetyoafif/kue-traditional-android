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
    Button bReceipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tResult = findViewById(R.id.tResult);
        rImage = findViewById(R.id.rImage);
        bReceipe = findViewById(R.id.bResep);

        rImage.setImageBitmap(getIntent().getParcelableExtra("IMAGE_RESULT"));
        tResult.setText(getIntent().getStringExtra("LABEL_RESULT"));

        bReceipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainReceipe.class);
                intent.putExtra("LABEL", getIntent().getStringExtra("LABEL_SAJA"));
                startActivity(intent);
            }
        });

    }
}