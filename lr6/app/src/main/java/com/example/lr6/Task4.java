package com.example.lr6;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 extends AppCompatActivity {

    ArrayList<String> selectedCity = new ArrayList<String>(Arrays.asList("List Item A"));

    ArrayList<String> c0 = new ArrayList<String>(Arrays.asList("Музей разводов", "Церковь святого марка", "Загребкий кафедральный сбор"));
    ArrayList<String> c1 = new ArrayList<String>(Arrays.asList("Дорец Диоклетиана", "Сплитский собор", "Местроллик галлери", "Цветочная выставка"));
    ArrayList<String> c2 = new ArrayList<String>(Arrays.asList("Собор святого Вита", "Trsat Fortress", "Rijeka Tourist Board","Капуцинская церковь"));
    ArrayList<String> c3 = new ArrayList<String>(Arrays.asList("Копачки Рит", "Собор святых Петра и Павла", "Музей Славоники"));
    ArrayList<String> c4 = new ArrayList<String>(Arrays.asList("Церковь свтого Доната", "Собор святой Анастасии", "Морской орган"));
    ArrayList<String> c5 = new ArrayList<String>(Arrays.asList("Бриуны", "Амфитеатр", " Храм Августа "));
    ArrayList<String> c6 = new ArrayList<String>(Arrays.asList("Гора Витаутаса", "Градирня минеральной воды", "Вилла Бируте"));
    ArrayList<String> c7 = new ArrayList<String>(Arrays.asList("Костёл Вознесения Пресвятой Девы Марии", "Дом культуры", "Отделение музея Биржайского края"));
    ArrayList<String> c8 = new ArrayList<String>(Arrays.asList("Переход ручья Дережничия", "Памятник Декаде независимости Литвы", "Городская площадь"));
    ArrayList<String> c9 = new ArrayList<String>(Arrays.asList("Костёл святого Александра ", "Музей Жемайтийского епископства,", "Храмы Святых апостолов Петра и Павла"));
    ArrayList<String> c10 = new ArrayList<String>(Arrays.asList("Данные обновляются", "Список появиться в следующем обновление"));



    String [] c00 = new String [] {"Музей разводов1", "Церковь святого марка", "Загребкий кафедральный сбор"};
    String [] c01 = new String [] {"Музей разводов2", "Церковь святого марка", "Загребкий кафедральный сбор"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        // получаем ресурс
        String[] cities = getResources().getStringArray(R.array.Croatia);

        TextView tw = (TextView) findViewById(R.id.textView4);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);

        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        // получаем элемент ListView
        ListView attractionsList = (ListView) findViewById(R.id.attractionsList);

        final ArrayList<String> catNames = new ArrayList<>();

        final ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);

        // Привяжем массив через адаптер к ListView
        attractionsList.setAdapter(adapter2);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранный объект
                //String item = (String) parent.getItemAtPosition(position);
                String[] count1;
                switch (position) {
                    case 0:
                        count1 = getResources().getStringArray(R.array.countries);
                        catNames.clear();
                        catNames.addAll(Arrays.asList(count1));
                        adapter2.notifyDataSetChanged();
                        break;
                    case 1:
                        count1 = getResources().getStringArray(R.array.countries2);
                        catNames.clear();
                        catNames.addAll(Arrays.asList(count1));
                        adapter2.notifyDataSetChanged();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        adapter2.notifyDataSetChanged();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


    }
}