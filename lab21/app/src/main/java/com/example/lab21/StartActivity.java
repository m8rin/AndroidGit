package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class StartActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Кнопка "Математика"
        Button btn_Math = (Button) findViewById(R.id.btn_Math);
        btn_Math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(StartActivity.this, SolutionActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.w("Exception", "Не удалось перейти по кнопке математика");
                }
            }
        });

        //Кнопка "Выход"
        Button btn_Exit = (Button) findViewById(R.id.btn_Exit);
        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    finish();
                } catch (Exception e) {
                    Log.w("Exception", "Не удалось закрыть приложение");
                }
            }
        });

        //Картинка с изображением автора
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(StartActivity.this, AboutActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.w("Exception", "Не удалось открыть сведения об авторе");
                }
            }
        });
    }

    //Системная кнопка "назад"
    //Выход из приложения двойным кликом
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finish();
            return;
        } else {
            backToast = Toast.makeText(this, "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
