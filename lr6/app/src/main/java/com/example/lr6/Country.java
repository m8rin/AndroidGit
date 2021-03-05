package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Country extends ListActivity {

    String[] t;
    int[] img = {R.drawable.fr, R.drawable.spain, R.drawable.portugal,R.drawable.nicaragua,R.drawable.mongolia_640,
            R.drawable.united_kingdom_640,R.drawable.malaysia_640,R.drawable.lithuania_640,R.drawable.slovakia_640,
            R.drawable.poland_640,R.drawable.estonia_640,R.drawable.romania_640,R.drawable.moldova_640,
            R.drawable.croatia_640,R.drawable.japan_640,R.drawable.china_640,R.drawable.namibia_640,
            R.drawable.madagascar_640,R.drawable.belarus_640,R.drawable.bangladesh_640,R.drawable.algeria_640,
            R.drawable.angola_640,R.drawable.greece_640,R.drawable.kyrgyzstan_640,R.drawable.mali_640,
            R.drawable.nepal_640,R.drawable.korea_south_640,R.drawable.korea_north_640};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t = getResources().getStringArray(R.array.countries);
        //setContentView(R.layout.activity_country);
        ListView lv = (ListView)findViewById(R.id.listView2);
        CountriesAdapter mAdapter = new CountriesAdapter(this);
        setListAdapter(mAdapter);
    }

    private class CountriesAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        CountriesAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return t.length;
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
                convertView = mLayoutInflater.inflate(R.layout.my_template, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
            image.setImageResource(img[position]);

            TextView signTextView = (TextView) convertView.findViewById(R.id.textView);
            signTextView.setText(t[position]);

            return convertView;
        }

        String getString(int position) {
            return t[position];
        }
    }
}
