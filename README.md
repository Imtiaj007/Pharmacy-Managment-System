# 💊 Pharmacy Management System (JavaFX & MySQL)

A modern, desktop-based **Pharmacy Management System** developed with **JavaFX** and **MySQL**. This application helps pharmacists and store managers streamline inventory management, handle sales transactions, keep track of medicine batches, manage prescriptions, and monitor sales analytics effectively.

---

## 🖼️ Application Screenshots

<p align="center">
  <img src="screenshots/Screenshot 2026-09-09 001331.png" width="45%" alt="Dashboard Overview" />
  <img src="screenshots/Screenshot 2026-09-09 001339.png" width="45%" alt="Inventory Management" />
</p>

<p align="center">
  <img src="screenshots/Screenshot 2026-09-09 001433.png" width="45%" alt="POS & Billing" />
  <img src="screenshots/Screenshot 2026-09-09 001445.png" width="45%" alt="Stock Alert System" />
</p>

<p align="center">
  <img src="screenshots/Screenshot 2026-09-09 001501.png" width="45%" alt="Prescription Records" />
  <img src="screenshots/Screenshot 2026-09-09 001510.png" width="45%" alt="Staff & Payroll" />
</p>

---

## ✨ Features

- 📦 **Inventory & Stock Management**: Add, update, and manage medicines, categories, and batch details.
- 💰 **Billing & Point of Sale (POS)**: Smooth checkout interface for instant billing, itemized subtotaling, and real-time stock deduction.
- ⚠️ **Stock & Expiry Alerts**: Real-time alerts for low stock and near-expiry medicines.
- 📋 **Prescription & Customer Records**: Maintain detailed records of customers and associated prescriptions/doctors.
- 👥 **Employee & Staff Roles**: Managerial oversight for staff performance, role assignment, and payroll details.
- 📊 **Dashboard & Analytics**: Overview of sales performance, key metrics, and inventory health.

---

## 🛠️ Tech Stack & Prerequisites

- **Language:** Java (JDK 17 or higher)
- **GUI Framework:** JavaFX
- **Build Tool:** Maven
- **Database:** MySQL (via XAMPP / MariaDB / MySQL Server)
- **Database Connector:** MySQL Connector/J (`mysql-connector-j`)

---

## 📁 Repository Structure

```text
Pharmacy_Management_System/
├── screenshots/                                          # Project Screenshots
├── src/
│   └── main/
│       ├── java/com/example/pharmacy_management_system/  # Controller & Logic Classes
│       └── resources/                                    # FXML Views & Assets
├── pharmacydb.sql                                        # Complete MySQL Database Dump
├── pom.xml                                               # Maven Dependencies & Plugins
├── .gitignore                                            # Git Ignore Configuration
└── README.md                                             # Project Documentation







## 🚀 Getting Started & Local Setup Guide

Follow these steps to get the project running on your local machine:

### 1. Prerequisites
Ensure you have the following installed on your system:
- **Java Development Kit (JDK 17 or higher)**
- **IntelliJ IDEA** (Community or Ultimate Edition)
- **XAMPP Control Panel** (for Apache & MySQL Services)
- **Git**

---

### 2. Database Setup
1. Open **XAMPP Control Panel** and click **Start** for both **Apache** and **MySQL**.
2. Open **phpMyAdmin** in your browser by navigating to `http://localhost/phpmyadmin`.
3. Create a new database named `pharmacydb`:
   ```sql
   CREATE DATABASE pharmacydb;
Click on the newly created pharmacydb database from the left sidebar.

Go to the Import tab at the top menu.

Click Choose File, select the pharmacydb.sql file located in the root directory of this repository, and click Go at the bottom to import all tables and sample data.

3. Open & Configure Project in IntelliJ IDEA
Open IntelliJ IDEA -> Click Open -> Select the Pharmacy_Management_System folder.

Allow IntelliJ IDEA to automatically import all Maven dependencies defined in pom.xml.

Locate and open your database connection class (e.g., Database.java) under:
src/main/java/com/example/pharmacy_management_system/

Ensure your local MySQL credentials match:

Java
String url = "jdbc:mysql://localhost:3306/pharmacydb";
String user = "root";       // Default XAMPP username
String password = "";       // Default XAMPP password (leave empty)
4. Build & Run
Navigate to src/main/java/com/example/pharmacy_management_system/ in the Project Explorer.

Locate Launcher.java or HelloApplication.java.

Right-click the file and select Run 'Launcher.main()'.




👤 Author
Developed by MD EMTIUJ AHMED EIPTY

🌐 GitHub: imtiaj007

💼 Portfolio: https://imtiaj007.github.io/IA/

If you find this project helpful, feel free to give it a ⭐️ on GitHub!
