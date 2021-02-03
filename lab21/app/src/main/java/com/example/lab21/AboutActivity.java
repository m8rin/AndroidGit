package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Кнопка "Назад"
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(AboutActivity.this, StartActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.w("Exception", "Не удалось вернуться по кнопке назад");
                }
            }
        });

        //Если нажать на картинку с изображением автора в окне об авторе
        ImageView image2 = (ImageView) findViewById(R.id.image2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Если хотите более подробную информацию, обратитесь по почте.",
                        LENGTH_SHORT).show();
            }
        });
    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(AboutActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.w("Exception", "Не удалось перейти по системной кнопке назад");
        }
    }
}