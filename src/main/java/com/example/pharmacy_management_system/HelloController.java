package com.example.pharmacy_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button loginBtn;


    @FXML
    protected void loginAdmin(ActionEvent event) {
        if (username.getText().equals("admin") && password.getText().equals("1234")) {
            System.out.println("Login Successful!");
            switchScene("Dashboard.fxml", "Dashboard");
        } else {
            showAlert("Login Failed", "Invalid Credentials!");
        }
    }

    private void switchScene(String fxmlFile, String title) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Dashboard.fxml Not Found");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}