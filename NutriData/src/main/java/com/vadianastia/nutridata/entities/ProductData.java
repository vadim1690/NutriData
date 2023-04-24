package com.vadianastia.nutridata.entities;

import java.util.List;

public class ProductData {
    private String name;
    private String description;
    private double calories;
    private FoodGroup foodGroup;
    private double fat;
    private double sodium;
    private double carbohydrates;
    private String imageUrl;
    private boolean isNatural;
    private double fiber;
    private double sugar;
    private double protein;
    private double potassium;
    private List<Vitamin> vitamins;
    private List<String> ingredients;

    public ProductData() {
    }

    public ProductData(String name, String description, double calories, FoodGroup foodGroup, double fat, double sodium, double carbohydrates, String imageUrl, boolean isNatural, double fiber, double sugar, double protein, double potassium, List<Vitamin> vitamins, List<String> ingredients) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.foodGroup = foodGroup;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrates = carbohydrates;
        this.imageUrl = imageUrl;
        this.isNatural = isNatural;
        this.fiber = fiber;
        this.sugar = sugar;
        this.protein = protein;
        this.potassium = potassium;
        this.vitamins = vitamins;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public ProductData setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductData setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getCalories() {
        return calories;
    }

    public ProductData setCalories(double calories) {
        this.calories = calories;
        return this;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public ProductData setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
        return this;
    }

    public double getFat() {
        return fat;
    }

    public ProductData setFat(double fat) {
        this.fat = fat;
        return this;
    }

    public double getSodium() {
        return sodium;
    }

    public ProductData setSodium(double sodium) {
        this.sodium = sodium;
        return this;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public ProductData setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductData setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public boolean isNatural() {
        return isNatural;
    }

    public ProductData setNatural(boolean natural) {
        isNatural = natural;
        return this;
    }

    public double getFiber() {
        return fiber;
    }

    public ProductData setFiber(double fiber) {
        this.fiber = fiber;
        return this;
    }

    public double getSugar() {
        return sugar;
    }

    public ProductData setSugar(double sugar) {
        this.sugar = sugar;
        return this;
    }

    public double getProtein() {
        return protein;
    }

    public ProductData setProtein(double protein) {
        this.protein = protein;
        return this;
    }

    public double getPotassium() {
        return potassium;
    }

    public ProductData setPotassium(double potassium) {
        this.potassium = potassium;
        return this;
    }

    public List<Vitamin> getVitamins() {
        return vitamins;
    }

    public ProductData setVitamins(List<Vitamin> vitamins) {
        this.vitamins = vitamins;
        return this;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public ProductData setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
