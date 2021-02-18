package com.example.lab6;

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

    ArrayList<String> c0 = new ArrayList<String>(Arrays.asList("Церковь Святого Духа", "Дом культуры", "Дворец спорта"));
    ArrayList<String> c1 = new ArrayList<String>(Arrays.asList("Ангел Свободы", "Городской сад", "Курортный парк", "Цветочная выставка"));
    ArrayList<String> c2 = new ArrayList<String>(Arrays.asList("Мемориальная клеть Антанаса Баранаускаса,", "Собор св. Матфея", "памятник валун Пунтукас",
            "Резиденция литовского Деда Мороза"));
    ArrayList<String> c3 = new ArrayList<String>(Arrays.asList("Исторический музей", "Освещенный фонтан", "Источник Ариогала", "Гелувская усадьба"));
    ArrayList<String> c4 = new ArrayList<String>(Arrays.asList("Мост", "Лесные скульптуры Рудининкай", "Костёл Святой Троицы"));
    ArrayList<String> c5 = new ArrayList<String>(Arrays.asList("Биржайский замок", "Усадьба Островец", " Биржайский краеведческий музей "));
    ArrayList<String> c6 = new ArrayList<String>(Arrays.asList("Гора Витаутаса", "Градирня минеральной воды", "Вилла Бируте"));
    ArrayList<String> c7 = new ArrayList<String>(Arrays.asList("Костёл Вознесения Пресвятой Девы Марии", "Дом культуры", "Отделение музея Биржайского края"));
    ArrayList<String> c8 = new ArrayList<String>(Arrays.asList("Переход ручья Дережничия", "Памятник Декаде независимости Литвы", "Городская площадь"));
    ArrayList<String> c9 = new ArrayList<String>(Arrays.asList("Костёл святого Александра ", "Музей Жемайтийского епископства,", "Храмы Святых апостолов Петра и Павла"));
    ArrayList<String> c10 = new ArrayList<String>(Arrays.asList("Данные обновляются", "Список появиться в следующем обновление"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        // получаем ресурс
        String[] cities = getResources().getStringArray(R.array.cities);

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

        // создаем адаптер для ListView
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, selectedCity);

        // устанавливаем для списка адаптер
        attractionsList.setAdapter(adapter2);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранный объект
                //String item = (String) parent.getItemAtPosition(position);

                switch (position) {
                    case 0:
                        selectedCity.clear();
                        selectedCity.addAll(c0);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 1:
                        selectedCity.clear();
                        selectedCity.addAll(c1);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 2:
                        selectedCity.clear();
                        selectedCity.addAll(c2);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 3:
                        selectedCity.clear();
                        selectedCity.addAll(c3);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 4:
                        selectedCity.clear();
                        selectedCity.addAll(c4);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 5:
                        selectedCity.clear();
                        selectedCity.addAll(c5);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 6:
                        selectedCity.clear();
                        selectedCity.addAll(c6);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 7:
                        selectedCity.clear();
                        selectedCity.addAll(c7);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 8:
                        selectedCity.clear();
                        selectedCity.addAll(c8);
                        adapter2.notifyDataSetChanged();
                        break;
                    case 9:
                        selectedCity.clear();
                        selectedCity.addAll(c9);
                        adapter2.notifyDataSetChanged();
                        break;
                    default:
                        selectedCity.clear();
                        selectedCity.addAll(c10);
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