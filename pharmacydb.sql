-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2026 at 11:42 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `batch`
--

CREATE TABLE `batch` (
  `BatchID` int(11) NOT NULL,
  `MedicineID` int(11) NOT NULL,
  `BatchNumber` varchar(50) NOT NULL,
  `ExpiryDate` date NOT NULL,
  `PurchasePrice` decimal(10,2) NOT NULL,
  `SellingPrice` decimal(10,2) NOT NULL,
  `StockQuantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `batch`
--

INSERT INTO `batch` (`BatchID`, `MedicineID`, `BatchNumber`, `ExpiryDate`, `PurchasePrice`, `SellingPrice`, `StockQuantity`) VALUES
(1, 1, 'BAT-101', '2027-12-31', 1.50, 2.50, 500),
(2, 2, 'BAT-102', '2026-10-15', 3.00, 5.00, 300),
(3, 3, 'BAT-103', '2027-05-20', 4.00, 7.00, 200),
(4, 4, 'BAT-104', '2029-11-01', 1.20, 2.00, 100),
(5, 5, 'BAT-105', '2028-01-10', 35.00, 50.00, 80),
(6, 6, 'BAT-106', '2026-08-30', 4.50, 7.00, 250),
(7, 7, 'BAT-107', '2027-02-14', 8.00, 12.00, 150),
(8, 8, 'BAT-108', '2026-11-20', 2.00, 3.50, 400),
(9, 9, 'BAT-109', '2028-06-30', 1.50, 3.00, 50),
(10, 10, 'BAT-110', '2027-09-15', 5.00, 8.00, 180);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `FirstName`, `LastName`, `Phone`, `Email`) VALUES
(1, 'Rahim', 'Uddin', '01810000001', 'rahim@gmail.com'),
(2, 'Karim', 'Ahmed', '01810000002', 'karim@gmail.com'),
(3, 'Sultana', 'Razia', '01810000003', 'razia@yahoo.com'),
(4, 'Tanvir', 'Hassan', '01810000004', 'tanvir@gmail.com'),
(5, 'Ayesha', 'Siddiqua', '01810000005', 'ayesha@outlook.com'),
(6, 'Kamal', 'Hossain', '01810000006', 'kamal@gmail.com'),
(7, 'Nusrat', 'Jahan', '01810000007', 'nusrat@gmail.com'),
(8, 'Fahim', 'Shahriar', '01810000008', 'fahim@gmail.com'),
(9, 'Mehedi', 'Hasan', '01810000009', 'mehedi@gmail.com'),
(10, 'Sabrina', 'Islam', '01810000010', 'sabrina@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `FirstName`, `LastName`, `Role`, `Phone`, `Salary`) VALUES
(1, 'Abdur', 'Rahman', 'Manager', '01910000001', 50000.00),
(2, 'Fatema', 'Begum', 'Pharmacist', '01910000002', 35000.00),
(3, 'Salam', 'Miah', 'Pharmacist', '01910000003', 32000.00),
(4, 'Rina', 'Akter', 'Cashier', '01910000004', 22000.00),
(5, 'Monir', 'Khan', 'Cashier', '01910000005', 20000.00),
(6, 'Jahangir', 'Alam', 'Storekeeper', '01910000006', 25000.00),
(7, 'Shirin', 'Sultana', 'Pharmacist', '01910000007', 34000.00),
(8, 'Tariq', 'Zia', 'Assistant', '01910000008', 18000.00),
(9, 'Nazmul', 'Huda', 'Cashier', '01910000009', 21000.00),
(10, 'Khadija', 'Tul-Kobra', 'Pharmacist', '01910000010', 36000.00);

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `MedicineID` int(11) NOT NULL,
  `MedicineName` varchar(100) NOT NULL,
  `Category` varchar(50) DEFAULT NULL,
  `GenericName` varchar(100) DEFAULT NULL,
  `SupplierID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`MedicineID`, `MedicineName`, `Category`, `GenericName`, `SupplierID`) VALUES
(1, 'Napa Extra', 'Analgesic', 'Paracetamol + Caffeine', 1),
(2, 'Seclo 20', 'Gastric', 'Omeprazole', 1),
(3, 'Sergel 20', 'Gastric', 'Esomeprazole', 2),
(4, 'Napa Extend', 'Analgesic', 'Paracetamol', 1),
(5, 'Cef-3', 'Antibiotic', 'Cefixime', 3),
(6, 'Maxpro 20', 'Gastric', 'Esomeprazole', 4),
(7, 'Bizoran 5/20', 'Antihypertensive', 'Amlodipine + Olmesartan', 5),
(8, 'Alatrol', 'Antihistamine', 'Cetirizine', 1),
(9, 'Tofen', 'Antihistamine', 'Ketotifen', 3),
(10, 'Fexo 120', 'Antihistamine', 'Fexofenadine', 2);

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `PrescriptionID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `DoctorName` varchar(100) NOT NULL,
  `PrescriptionDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`PrescriptionID`, `CustomerID`, `DoctorName`, `PrescriptionDate`) VALUES
(1, 1, 'Dr. Ali', '2026-08-01'),
(2, 2, 'Dr. Chowdhury', '2026-08-05'),
(3, 3, 'Dr. Khan', '2026-08-10'),
(4, 4, 'Dr. Ali', '2026-08-12'),
(5, 5, 'Dr. Ahmed', '2026-08-15'),
(6, 6, 'Dr. Chowdhury', '2026-08-18'),
(7, 7, 'Dr. Rahman', '2026-08-20'),
(8, 8, 'Dr. Ali', '2026-08-22'),
(9, 9, 'Dr. Khan', '2026-08-25'),
(10, 10, 'Dr. Ahmed', '2026-08-28');

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `SaleID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `EmployeeID` int(11) NOT NULL,
  `PrescriptionID` int(11) DEFAULT NULL,
  `SaleDate` datetime NOT NULL,
  `TotalAmount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`SaleID`, `CustomerID`, `EmployeeID`, `PrescriptionID`, `SaleDate`, `TotalAmount`) VALUES
(1, 1, 2, 1, '2026-08-01 10:00:00', 50.00),
(2, 2, 4, 2, '2026-08-05 11:30:00', 140.00),
(3, 3, 2, NULL, '2026-08-10 14:15:00', 25.00),
(4, 4, 5, 4, '2026-08-12 16:00:00', 250.00),
(5, 5, 3, 5, '2026-08-15 09:45:00', 70.00),
(6, 6, 4, NULL, '2026-08-18 18:20:00', 35.00),
(7, 7, 2, 7, '2026-08-20 12:10:00', 120.00),
(8, 8, 5, NULL, '2026-08-22 15:00:00', 16.00),
(9, 9, 3, 9, '2026-08-25 17:30:00', 30.00),
(10, 10, 4, 10, '2026-08-28 19:00:00', 80.00);

-- --------------------------------------------------------

--
-- Table structure for table `saledetails`
--

CREATE TABLE `saledetails` (
  `SaleDetailID` int(11) NOT NULL,
  `SaleID` int(11) NOT NULL,
  `BatchID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `UnitPrice` decimal(10,2) NOT NULL,
  `Subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `saledetails`
--

INSERT INTO `saledetails` (`SaleDetailID`, `SaleID`, `BatchID`, `Quantity`, `UnitPrice`, `Subtotal`) VALUES
(1, 1, 1, 20, 2.50, 50.00),
(2, 2, 2, 10, 5.00, 50.00),
(3, 2, 3, 10, 7.00, 70.00),
(4, 3, 1, 10, 2.50, 25.00),
(5, 4, 5, 5, 50.00, 250.00),
(6, 5, 6, 10, 7.00, 70.00),
(7, 6, 8, 10, 3.50, 35.00),
(8, 7, 7, 10, 12.00, 120.00),
(9, 8, 10, 2, 8.00, 16.00),
(10, 9, 9, 10, 3.00, 30.00);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(11) NOT NULL,
  `SupplierName` varchar(100) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`, `Phone`, `Email`, `Address`) VALUES
(1, 'Square Pharma', '01711000001', 'info@square.com', 'Dhaka, Bangladesh'),
(2, 'Incepta Pharma', '01711000002', 'contact@incepta.com', 'Dhaka, Bangladesh'),
(3, 'Beximco Pharma', '01711000003', 'sales@beximco.com', 'Gazipur, Bangladesh'),
(4, 'Renata Limited', '01711000004', 'support@renata.com', 'Dhaka, Bangladesh'),
(5, 'ACI Healthcare', '01711000005', 'info@aci.com', 'Narayanganj, Bangladesh'),
(6, 'Healthcare Pharma', '01711000006', 'sales@hpl.com', 'Dhaka, Bangladesh'),
(7, 'Eskayef Pharma', '01711000007', 'info@skf.com', 'Tongi, Bangladesh'),
(8, 'Acme Laboratories', '01711000008', 'contact@acme.com', 'Dhamrai, Bangladesh'),
(9, 'Aristopharma', '01711000009', 'sales@aristo.com', 'Dhaka, Bangladesh'),
(10, 'Drug International', '01711000010', 'info@druginternational.com', 'Dhaka, Bangladesh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `batch`
--
ALTER TABLE `batch`
  ADD PRIMARY KEY (`BatchID`),
  ADD KEY `MedicineID` (`MedicineID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`MedicineID`),
  ADD KEY `SupplierID` (`SupplierID`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`PrescriptionID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`SaleID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `EmployeeID` (`EmployeeID`),
  ADD KEY `PrescriptionID` (`PrescriptionID`);

--
-- Indexes for table `saledetails`
--
ALTER TABLE `saledetails`
  ADD PRIMARY KEY (`SaleDetailID`),
  ADD KEY `SaleID` (`SaleID`),
  ADD KEY `BatchID` (`BatchID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `batch`
--
ALTER TABLE `batch`
  MODIFY `BatchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `MedicineID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `PrescriptionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `SaleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `saledetails`
--
ALTER TABLE `saledetails`
  MODIFY `SaleDetailID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `SupplierID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `batch`
--
ALTER TABLE `batch`
  ADD CONSTRAINT `batch_ibfk_1` FOREIGN KEY (`MedicineID`) REFERENCES `medicine` (`MedicineID`);

--
-- Constraints for table `medicine`
--
ALTER TABLE `medicine`
  ADD CONSTRAINT `medicine_ibfk_1` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`);

--
-- Constraints for table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);

--
-- Constraints for table `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  ADD CONSTRAINT `sale_ibfk_2` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`),
  ADD CONSTRAINT `sale_ibfk_3` FOREIGN KEY (`PrescriptionID`) REFERENCES `prescription` (`PrescriptionID`);

--
-- Constraints for table `saledetails`
--
ALTER TABLE `saledetails`
  ADD CONSTRAINT `saledetails_ibfk_1` FOREIGN KEY (`SaleID`) REFERENCES `sale` (`SaleID`),
  ADD CONSTRAINT `saledetails_ibfk_2` FOREIGN KEY (`BatchID`) REFERENCES `batch` (`BatchID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
