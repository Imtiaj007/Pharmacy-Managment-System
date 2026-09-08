package com.example.pharmacy_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    private void switchScene(ActionEvent event, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + fxmlFile + " Not Found ");
        }
    }

    @FXML
    void goToMedicine(ActionEvent event) {

        switchScene(event, "medicine-view.fxml", "Medicine Management");
    }

    @FXML
    void goToStaff(ActionEvent event) {

        switchScene(event, "staff-view.fxml", "Staff Management");
    }

    @FXML
    void goToAlerts(ActionEvent event) {
        switchScene(event, "alert-stock-view.fxml", "Low Stock Alerts");
    }

    @FXML
    void goToBilling(ActionEvent event) {
        switchScene(event, "billing.fxml", "Billing System");
    }

    @FXML
    void goToChangePassword(ActionEvent event) {
        switchScene(event, "change_password.fxml", "Change Password");
    }

    @FXML
    void handleLogout(ActionEvent event) {

        switchScene(event, "hello-view.fxml", "Pharmacy Management System - Login");
    }
}