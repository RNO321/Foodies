package com.example.foodies;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FeatureAdapter extends FragmentPagerAdapter {
    Restaurant[] three_restos;


    public FeatureAdapter(@NonNull FragmentManager fm, Restaurant[] three_restos) {
        super(fm);
        this.three_restos = three_restos;
    }

    @Override
    public int getCount() {

        return three_restos.length;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return new FeatureFragment(three_restos[position % three_restos.length]);

    }

}
    
 


