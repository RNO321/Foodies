package com.example.foodies;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get restaurants array from database

        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) DataSource.getRestaurantList().clone();

        //set up viewpager and list fragment
        setUpViewPager(restaurants);
        setUpListFragment(restaurants);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) DataSource.getRestaurantList().clone();

        int id = item.getItemId();

        switch (id) {
            case R.id.price_low_high:
                //sort restaurants based on min price low to high
                Restaurants.sortRestaurantsMinPriceLowToHigh(restaurants);
                break;

            case R.id.price_high_low:
                //sort restaurants based on min price high to low
                Restaurants.sortRestaurantsMinPriceHighToLow(restaurants);
                break;

            case R.id.rating_menu_item:
                //sort restaurants based on rating
                Restaurants.sortRestaurantsByRating(restaurants);
                break;
            case R.id.vegan_menu_item:

                //sort restaurants based on vegan status
                Restaurants.sortRestaurantByVegan(restaurants);
                break;
        }
        setUpListFragment(restaurants);
        return super.onOptionsItemSelected(item);

    }

    private void setUpListFragment(ArrayList<Restaurant> restaurants) {


        ListFragment listFragment = new ListFragment(restaurants);
        getSupportFragmentManager().beginTransaction().replace(R.id.list_view_frame, listFragment).commit();
    }

    //setup viewpager
    private void setUpViewPager(ArrayList<Restaurant> restaurants) {
        Restaurant[] three_restos;

        //get three random featured restaurants
        three_restos = Restaurants.getThreeFeaturedRestos(restaurants);

        //pass list of three restos to feature adapter

        FeatureAdapter adapter = new FeatureAdapter(getSupportFragmentManager(), three_restos);

        //set up viewpager

        ViewPager viewPager = findViewById(R.id.feature_viewpager);
        viewPager.setAdapter(adapter);


    }


}


