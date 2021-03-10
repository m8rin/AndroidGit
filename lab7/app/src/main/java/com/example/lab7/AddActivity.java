package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    EditText editText1, editTextTeacher, editTextRoom;
    Button btnAdd;
    RecyclerView rv;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText1 = findViewById(R.id.edit_text1);

        btnAdd = findViewById(R.id.btn_add);

        database = RoomDB.getInstance(this);

        dataList = database.mainDao().getAll();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sText = editText1.getText().toString().trim();

                if (!sText.equals("")) {
                    //when text is not empty
                    MainData data = new MainData();
                    data.setText(sText);
                    database.mainDao().insert(data);

                    editText1.setText("");

                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());

                }

                Intent i = new Intent(AddActivity.this,MainActivity.class);
                i.putExtra("Sub", editText1.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }
}