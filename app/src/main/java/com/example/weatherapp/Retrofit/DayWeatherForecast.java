package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/5/20
 * Time: 9:05 PM
 */
public class DayWeatherForecast implements BaseResponseObject {

    @SerializedName("main")
    private Main main;

    @SerializedName("dt")
    private long dt;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

}
