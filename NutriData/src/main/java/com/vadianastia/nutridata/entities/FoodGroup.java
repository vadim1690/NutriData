package com.vadianastia.nutridata.entities;

public class FoodGroup {
    private String name;
    private String description;

    public FoodGroup() {
    }

    public FoodGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public FoodGroup setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FoodGroup setDescription(String description) {
        this.description = description;
        return this;
    }
}
