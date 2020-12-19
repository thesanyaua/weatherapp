package com.example.weatherapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherapp.Recycler.MainDataViewHolder;
import com.example.weatherapp.Recycler.MyAdapter;
import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.ApiInterface;
import com.example.weatherapp.Retrofit.BaseResponseObject;
import com.example.weatherapp.Retrofit.DayWeatherForecast;
import com.example.weatherapp.Retrofit.Example;
import com.example.weatherapp.Retrofit.Main;
import com.example.weatherapp.Retrofit.MyDate;
import com.example.weatherapp.sss.Utils;

import java.util.ArrayList;
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
   //EditText city;


    private RecyclerView mRecyclerView;

    private Main mMain;

    private String city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        search1 = findViewById(R.id.search1);
      //  city = findViewById(R.id.city);

        //запуск RecyclerView для прогноза
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        EditText tet = findViewById(R.id.city);
        tet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                    city = s.toString();
            }
        });


       search1.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {

                if(city != null) {
                    getWeatherData(city);
                }
            }
        });
   }

    private void getForecastData(String name) {

       ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getForecastData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                List<BaseResponseObject> list = new ArrayList<>();
                list.add(mMain);

                List<DayWeatherForecast> timeArray = response.body().getDayWeatherForecast();
                for (int i = 0; i < timeArray.size(); i++) {

                    MyDate myDate = new MyDate();
                    myDate.setDt(timeArray.get(i).getDt());
                    list.add(myDate);

                    list.add(timeArray.get(i));
                }

                setData(list);
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
                mMain = response.body().getMain();
                if (city != null) {
                    getForecastData(city);
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, call.toString(), Toast.LENGTH_LONG).show();
                Utils.log(call.toString());
            }
        });

    }

    private void setData(List<BaseResponseObject> data) {
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setItems(data);
        mRecyclerView.setAdapter(myAdapter);
    }
}
