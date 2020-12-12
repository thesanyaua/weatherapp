package com.example.weatherapp.Recycler;

import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.Retrofit.BaseResponseObject;
import com.example.weatherapp.Retrofit.MyDate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/12/20
 * Time: 6:02 PM
 */
class TimeViewHolder extends RecyclerView.ViewHolder {

    private TextView timeViewHolder;

    public TimeViewHolder(@NonNull View itemView) {
        super(itemView);

        timeViewHolder = itemView.findViewById(R.id.textViewTime);
    }

    public void bind(BaseResponseObject item) {
        MyDate myDate = (MyDate) item;

        timeViewHolder.setText(String.valueOf(myDate.getDt()));
    }

}
