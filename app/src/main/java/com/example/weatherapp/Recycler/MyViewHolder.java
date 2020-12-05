package com.example.weatherapp.Recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

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

    public void bind(MyObject item) {
        title.setText(item.getTitle());


    }
}
