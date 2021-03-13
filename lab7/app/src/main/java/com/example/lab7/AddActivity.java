package com.example.lab7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AddActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button btnAdd;

    List<MainData> dataList = new ArrayList<>();
    RoomDB database;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);
        editText3 = findViewById(R.id.edit_text3);
        btnAdd = findViewById(R.id.btn_add);

        database = RoomDB.getInstance(this);
        dataList = database.mainDao().getAll();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddActivity.this, MainActivity.class);
                i.putExtra("Sub", editText1.getText().toString().trim());
                i.putExtra("Teach", editText2.getText().toString().trim());
                i.putExtra("Cab", editText3.getText().toString().trim());
                startActivity(i);
                finish();
            }
        });
    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.w("Exception", "Не удалось перейти по системной кнопке назад");
        }
    }
}