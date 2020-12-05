package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("list")
    private List<DayWeatherForecast> list;

    @SerializedName("main")
    private Main main;

    public List<DayWeatherForecast> getDayWeatherForecast() {
        return list;
    }

    public void setDayWeatherForecast(List<DayWeatherForecast> dayWeatherForecast) {
        list = dayWeatherForecast;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
