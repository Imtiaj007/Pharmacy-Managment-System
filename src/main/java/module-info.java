module com.example.pharmacy_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.pharmacy_management_system to javafx.fxml,javafx.base;
    exports com.example.pharmacy_management_system;
}



