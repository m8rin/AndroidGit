package com.example.lab6;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Task2 extends ListActivity {

    private String[] mCountries = {"Франция", "Испания", "Португалия", "Никарагуа", "Монголия",
            "Великобритания", "Малайзия", "Литва", "Словакия", "Польша", "Эстония", "Румыния",
            "Молдова", "Хорватия", "Япония", "Китай", "Намибия", "Мадагаскар", "Белоруссия"};

    int[] mImageIds = {R.drawable.france, R.drawable.es, R.drawable.pt, R.drawable.ni,R.drawable.mn,
            R.drawable.uk,  R.drawable.my, R.drawable.lt,  R.drawable.sk,  R.drawable.pl,  R.drawable.ee,
            R.drawable.ro,  R.drawable.md, R.drawable.hr,  R.drawable.jp,  R.drawable.cn,  R.drawable.na,
            R.drawable.mg,  R.drawable.by};

    private CountriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // получаем элемент ListView
        ListView countriesList = (ListView) findViewById(R.id.countriesList);

        mAdapter = new CountriesAdapter(this);
        // создаем адаптер
        setListAdapter(mAdapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
       // String selection = mAdapter.getString(position);
    }

    private class CountriesAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        CountriesAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mCountries.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.list_item, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.img);
            image.setImageResource(mImageIds[position]);

            TextView signTextView = (TextView) convertView.findViewById(R.id.textView2);
            signTextView.setText(mCountries[position]);

            return convertView;
        }

        String getString(int position) {
            return mCountries[position];
        }
    }
}