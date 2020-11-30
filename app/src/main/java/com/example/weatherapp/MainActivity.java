package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.ApiInterface;
import com.example.weatherapp.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button search1;
    TextView tempText;
    EditText  city ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search1 = findViewById(R.id.search1);
        tempText = findViewById(R.id.tempText);
        city = findViewById(R.id.city);


        search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                getWeatherData(city.getText().toString());

            }
        });
    }

    private void getWeatherData(String name){

       ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                tempText.setText(response.body().getMain().getTemp()+" C");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}
