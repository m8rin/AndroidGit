package com.example.test5lab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndroidMergeSurfaceView extends Activity {
    int parity = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowHide = (Button) findViewById(R.id.showhide);

        buttonShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parity++;
                if (parity % 2 == 0) {
                    buttonShowHide.setText("STOP");
                    MySurfaceView.check = true;
                } else {
                    buttonShowHide.setText("START");
                    MySurfaceView.check = false;
                }
            }
        });
    }
}
