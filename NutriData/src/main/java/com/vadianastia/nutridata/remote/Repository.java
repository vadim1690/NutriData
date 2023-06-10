package com.vadianastia.nutridata.remote;

import com.vadianastia.nutridata.entities.ProductData;

import java.util.List;

import retrofit2.Call;

public class Repository {
    private static Repository INSTANCE = null;

    private final JsonApiNutriData jsonApiNutriData;
    public static Repository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Repository();

        return INSTANCE;
    }
    private Repository( ) {
        this.jsonApiNutriData = ApiService.getInstance().getJsonNutriData();
    }

    public Call<List<ProductData>> getAllNutriData() {
        return jsonApiNutriData.getAllNutriData();
    }

    public Call<List<ProductData>> getAllNutriDataByName(String name) {
        return jsonApiNutriData.getAllNutriDataByName(name);
    }
    public Call<List<ProductData>> getAllNutriDataByFoodGroup(String name) {
        return jsonApiNutriData.getAllNutriDataByFoodGroup(name);
    }

    public Call<List<ProductData>> getAllNutriDataByVitamin(String name) {
        return jsonApiNutriData.getAllNutriDataByVitamin(name);
    }

    public Call<List<ProductData>> getAllNaturalNutriData() {
        return jsonApiNutriData.getAllNaturalNutriData();
    }

    public Call<List<ProductData>> getAllNotNaturalNutriData() {
        return jsonApiNutriData.getAllNotNaturalNutriData();
    }


}
