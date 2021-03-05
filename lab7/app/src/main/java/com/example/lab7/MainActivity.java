package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.BaseColumns;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public final class SampleDBContract {
        private SampleDBContract() {
        }

        public static class Employer implements BaseColumns {
            public static final String TABLE_NAME = "employer";
            public static final String COLUMN_NAME = "name";
            public static final String COLUMN_DESCRIPTION = "description";
            public static final String COLUMN_FOUNDED_DATE = "date";
            public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_FOUNDED_DATE + " INTEGER" + ")";
        }
    }
}