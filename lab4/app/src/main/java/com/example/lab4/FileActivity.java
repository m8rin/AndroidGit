package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileActivity extends AppCompatActivity {
    private Button btn_count;
    private int mCount = 0;
    public class FileInputOutputStream {

        // Класс для работы потоком вывода из файла
        private FileInputStream inputStream;

        // Класс для работы потоком ввода в файл
        private FileOutputStream outputStream;

        // полный путь к файлу
        private String path;

        public FileInputOutputStream(String path) {
            this.path = path;
        }

        public void read() throws IOException {
            // инициализируем поток вывода из файлу
            inputStream = new FileInputStream(path);

            // читаем первый символ с потока байтов
            int data = inputStream.read();
            char content;

            // если data будет равна 0 то это значит,
            // что файл пуст
            while(data != -1) {
                // переводим байты в символ
                content = (char) data;

                // выводим полученный символ
                System.out.print(content);

                // читаем следующий байты символа
                data = inputStream.read();
            }

            // закрываем поток чтения файла
            inputStream.close();
        }

        public void write(String st) throws IOException {
            // открываем поток ввода в файл
            outputStream = new FileOutputStream(path);

            // записываем данные в файл, но
            // пока еще данные не попадут в файл,
            // а просто будут в памяти
            outputStream.write(st.getBytes());

            // только после закрытия потока записи,
            // данные попадают в файл
            outputStream.close();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        btn_count = (Button) findViewById(R.id.btn_сounter);
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_count.setText("Кликов: " + ++mCount);
            }
        });
    }

}