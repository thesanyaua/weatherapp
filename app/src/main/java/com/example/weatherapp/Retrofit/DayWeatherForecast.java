package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/5/20
 * Time: 9:05 PM
 */
class DayWeatherForecast {

    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}