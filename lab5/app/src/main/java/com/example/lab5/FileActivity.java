package com.example.lab5;

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
import java.util.concurrent.ThreadPoolExecutor;

import static android.provider.Telephony.Mms.Part.FILENAME;


public class FileActivity extends AppCompatActivity{
    private Button btn_count, btn_sum;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        btn_count = (Button) findViewById(R.id.btn_сounter);

        /*try {
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
        }*/

        //Кнопка счетчик
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String str = "";
                str = Integer.toString(mCount);
                try {
                    Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Hello!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Кнопка суммы
        btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long f = 0;
                for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; f += i++);
                try {
                    btn_sum.setText("ГОТОВО " + f);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Не удалось посчитать", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}