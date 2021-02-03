package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText numberA;
    EditText numberB;
    Button btn;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();

        // находим элементы
        numberA = (EditText) findViewById(R.id.numberA);
        numberB = (EditText) findViewById(R.id.numberB);
        btn = (Button) findViewById(R.id.button);
        answer = (TextView) findViewById(R.id.answer);

        //Получаем текстовые данные
        String A = getIntent().getStringExtra("A");
        String B = getIntent().getStringExtra("B");

        //Присваиваем созданным элементам TextView значение полученных текстовых данных:
        numberA.setText(numberA.getText().toString() + "" + A);
        numberB.setText(numberB.getText().toString() + "" + B);

        //Кнопка "Вернуть"
        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, SolutionActivity.class);
                    intent.putExtra("answer2", answer.getText().toString());
                    intent.putExtra("A", numberA.getText().toString());
                    intent.putExtra("B", numberB.getText().toString());
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.w("Exception", "Не удалось вернуть результат вычесления");
                }
            }
        });
    }

    //кнопка "Решить"
    public void onClick(View v) {
        TextView selection = (TextView) findViewById(R.id.answer);
        float x, a, b;

        // проверяем поля на пустоту
        if (TextUtils.isEmpty(numberA.getText().toString())
                || TextUtils.isEmpty(numberB.getText().toString())) {
            Toast.makeText(this, "Заполните пустые поля", Toast.LENGTH_SHORT).show();
            return;
        }

        // считываем с EditText и заполняем переменные числами
        a = Float.parseFloat(numberA.getText().toString());
        b = Float.parseFloat(numberB.getText().toString());

        x = -b / a;
        DecimalFormat f = new DecimalFormat("0.0");
        if (a == 0 || (a > 0 && b > 0) || (b == 0 && a > 0))
            selection.setText("нет решения");
        else if (a < 0 && b < 0)
            selection.setText("любое решение");
        else if (a < 0 && b > 0)
            selection.setText("x<-" + f.format(x) + " или x>" + f.format(x));
        else if (b == 0 && a < 0)
            selection.setText("x<0" + " или x>0");
        else if (a > 0 && b < 0)
            selection.setText("-" + f.format(x) + "<x<" + f.format(x));
    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(MainActivity.this, SolutionActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.w("Exception", "Не удалось перейти по системной кнопке назад");
        }
    }
}