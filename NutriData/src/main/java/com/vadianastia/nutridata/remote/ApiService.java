package com.vadianastia.nutridata.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vadianastia.nutridata.common.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiService INSTANCE = null;
    private JsonApiNutriData jsonApiNutriData;
    private ApiService() {
        initializeRetrofit();
    }

    public static ApiService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ApiService();

        return INSTANCE;
    }

    private void initializeRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        jsonApiNutriData =new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(JsonApiNutriData.class);
    }

    public JsonApiNutriData getJsonNutriData() {
        return jsonApiNutriData;
    }
}
