package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.provider.Telephony.Mms.Part.FILENAME;


public class FileActivity extends AppCompatActivity {
    private Button btn_count, btn_save;
    private int mCount = 0;
    int cc = 0;
    FileWriter fileWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        btn_count = (Button) findViewById(R.id.btn_сounter);

        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
            String str = "";

            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d("LOG_TAG", str);
                btn_count.setText("Кликов: " + str);
                mCount = Integer.parseInt(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Кнопка счетчик
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                btn_count.setText("Кликов: " + mCount);
            }
        });

        //кнопка сохранения счета
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // отрываем поток для записи
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput(FILENAME, MODE_PRIVATE)));
                    // пишем данные
                    bw.write(mCount + "");
                    // закрываем поток
                    bw.close();
                    Log.d("LOG_TAG", "Файл записан");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}