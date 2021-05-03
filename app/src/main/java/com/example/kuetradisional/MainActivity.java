package com.example.kuetradisional;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kuetradisional.ml.Model;
import com.example.kuetradisional.tflite.Classifier;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button takePicture;
    Classifier classifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takePicture = findViewById(R.id.bPicture);

        if (ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 100);
        }

        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {

            int screenOrientation;
            switch (this.getBaseContext().getDisplay().getRotation()) {
                case Surface.ROTATION_270:
                    screenOrientation = 270;
                case Surface.ROTATION_180:
                    screenOrientation = 180;
                case Surface.ROTATION_90:
                    screenOrientation = 90;
                default:
                    screenOrientation = 0;
            };

            int sensorOrientation = 90 - screenOrientation;
            Bitmap resImageBitmap = (Bitmap) data.getExtras().get("data");

            try {
                classifier = Classifier.create(this, Classifier.Device.CPU, -1);
                List<Classifier.Recognition> results;
                results = classifier.recognizeImage(resImageBitmap, sensorOrientation);

                if (results != null && results.size() > 0) {
                    Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                    intent.putExtra("IMAGE_RESULT", resImageBitmap);

                    Classifier.Recognition recognition = results.get(0);
                    if (recognition != null) {
                        String resStr = String.format("%s %.2f", recognition.getTitle(), (100 * recognition.getConfidence())) + "%";
                        intent.putExtra("LABEL_RESULT", resStr);
                        intent.putExtra("LABEL_SAJA", recognition.getTitle());
                    }

                    startActivity(intent);
                }
            } catch (IOException e) {
                Log.e("classifier", "no Classifier found");
            }

        }
    }


}