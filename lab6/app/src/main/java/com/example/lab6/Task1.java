package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Task1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        // получаем элемент ListView
        ListView citiesList = (ListView) findViewById(R.id.citiesList);

        // получаем ресурс
        String[] cities = getResources().getStringArray(R.array.cities);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);

        // устанавливаем для списка адаптер
        citiesList.setAdapter(adapter);

        // добавляем для списка слушатель
        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                try {
                    Intent intent = new Intent(Task1.this, DescriptionActivity.class);
                    intent.putExtra("Id", position);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Не удалось открыть", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}