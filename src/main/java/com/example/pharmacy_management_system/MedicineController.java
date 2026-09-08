package com.example.pharmacy_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MedicineController implements Initializable {

    @FXML private TextField med_name;
    @FXML private TextField med_cat;
    @FXML private TextField med_stock;
    @FXML private TextField med_price;
    @FXML private TextField med_search;

    @FXML private TableView<Medicine> medicineTable;
    @FXML private TableColumn<Medicine, String> col_name;
    @FXML private TableColumn<Medicine, String> col_cat;
    @FXML private TableColumn<Medicine, Integer> col_stock;
    @FXML private TableColumn<Medicine, Double> col_price;

    private ObservableList<Medicine> medicineList;


    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_cat.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));


        showMedicineData();
    }


    public ObservableList<Medicine> getMedicineListData() {
        ObservableList<Medicine> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM medicines";

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Medicine med;
            while (result.next()) {

                med = new Medicine(
                        result.getString("name"),
                        result.getString("category"),
                        result.getInt("stock"),
                        result.getDouble("price")
                );
                listData.add(med);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }


    public void showMedicineData() {
        medicineList = getMedicineListData();
        medicineTable.setItems(medicineList);
    }


    @FXML
    void addMedicine(ActionEvent event) {
        String sql = "INSERT INTO medicines (name, category, stock, price) VALUES(?,?,?,?)";
        connect = Database.connectDb();

        try {
            if (med_name.getText().isEmpty() || med_cat.getText().isEmpty()
                    || med_stock.getText().isEmpty() || med_price.getText().isEmpty()) {

                showAlert("Error", "Please fill all fields!");
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, med_name.getText());
                prepare.setString(2, med_cat.getText());
                prepare.setString(3, med_stock.getText());
                prepare.setString(4, med_price.getText());

                prepare.executeUpdate();

                showAlert("Success", "Medicine Added Successfully!");


                showMedicineData();
                clearFields(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clearFields(ActionEvent event) {
        med_name.clear();
        med_cat.clear();
        med_stock.clear();
        med_price.clear();
    }

    @FXML
    void searchMedicine(KeyEvent event) {

    }

    @FXML
    void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}