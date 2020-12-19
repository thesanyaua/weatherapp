package com.example.weatherapp.Recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.Retrofit.BaseResponseObject;
import com.example.weatherapp.Retrofit.DayWeatherForecast;
import com.example.weatherapp.Retrofit.Main;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 11/28/20
 * Time: 7:39 PM
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BaseResponseObject> items = null;



    @NonNull
    // Создаем новые ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new MainDataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_data, parent, false));
        } else if (viewType == 1) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false));
        } else {
            return new TimeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time, parent, false));
        }
    }
    // Для присвоения значений новым ViewHolder
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (items.get(position) instanceof Main) {
            ((MainDataViewHolder) holder).onBind((Main) items.get(position));
        } else if (items.get(position) instanceof DayWeatherForecast) {
            ((MyViewHolder) holder).bind((DayWeatherForecast) items.get(position));
        } else {
            ((TimeViewHolder) holder).bind(items.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Main) {
            return 0;
        } else if (items.get(position) instanceof DayWeatherForecast) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    //Для возвращения общего количесва елементов в списке
    public int getItemCount() {
//        return items == null ? 0 : items.size();
        if (items == null) {
            return 0;
        } else {
            return items.size();
        }
    }

    public void setItems(List<BaseResponseObject> items) {
        this.items = items;
    }
}
