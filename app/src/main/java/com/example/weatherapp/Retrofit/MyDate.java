package com.example.weatherapp.Retrofit;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/12/20
 * Time: 6:09 PM
 */
public class MyDate implements BaseResponseObject {

    private double dt;

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }
}
