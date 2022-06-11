package com.example.foodies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListFragment extends androidx.fragment.app.ListFragment {
    ArrayList<Restaurant> restaurants;

    public ListFragment(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View v = inflater.inflate(R.layout.list_fragment, container, false);


        //set adapter
        ListAdapter adapter = new ListAdapter(getContext(), restaurants);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
