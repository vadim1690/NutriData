package com.vadianastia.nutridata.entities;

public class Vitamin {

    private String name;
    private String benefits;
    private String description;

    public Vitamin() {
    }

    public Vitamin(String name, String benefits, String description) {
        this.name = name;
        this.benefits = benefits;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Vitamin setName(String name) {
        this.name = name;
        return this;
    }

    public String getBenefits() {
        return benefits;
    }

    public Vitamin setBenefits(String benefits) {
        this.benefits = benefits;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vitamin setDescription(String description) {
        this.description = description;
        return this;
    }
}
