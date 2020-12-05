package com.example.weatherapp.Recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.Retrofit.DayWeatherForecast;

import java.util.List;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 11/28/20
 * Time: 7:39 PM
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<DayWeatherForecast> items = null;

    @NonNull
    // Создаем новые ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false));
    }
    // Для присвоения значений новым ViewHolder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(items.get(position));
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

    public void setItems(List<DayWeatherForecast> items) {
        this.items = items;
    }
}
