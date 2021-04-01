package com.example.lab8;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    public String URL = "http://192.168.1.39:8080/";
    EditText name;
    Button get;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        name = findViewById(R.id.name);
        get = findViewById(R.id.get);
        textView = findViewById(R.id.tw);

        //кнопка для отправки запроса
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetAsyncTask().execute();
            }
        });
    }


    class GetAsyncTask extends AsyncTask {
        User user;
        String userName = name.getText().toString();

        @Override
        protected Object doInBackground(Object[] objects) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UserService service = retrofit.create(UserService.class);
            Call<User> call = service.fetchUser(userName);
            try {
                Response<User> userResponse = call.execute();
                user = userResponse.body();
                Log.d("SEND_AND_RETURN", "get: " + user);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            String str = "";
            if (user == null) return;
            str += user;
            textView.setText(str);
        }
    }
}
