package com.example.weatherapp.Recycler;

import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.Retrofit.DayWeatherForecast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 11/28/20
 * Time: 7:39 PM
 */
class MyViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
   // private final TextView summary;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.titleTextView);

    }

    public void bind(DayWeatherForecast item) {
        title.setText(String.valueOf(item.getTemp()));
    }
}
