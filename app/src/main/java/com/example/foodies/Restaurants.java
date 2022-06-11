package com.example.foodies;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

//static helper class with sorting and filtering methods

public class Restaurants {


    //    bubble sort restaurants based on min price
    public static void sortRestaurantsMinPriceLowToHigh(ArrayList<Restaurant> restaurants) {

        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size() - 1 - i; j++) {
                if (restaurants.get(j).getMinPrice() > restaurants.get(j + 1).getMinPrice()) {
                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
    }

    //    sort restaurants based on min price high to low
    public static void sortRestaurantsMinPriceHighToLow(ArrayList<Restaurant> restaurants) {

        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size() - 1 - i; j++) {
                if (restaurants.get(j).getMinPrice() < restaurants.get(j + 1).getMinPrice()) {

                    Collections.swap(restaurants, j, j + 1);

                }
            }
        }
    }

    //    sort restaurants based on rating
    public static void sortRestaurantsByRating(ArrayList<Restaurant> restaurants) {

        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size() - 1 - i; j++) {
                if (restaurants.get(j).getRating() < restaurants.get(j + 1).getRating()) {
                    Collections.swap(restaurants, j, j + 1);

                }
            }
        }
    }

    // pick vegan restaurants and remove all else
    public static void sortRestaurantByVegan(ArrayList<Restaurant> restaurants) {

        restaurants.removeIf(resto -> !resto.isVegetarian());

    }

    //pick three featured restos randomly from restaurant list
    @NonNull
    public static Restaurant[] getThreeFeaturedRestos(ArrayList<Restaurant> restaurants) {

        ArrayList<Restaurant> featured_restos = new ArrayList<>();
        //sort through restaurantList and add items that are featured to featured list

        for (Restaurant resto :
                restaurants) {
            if (resto.isFeatured()) {
                featured_restos.add(resto);
            }
        }


        //randomly pick 3 restaurants from featured list
        Restaurant three_restos[] = new Restaurant[3];

        Collections.shuffle(featured_restos);
        featured_restos.subList(0, 3).toArray(three_restos);

        return three_restos;
    }

}
