package com.vadianastia.nutridata.remote;

import com.vadianastia.nutridata.entities.ProductData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonApiNutriData {
    @GET("products")
    Call<List<ProductData>>  getAllNutriData();

    @GET("products/{name}")
    Call<List<ProductData>>  getAllNutriDataByName(@Path("name") String name);
    @GET("products/ProductsByFoodGroup/{name}")
    Call<List<ProductData>>  getAllNutriDataByFoodGroup(@Path("name") String name);

    @GET("products/ProductsByVitamin/{name}")
    Call<List<ProductData>>  getAllNutriDataByVitamin(@Path("name") String name);

    @GET("products/isNatural")
    Call<List<ProductData>>  getAllNaturalNutriData();

    @GET("products/notNatural")
    Call<List<ProductData>>  getAllNotNaturalNutriData();
}
