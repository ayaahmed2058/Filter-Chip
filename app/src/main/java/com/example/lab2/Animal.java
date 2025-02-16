package com.example.lab2;

public class Animal {
    private String name;
    private String description;
    private String type;

    public Animal(String name, String description, String brand) {
        this.name = name;
        this.description = description;
        this.type = brand;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}

