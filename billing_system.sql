-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2016 at 05:38 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `billing system`
--

-- --------------------------------------------------------

--
-- Table structure for table `barcode`
--

CREATE TABLE IF NOT EXISTS `barcode` (
  `barcode` varchar(20) NOT NULL,
  `p_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
`c_id` int(11) NOT NULL,
  `c_name` varchar(20) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`c_id`, `c_name`, `contact`, `email`) VALUES
(1, 'shweta', 1236547890, 'shweta@gmail.com'),
(2, 'codeace', 7456981230, 'codeace@gmail.com'),
(3, 'sonali', 9406541513, 'sonali@codeace.com'),
(14, 'Naresh KUmar', 9424692792, 'asus@gmail.com'),
(15, 'shweta', 1234567890, 'gupta');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
`o_id` int(11) NOT NULL,
  `c_id` int(11) DEFAULT NULL,
  `pay_mode` varchar(20) DEFAULT NULL,
  `amt` double DEFAULT NULL,
  `o_date` date DEFAULT NULL,
  `o_time` time DEFAULT NULL,
  `pay_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`o_id`, `c_id`, `pay_mode`, `amt`, `o_date`, `o_time`, `pay_id`) VALUES
(1, 3, NULL, 57, '2016-01-12', '10:59:34', NULL),
(2, 3, NULL, 285, '2016-01-12', '11:00:38', NULL),
(3, 3, NULL, 24, '2016-01-12', '11:46:49', NULL),
(4, 3, NULL, 24, '2016-01-12', '11:47:50', NULL),
(5, 3, NULL, 195, '2016-01-12', '14:00:26', NULL),
(6, 3, NULL, 114, '2016-01-12', '14:04:31', NULL),
(7, 3, NULL, 24, '2016-01-12', '14:10:37', NULL),
(8, 3, NULL, 171, '2016-01-12', '14:11:40', NULL),
(9, 3, NULL, 57, '2016-01-12', '14:13:17', NULL),
(10, 3, NULL, 96, '2016-01-12', '14:15:55', NULL),
(11, 3, NULL, 162, '2016-01-12', '14:17:12', NULL),
(12, 3, NULL, 81, '2016-01-12', '14:20:02', NULL),
(13, 3, NULL, 81, '2016-01-12', '14:22:30', NULL),
(14, 3, NULL, 81, '2016-01-12', '14:27:19', NULL),
(15, 3, NULL, 180, '2016-01-12', '14:31:57', NULL),
(16, 3, NULL, 36, '2016-01-12', '14:36:22', NULL),
(17, 3, NULL, 18, '2016-01-12', '14:37:20', NULL),
(18, 3, NULL, 18, '2016-01-12', '14:48:47', NULL),
(19, 3, NULL, 108, '2016-01-12', '14:59:12', 'Sh1236541'),
(20, 15, NULL, 57, '2016-01-12', '19:03:43', NULL),
(21, 3, NULL, 57, '2016-01-12', '19:17:51', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE IF NOT EXISTS `order_details` (
  `o_id` int(11) NOT NULL DEFAULT '0',
  `p_id` int(11) NOT NULL DEFAULT '0',
  `qty` int(11) DEFAULT NULL,
  `t_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`o_id`, `p_id`, `qty`, `t_price`) VALUES
(1, 1, 1, 57),
(2, 1, 1, 57),
(3, 3, 1, 24),
(4, 3, 1, 24),
(5, 1, 3, 171),
(5, 3, 1, 24),
(6, 1, 1, 57),
(7, 3, 1, 24),
(8, 1, 1, 57),
(9, 1, 1, 57),
(10, 3, 1, 24),
(11, 1, 2, 114),
(11, 3, 2, 48),
(12, 1, 1, 57),
(12, 3, 1, 24),
(13, 1, 1, 57),
(13, 3, 1, 24),
(14, 1, 1, 57),
(14, 3, 1, 24),
(15, 5, 1, 18),
(15, 6, 3, 162),
(16, 5, 2, 36),
(17, 5, 1, 18),
(18, 5, 1, 18),
(19, 6, 2, 108),
(20, 1, 1, 57),
(21, 1, 1, 57);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `b_id` varchar(20) DEFAULT NULL,
`p_id` int(11) NOT NULL,
  `category` varchar(30) DEFAULT NULL,
  `p_name` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `qty` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`b_id`, `p_id`, `category`, `p_name`, `price`, `discount`, `qty`) VALUES
(NULL, 1, 'Biscuits', 'HidenSeeks', 60, 5, 200),
(NULL, 3, 'Rice', 'Basmati Rice', 25, 4, 50),
(NULL, 5, 'food', 'flour', 20, 10, 100),
(NULL, 6, 'Rice', 'basmati Rice', 60, 10, 60),
(NULL, 7, 'People', 'xyz', 45.56, 35.5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `settings`
--

CREATE TABLE IF NOT EXISTS `settings` (
  `cname` varchar(30) DEFAULT NULL,
  `clogo` varchar(50) DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `owner` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `settings`
--

INSERT INTO `settings` (`cname`, `clogo`, `tax`, `owner`) VALUES
('codeace', NULL, 12, 'xyz');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
`emp_id` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `category`, `emp_id`) VALUES
('abc', '[C@58376317', 'admin', 1),
('abc1', '[C@27a20a8', 'admin', 2),
('abccc', '[C@34a2df79', 'admin', 3),
('abcc', '[C@525cac6b', 'Employee', 4),
('njsn', '12345', 'Employee', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barcode`
--
ALTER TABLE `barcode`
 ADD PRIMARY KEY (`barcode`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
 ADD PRIMARY KEY (`c_id`), ADD UNIQUE KEY `contact` (`contact`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
 ADD PRIMARY KEY (`o_id`), ADD KEY `c_id` (`c_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
 ADD PRIMARY KEY (`o_id`,`p_id`), ADD KEY `p_id` (`p_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
 ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD UNIQUE KEY `emp_id` (`emp_id`), ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
MODIFY `o_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customers` (`c_id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`),
ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `products` (`p_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
