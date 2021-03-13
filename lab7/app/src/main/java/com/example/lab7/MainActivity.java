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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private long backPressedTime;
    private Toast backToast;

    EditText editText;
    TextView textView;
    Button btnReset, btnOpenAdd, btnReturn;
    ImageView btnSearch;
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
        btnSearch = findViewById(R.id.btn_search);
        btnReturn = findViewById(R.id.btn_return);
        rv = findViewById(R.id.rv);
        textView = findViewById(R.id.textViewSearch);

        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this, dataList);
        rv.setAdapter(adapter);

        String subject = "" + getIntent().getStringExtra("Sub");
        String teacher = "" + getIntent().getStringExtra("Teach");
        String cabinet = "" + getIntent().getStringExtra("Cab");

        if (!subject.equals("null")) {
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

        //кнопка "удалить все"
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mainDao().reset(dataList);

                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });

        //кнопка поиска
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //добавляем %, чтобы находить все записи, которые содержат вводимое значение
                String search = "%" + editText.getText().toString().trim() + "%";
                database.mainDao().getAllWithNameLike(search);

                dataList.clear();
                dataList.addAll(database.mainDao().getAllWithNameLike(search));
                adapter.notifyDataSetChanged();

                search = editText.getText().toString().trim();
                textView.setText("Результаты по запросу: " + search);

                btnReturn.setVisibility(View.VISIBLE);
                btnReturn.setLayoutParams(new LinearLayout.LayoutParams(1000, 150));

                if (search.equals("")) {
                    textView.setText("");
                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        //кнопка "вернуться к списку"
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");

                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();

                btnReturn.setVisibility(View.INVISIBLE);
                btnReturn.setLayoutParams(new LinearLayout.LayoutParams(1000, 0));
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