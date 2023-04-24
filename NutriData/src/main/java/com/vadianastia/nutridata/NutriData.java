package com.vadianastia.nutridata;

import android.content.Context;

import com.vadianastia.nutridata.entities.FoodGroup;
import com.vadianastia.nutridata.entities.ProductData;
import com.vadianastia.nutridata.entities.Vitamin;

import java.util.List;

public class NutriData {

    private static NutriData instance;

    // TODO: Retrofit instance
    // URL-> /getNutriData/{productName}


    public static NutriData getInstance() {
        return instance;
    }

    private NutriData(Context context) {
        // TODO: implement - check if we can not save the context and just initialize retrofit here
    }


    public static NutriData initHelper(Context context) {
        if (instance == null) instance = new NutriData(context);
        return instance;
    }

    public List<ProductData> getNutriData(String productName) {
        return null;
    }

    public List<ProductData> getAllNutriData() {
        return null;
    }

    public List<ProductData> getNutriDataByFoodGroup(String foodGroup) {
        return null;
    }

    public List<ProductData> getNutriDataByVitamin(List<String> vitamins) {
        return null;
    }

    public List<ProductData> getByIsNatural(boolean isNatural) {
        return null;
    }

    public List<Vitamin> getAllVitamins() {
        return null;
    }

    public List<FoodGroup> getAllFoodGroups() {
        return null;
    }

    public double getCalories(String productName) {
        return 0;
    }

    public double getSugars(String productName) {
        return 0;
    }

}
