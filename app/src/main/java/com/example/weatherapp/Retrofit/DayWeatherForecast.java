package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/5/20
 * Time: 9:05 PM
 */
public class DayWeatherForecast implements BaseResponseObject {

    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
