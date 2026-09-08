package com.example.pharmacy_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class AlertStockController {

    @FXML private TableView<Medicine> alertTable;
    @FXML private TableColumn<Medicine, String> col_name;
    @FXML private TableColumn<Medicine, String> col_cat;
    @FXML private TableColumn<Medicine, Integer> col_stock;

    private ObservableList<Medicine> lowStockList = FXCollections.observableArrayList();


    private final String URL = "jdbc:mysql://localhost:3306/pharmacy_db";
    private final String USER = "root";
    private final String PASS = "";

    @FXML
    public void initialize() {

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_cat.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        loadLowStockFromDB();
    }

    private void loadLowStockFromDB() {
        lowStockList.clear();
        String query = "SELECT * FROM medicines WHERE stock < 10";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                lowStockList.add(new Medicine(
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("stock"),
                        rs.getDouble("price")
                ));
            }
            alertTable.setItems(lowStockList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backToDashboard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}