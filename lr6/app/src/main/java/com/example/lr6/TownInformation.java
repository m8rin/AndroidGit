package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TownInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_information);
        int position = getIntent().getIntExtra("id",1);

        String[] inf = getResources().getStringArray(R.array.info);
        String[]t = getResources().getStringArray(R.array.Croatia);
        //ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, inf);

        TextView townName = (TextView) findViewById(R.id.townName);
        townName.setText(t[position]);
        TextView townInfo = (TextView) findViewById(R.id.townInfo);
        townInfo.setText(inf[position]);
    }
}