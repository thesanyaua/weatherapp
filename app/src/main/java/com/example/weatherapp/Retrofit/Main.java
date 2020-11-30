package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {


    @SerializedName("temp")
    String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    }

