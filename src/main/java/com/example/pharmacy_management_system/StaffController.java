package com.example.pharmacy_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

public class StaffController {
    @FXML private TextField staff_name, staff_pos, staff_phone, staff_salary, staff_search;
    @FXML private TableView<Staff> staffTable;
    @FXML private TableColumn<Staff, String> col_name, col_pos, col_phone;
    @FXML private TableColumn<Staff, Double> col_salary;

    public void initialize() {
        showStaff();
    }

    public void showStaff() {
        ObservableList<Staff> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM staff";
        try (Connection connect = Database.connectDb();
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                list.add(new Staff(result.getString("name"), result.getString("position"), result.getString("phone"), result.getDouble("salary")));
            }
        } catch (Exception e) { e.printStackTrace(); }

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_pos.setCellValueFactory(new PropertyValueFactory<>("position"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        staffTable.setItems(list);
    }

    public void addStaff() {
        if (staff_name.getText().isEmpty() || staff_pos.getText().isEmpty() || staff_phone.getText().isEmpty() || staff_salary.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all fields!");
            return;
        }

        String sql = "INSERT INTO staff (name, position, phone, salary) VALUES (?,?,?,?)";
        try (Connection connect = Database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql)) {
            prepare.setString(1, staff_name.getText());
            prepare.setString(2, staff_pos.getText());
            prepare.setString(3, staff_phone.getText());
            prepare.setString(4, staff_salary.getText());
            prepare.executeUpdate();

            showAlert(Alert.AlertType.INFORMATION, "Success", "Staff Added Successfully!");
            showStaff();
            clearFields();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void searchStaff() {
        ObservableList<Staff> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM staff WHERE name LIKE ? OR position LIKE ?";
        try (Connection connect = Database.connectDb();
             PreparedStatement prepare = connect.prepareStatement(sql)) {
            prepare.setString(1, "%" + staff_search.getText() + "%");
            prepare.setString(2, "%" + staff_search.getText() + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list.add(new Staff(result.getString("name"), result.getString("position"), result.getString("phone"), result.getDouble("salary")));
            }
            staffTable.setItems(list);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void clearFields() {
        staff_name.clear();staff_pos.clear(); staff_phone.clear(); staff_salary.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}