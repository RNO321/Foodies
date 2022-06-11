package com.example.foodies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    ArrayList<Restaurant> restaurants;
    Context context;

    public ListAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @Override
    public int getCount() {

        return restaurants.size();
    }

    @Override
    public Restaurant getItem(int position) {

        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Restaurant restaurant = restaurants.get(position);
        View v = View.inflate(context, R.layout.list_restaurant_item, null);

        //connect views

        ImageView img = v.findViewById(R.id.restaurant_img);
        TextView rest_name_address = v.findViewById(R.id.rest_name_address);
        TextView rating = v.findViewById(R.id.rating);
        TextView vegan = v.findViewById(R.id.vegan);
        TextView rest_price_time = v.findViewById(R.id.rest_price_time);

        //Set attributes

        img.setImageResource(restaurant.getBannerImage());
        rest_name_address.setText(restaurant.getName() + ", " + restaurant.getAddress1() + ", " + restaurant.getCity());
        rating.setText(restaurant.getRating().toString());
        rest_price_time.setText("$" + restaurant.getMinPrice() + " Minimum Price - " + restaurant.getDeliveryTime() + " min");
        if (restaurant.isVegetarian()) {
            vegan.setText("■");
        }

        return v;
    }

}
