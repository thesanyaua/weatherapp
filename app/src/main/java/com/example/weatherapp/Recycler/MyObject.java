package com.example.weatherapp.Recycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 11/28/20
 * Time: 7:45 PM
 */
public class MyObject {

    private String title = null;
    private String data1 = null;
    private String url = null;

    public String getTitle() {
        return title;
    }
    public String getData1() { return data1; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setData1(String data1) {this.data1 = data1;}




    public static List<MyObject> generateObjects(int size) {
        List<MyObject> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            MyObject item = new MyObject();

            item.title = "Title number " + i;
            item.data1 = "Title number " + i;


            items.add(item);

        }

        return items;
    }

}
