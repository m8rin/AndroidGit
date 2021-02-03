package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {

    Button btn_camera;
    ImageView ImageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ImageView = findViewById(R.id.imageView);
        //Кнопка "Камера"
        btn_camera = (Button) findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    if(i.resolveActivity(getPackageManager()) != null){
                        startActivityForResult(i, REQUEST_IMAGE_CAPTURE);
                    }else {
                        Toast.makeText(getApplicationContext(), "Нечем снимать", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Log.w("Exception", "Не удалось открыть задание 2");
                }


            }
        });
    }

    //получение отклика от камеры
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap)extras.get("data");
            ImageView.setImageBitmap(imageBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}