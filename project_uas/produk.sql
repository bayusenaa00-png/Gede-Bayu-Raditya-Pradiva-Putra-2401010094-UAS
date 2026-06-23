-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2026 at 05:48 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` double NOT NULL,
  `stok` int(11) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `atribut_khusus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id`, `nama`, `harga`, `stok`, `jenis`, `atribut_khusus`) VALUES
(1, 'Laptop ASUS ROG Strix', 18500000, 10, 'Fisik', '2.5 kg'),
(2, 'Mouse Gaming Logitech G102', 250000, 50, 'Fisik', '85 gram'),
(3, 'Keyboard Mechanical Rexus', 450000, 25, 'Fisik', '1.1 kg'),
(4, 'Monitor LG 24 Inch IPS', 1650000, 15, 'Fisik', '3.8 kg'),
(5, 'Smartphone Samsung S23', 12000000, 8, 'Fisik', '168 gram'),
(6, 'Lisensi Windows 11 Pro', 350000, 100, 'Digital', 'Digital Key'),
(7, 'E-Book Tutorial Java OOP', 75000, 500, 'Digital', '15 MB'),
(8, 'Source Code Aplikasi Kasir', 1500000, 99, 'Digital', '45 MB'),
(9, 'Adobe Photoshop Pre-activated', 120000, 200, 'Digital', '2.1 GB'),
(10, 'Asset 3D Game RPG Pack', 300000, 150, 'Digital', '850 MB');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
