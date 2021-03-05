package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button task1 = (Button) findViewById(R.id.task1);
        Button task2 = (Button) findViewById(R.id.task2);
        Button task3 = (Button) findViewById(R.id.task3);
        Button task4 = (Button) findViewById(R.id.task4);

        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Town.class);
                startActivity(intent);
            }
        });
        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Country.class);
                startActivity(intent);
            }
        });
        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Country2.class);
                startActivity(intent);
            }
        });
        task4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task4.class);
                startActivity(intent);
            }
        });
    }
}