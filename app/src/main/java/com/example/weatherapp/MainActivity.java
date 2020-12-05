package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weatherapp.Recycler.MyAdapter;
import com.example.weatherapp.Recycler.MyObject;
import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.ApiInterface;
import com.example.weatherapp.Retrofit.Example;

import java.text.DecimalFormat;

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
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setItems(MyObject.generateObjects(5));
        mRecyclerView.setAdapter(myAdapter);



        search1 = findViewById(R.id.search1);
        tempText = findViewById(R.id.tempText);
        tmin = findViewById(R.id.tmin);
        tmax = findViewById(R.id.tmax);
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

               tempText.setText((response.body().getMain().getTemp())+" C˚");
                tmin.setText("Минимум "+ response.body().getMain().getTemp_min()+ " C˚");
                tmax.setText("Максимум " + response.body().getMain().getTemp_max()+ " C˚");


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}
