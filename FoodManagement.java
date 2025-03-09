package com.example.theparadise.models;

public class FoodManagement {
    private String id;
    private String name;
    private String price;
    private String address;
    private String image;

    // Constructor
    public FoodManagement(String id, String name, String price, String address, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
        this.image = image;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getAddress() { return address; }
    public String getImage() { return image; }
}