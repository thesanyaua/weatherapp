package com.example.weatherapp.Retrofit;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/12/20
 * Time: 6:09 PM
 */
public class MyDate implements BaseResponseObject {

    private long dt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
}
