package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton btn1 = (RadioButton) findViewById(R.id.buttonYes);
        final RadioButton btn2 = (RadioButton) findViewById(R.id.buttonNo);
        final Button b = (Button) findViewById(R.id.button);
        final TextView text = (TextView) findViewById(R.id.textView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.isChecked()) text.setText("да");
                if (btn2.isChecked()) text.setText("нет");
            }
        });
    }
}