package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Task3 extends Activity {
    int parity = 1; //для определения четности нажатия на кнопку

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        Button buttonShowHide = (Button) findViewById(R.id.btn_anim);

        buttonShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parity++;
                if (parity % 2 == 0) {
                    buttonShowHide.setText("STOP");
                    MySurfaceView.check = true;
                } else {
                    buttonShowHide.setText("START");
                    MySurfaceView.check = false;
                }
            }
        });
    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            MySurfaceView.check = false;
            MyThread.myThreadRun = false;

            Intent intent = new Intent(Task3.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.w("Exception", "Не удалось перейти по системной кнопке назад");
        }
    }
}