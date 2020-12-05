package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.Recycler.MyAdapter;
import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.ApiInterface;
import com.example.weatherapp.Retrofit.DayWeatherForecast;
import com.example.weatherapp.Retrofit.Example;
import com.example.weatherapp.sss.Utils;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Double  output;
    Button search1;
    TextView tempText, tmin, tmax;
    EditText  city ;

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        //запуск RecyclerView для прогноза
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        search1 = findViewById(R.id.search1);
        tempText = findViewById(R.id.tempText);
        tmin = findViewById(R.id.tmin);
        tmax = findViewById(R.id.tmax);
        city = findViewById(R.id.city);

        getWeatherData(city.getText().toString());
        getForecastData(city.getText().toString());

        search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherData(city.getText().toString());
                getForecastData(city.getText().toString());
            }
        });
    }

    private void getForecastData(String name) {

       ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getForecastData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                setData(response.body().getDayWeatherForecast());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, call.toString(), Toast.LENGTH_LONG).show();
                Utils.log(call.toString());
            }
        });

    }

    private void getWeatherData(String name) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                tempText.setText((response.body().getMain().getTemp()) + " C˚");
                tmin.setText("Минимум " + response.body().getMain().getTemp_min() + " C˚");
                tmax.setText("Максимум " + response.body().getMain().getTemp_max() + " C˚");
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, call.toString(), Toast.LENGTH_LONG).show();
                Utils.log(call.toString());
            }
        });

    }

    private void setData(List<DayWeatherForecast> data) {
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setItems(data);
        mRecyclerView.setAdapter(myAdapter);
    }
}
