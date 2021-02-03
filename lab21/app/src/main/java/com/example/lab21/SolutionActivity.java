package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class SolutionActivity extends AppCompatActivity {
    EditText numberA;
    EditText numberB;
    Button btn_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        numberA = (EditText) findViewById(R.id.numberA);
        numberB = (EditText) findViewById(R.id.numberB);
        btn_Send = (Button) findViewById(R.id.btn_Send);

        //Обрабатываем нажатие кнопки "Передать"
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(SolutionActivity.this, MainActivity.class);
                    intent.putExtra("A", numberA.getText().toString());
                    intent.putExtra("B", numberB.getText().toString());
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.w("Exception", "Не удалось перейти по кнопке передать");
                }
            }
        });

        //Получаем текстовые данные с первого Activity:
        String A = getIntent().getStringExtra("A");
        String B = getIntent().getStringExtra("B");
        String answer = answer = getIntent().getStringExtra("answer2");

        //Присваиваем созданным элементам TextView значение полученных данных:
        TextView answer2 = (TextView)findViewById(R.id.answer2) ;
        if(answer == null){
            answer2.setText(answer2.getText().toString());
        }else if(answer.isEmpty()){
            answer2.setText("Error:\nНе все поля были заполнены, попробуйте еще раз");
        }
        else{
            answer2.setText("При А = "+ A + " и В = "+ B +"\nОтвет: " +  answer);
        }
    }

    //Системная кнопка "назад"
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(SolutionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            Log.w("Exception", "Не удалось перейти по системной кнопке назад");
        }
    }
}