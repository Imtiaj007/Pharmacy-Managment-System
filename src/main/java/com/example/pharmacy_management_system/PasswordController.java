package com.example.pharmacy_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.*;

public class PasswordController {

    @FXML private PasswordField current_pass, new_pass;

    private final String URL = "jdbc:mysql://localhost:3306/pharmacy_db";
    private final String USER = "root";
    private final String PASS = "";

    @FXML
    void updatePassword() {
        String oldP = current_pass.getText();
        String newP = new_pass.getText();

        if (oldP.isEmpty() || newP.isEmpty()) {
            showAlert("Error", "Fields cannot be empty!", Alert.AlertType.ERROR);
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // ১. চেক করা হচ্ছে বর্তমান পাসওয়ার্ড সঠিক কি না
            PreparedStatement checkStm = conn.prepareStatement("SELECT * FROM users WHERE username = 'admin' AND password = ?");
            checkStm.setString(1, oldP);
            ResultSet rs = checkStm.executeQuery();

            if (rs.next()) {

                PreparedStatement updateStm = conn.prepareStatement("UPDATE users SET password = ? WHERE username = 'admin'");
                updateStm.setString(1, newP);
                updateStm.executeUpdate();
                showAlert("Success", "Password updated successfully!", Alert.AlertType.INFORMATION);
                clearFields();
            } else {
                showAlert("Error", "Current password is incorrect!", Alert.AlertType.ERROR);
            }
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
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void clearFields() {
        current_pass.clear();
        new_pass.clear();
    }

    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}