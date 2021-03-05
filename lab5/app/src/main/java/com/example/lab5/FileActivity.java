package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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

public class FileActivity extends AppCompatActivity {
    private Button btn_count, btn_sum;
    private int mCount = 0;
    long f = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        btn_count = (Button) findViewById(R.id.btn_сounter);

        //Кнопка счетчик
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String str = "";
                str = Integer.toString(mCount);
                try {
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Не удалось(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Кнопка суммы
        btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    public void run() {
                        f = 0;
                        Log.i("process_thread", "beginning...");

                        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; f += i++) ;

                        MyOutput MyOutput = new MyOutput();
                        MyOutput.execute();
                        Log.i("process_thread", "Результат вычисления: " + f);
                    }
                };
                Thread thread = new Thread(runnable);
                Log.i("process_thread", "start");
                thread.start();
                Log.i("process_thread", "end");
            }
        });
    }

    class MyOutput extends AsyncTask<Void, Void, Long> {

        @Override
        protected Long doInBackground(Void... voids) {
            return f;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Long aLong) {
            Toast.makeText(getApplicationContext(), "Готово!\n" + aLong, Toast.LENGTH_LONG).show();
        }
    }
}