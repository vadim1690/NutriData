package com.vadianastia.nutridata.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductData {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("ingredients")
    private List<String> ingredients;
    @SerializedName("calories")
    private Double calories;
    @SerializedName("foodGroup")
    private FoodGroup foodGroup;
    @SerializedName("fat")
    private Double fat;
    @SerializedName("sodium")
    private Double sodium;
    @SerializedName("carbohydrates")
    private Double carbohydrates;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("isNatural")
    private Boolean isNatural;
    @SerializedName("fiber")
    private Double fiber;
    @SerializedName("sugar")
    private Double sugar;
    @SerializedName("protein")
    private Double protein;
    @SerializedName("potassium")
    private Double potassium;
    @SerializedName("vitamins")
    private List<Vitamin> vitamins;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getSodium() {
        return sodium;
    }

    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsNatural() {
        return isNatural;
    }

    public void setIsNatural(Boolean isNatural) {
        this.isNatural = isNatural;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getPotassium() {
        return potassium;
    }

    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    public List<Vitamin> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<Vitamin> vitamins) {
        this.vitamins = vitamins;
    }

}