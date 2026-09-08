package com.example.pharmacy_management_system;

public class Staff {
    private String name, position, phone;
    private Double salary;

    public Staff(String name, String position, String phone, Double salary) {
        this.name = name; this.position = position; this.phone = phone; this.salary = salary;
    }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public String getPhone() { return phone; }
    public Double getSalary() { return salary; }
}