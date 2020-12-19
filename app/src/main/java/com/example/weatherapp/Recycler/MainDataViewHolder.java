package com.example.weatherapp.Recycler;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.Retrofit.Main;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/5/20
 * Time: 9:50 PM
 */
public class MainDataViewHolder extends RecyclerView.ViewHolder {



    private TextView tempText, tmin, tmax;
    private EditText city ;

    public  MainDataViewHolder(@NonNull View itemView) {
        super(itemView);

        tempText = itemView.findViewById(R.id.tempText);
        tmin = itemView.findViewById(R.id.tmin);
        tmax = itemView.findViewById(R.id.tmax);
        city = itemView.findViewById(R.id.city);


    }

    public void onBind(Main item) {
        tempText.setText((item.getTemp()) + " C˚");
        tmin.setText("Минимум " + item.getTemp_min() + " C˚");
        tmax.setText("Максимум " + item.getTemp_max() + " C˚");
    }

}
