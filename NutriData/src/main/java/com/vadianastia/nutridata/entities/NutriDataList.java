package com.vadianastia.nutridata.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NutriDataList {
    @SerializedName("NutriDataList")
    private List<ProductData> nutriDataList;

    public NutriDataList() {
    }

    public List<ProductData> getNutriDataList() {
        return nutriDataList;
    }

    public void setNutriDataList(List<ProductData> nutriDataList) {
        this.nutriDataList = nutriDataList;
    }
}
