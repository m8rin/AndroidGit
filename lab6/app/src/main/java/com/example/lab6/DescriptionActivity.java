package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        tw = (TextView) findViewById(R.id.textView2);

        //Получаем данные
        int position = getIntent().getIntExtra("Id",1);
        //Присваиваем созданным элементам TextView значение полученных текстовых данных:

        // получаем ресурс
        String[] description = getResources().getStringArray(R.array.description);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, description);


        tw.setText(description[position]);
    }
}