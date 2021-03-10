package com.example.lab7;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    EditText editText;
    Button btnReset, btnOpenAdd;
    RecyclerView rv;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        btnReset = findViewById(R.id.btn_reset);
        rv = findViewById(R.id.rv);

        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this, dataList);

        rv.setAdapter(adapter);

        String Sub = getIntent().getStringExtra("Sub");
        String Teach = getIntent().getStringExtra("Teach");
        String Cab = getIntent().getStringExtra("Cab");

        String subject = editText.getText().toString().trim() + Sub;
        String teacher = editText.getText().toString().trim() + Teach;
        String cabinet = editText.getText().toString().trim() + Cab;

        if (!subject.equals("") || !subject.equals(null)) {
            MainData data = new MainData();

            data.setSubject(subject);
            data.setTeacher(teacher);
            data.setCabinet(cabinet);

            database.mainDao().insert(data);
            editText.setText("");

            dataList.clear();
            dataList.addAll(database.mainDao().getAll());
            adapter.notifyDataSetChanged();
        }

        //кнопка "Открытие окна добавления"
        btnOpenAdd = findViewById(R.id.btn_open_add);
        btnOpenAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mainDao().reset(dataList);

                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });
    }
}