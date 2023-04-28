package com.vadianastia.nutridata.remote;

import com.vadianastia.nutridata.entities.NutriDataList;
import com.vadianastia.nutridata.entities.ProductData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApiNutriData {
    @GET("JDLaTjeJ")
    Call<NutriDataList>  getAllNutriData();
}
