package com.example.foodies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FeatureFragment extends Fragment {
    Restaurant restaurant;

    public FeatureFragment(Restaurant restaurant) {

        this.restaurant = restaurant;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.viewpage_restaurant_item, container, false);

        //connect elements
        ImageView rest_img = v.findViewById(R.id.img_featured);
        TextView rest_name = v.findViewById(R.id.restaurant_name);
        TextView rest_address = v.findViewById(R.id.restaurant_address);
        //set attributes
        rest_img.setImageResource(restaurant.getBannerImage());
        rest_name.setText(restaurant.getName());
        rest_address.setText(restaurant.getAddress1());

        return v;
    }

}
