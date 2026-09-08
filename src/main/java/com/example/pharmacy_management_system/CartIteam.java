package com.example.pharmacy_management_system;

class CartItem {
    private String name;
    private int qty;
    private double unitPrice;
    private double total;

    public CartItem(String name, int qty, double unitPrice, double total) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }
    public String getName() { return name; }
    public int getQty() { return qty; }
    public double getUnitPrice() { return unitPrice; }
    public double getTotal() { return total; }
}