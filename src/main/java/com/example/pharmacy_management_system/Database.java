package com.example.pharmacy_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {


    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy_db", "root", "");
            return connect;
        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}