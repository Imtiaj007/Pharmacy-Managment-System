package com.example.pharmacy_management_system;

public class Medicine {
    private String name;
    private String category;
    private int stock;
    private double price;

    public Medicine(String name, String category, int stock, double price) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getStock() { return stock; }
    public double getPrice() { return price; }
}