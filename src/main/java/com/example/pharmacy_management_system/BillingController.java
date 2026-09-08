package com.example.pharmacy_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.*;

public class BillingController {

    @FXML private TextField customer_name, bill_qty, bill_price;
    @FXML private ComboBox<String> medicine_selector;
    @FXML private Label grand_total_label;
    @FXML private TableView<CartItem> cartTable;
    @FXML private TableColumn<CartItem, String> col_item;
    @FXML private TableColumn<CartItem, Integer> col_qty;
    @FXML private TableColumn<CartItem, Double> col_price, col_total;

    private ObservableList<CartItem> cartList = FXCollections.observableArrayList();
    private double grandTotal = 0.0;

    private final String URL = "jdbc:mysql://localhost:3306/pharmacy_db";
    private final String USER = "root";
    private final String PASS = "";

    @FXML
    public void initialize() {
        col_item.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        col_total.setCellValueFactory(new PropertyValueFactory<>("total"));

        loadMedicineNames();
    }

    private void loadMedicineNames() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT name FROM medicines WHERE stock > 0");
            while (rs.next()) { medicine_selector.getItems().add(rs.getString("name")); }
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void updatePrice() {
        String selectedMed = medicine_selector.getSelectionModel().getSelectedItem();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement pst = conn.prepareStatement("SELECT price FROM medicines WHERE name = ?");
            pst.setString(1, selectedMed);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) { bill_price.setText(String.valueOf(rs.getDouble("price"))); }
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void addToCart() {
        try {
            String name = medicine_selector.getValue();
            int qty = Integer.parseInt(bill_qty.getText());
            double price = Double.parseDouble(bill_price.getText());
            double total = qty * price;

            cartList.add(new CartItem(name, qty, price, total));
            cartTable.setItems(cartList);

            grandTotal += total;
            grand_total_label.setText(grandTotal + " Tk");
        } catch (Exception e) {
            showAlert("Error", "Please select medicine and enter quantity.");
        }
    }

    @FXML
    void confirmBill() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            conn.setAutoCommit(false);

            PreparedStatement pstSale = conn.prepareStatement("INSERT INTO sales (customer_name, total_amount) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstSale.setString(1, customer_name.getText().isEmpty() ? "Guest" : customer_name.getText());
            pstSale.setDouble(2, grandTotal);
            pstSale.executeUpdate();

            for (CartItem item : cartList) {
                PreparedStatement pstUpdate = conn.prepareStatement("UPDATE medicines SET stock = stock - ? WHERE name = ?");
                pstUpdate.setInt(1, item.getQty());
                pstUpdate.setString(2, item.getName());
                pstUpdate.executeUpdate();
            }

            conn.commit();
            showAlert("Success", "Bill Confirmed! Stock Updated.");
            cartList.clear();
            grandTotal = 0;
            grand_total_label.setText("0.00 Tk");
        } catch (Exception e) {
            showAlert("Error", "Transaction failed!");
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

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}