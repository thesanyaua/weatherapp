package com.example.weatherapp.Recycler;

import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.Retrofit.BaseResponseObject;
import com.example.weatherapp.Retrofit.MyDate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        String transformedDate = new SimpleDateFormat("HH:mm  dd MMM yyyy").format(new Date(myDate.getDt()));
        timeViewHolder.setText(transformedDate);

    }

}
