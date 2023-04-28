package com.vadianastia.nutridata.remote;

import com.vadianastia.nutridata.entities.NutriDataList;
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

    public Call<NutriDataList> getAllNutriData() {
        return jsonApiNutriData.getAllNutriData();
    }

}
