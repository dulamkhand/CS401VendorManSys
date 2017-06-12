-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jun 08, 2017 at 05:15 PM
-- Server version: 5.6.35-cll-lve
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `vendormansys`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(10) NOT NULL,
  `login_name` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `type` varchar(10) NOT NULL,
  `vend_emp_id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`,`login_name`),
  UNIQUE KEY `vend_emp_id` (`vend_emp_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `number`, `login_name`, `password`, `type`, `vend_emp_id`) VALUES
(1, '00000', 'root', 'root_password', 'SUPER_USER', '00000'),
(4, '00001', 'bek', 'bek_bek', 'EMPLOYEE', 'E00001');

-- --------------------------------------------------------

--
-- Table structure for table `approval_status`
--

CREATE TABLE IF NOT EXISTS `approval_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `approval_status`
--

INSERT INTO `approval_status` (`id`, `name`) VALUES
(1, 'Active'),
(2, 'In Progress'),
(3, 'Fully'),
(4, 'Done');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_number` varchar(10) NOT NULL,
  `comp_reg_number` varchar(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `company_rep` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `vendor_number` (`vendor_number`,`comp_reg_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(10) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `acc_number` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`),
  UNIQUE KEY `acc_number` (`acc_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `number`, `first_name`, `last_name`, `acc_number`) VALUES
(1, 'E00001', 'Argynbyek', 'Shyegyebai', '00001');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `currency` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `name`, `amount`, `currency`, `status`, `created_date`) VALUES
(1, 'mn-ru tech invoice', 2342, 'usd', 1, '2017-06-08 17:43:36'),
(2, 'invoice for all samsung orders', 87.2, 'mnt', 1, '2017-06-08 17:44:11'),
(3, '3rd', 442.49, 'USD', 2, '2017-06-08 21:30:29'),
(4, '4th', 208.49, 'USD', 2, '2017-06-08 21:34:59'),
(5, '5th', 677.585, 'MNT', 1, '2017-06-08 21:39:08'),
(6, '6', 588.345, 'MNT', 3, '2017-06-08 21:42:56'),
(7, '7th invoice', 677.585, 'MNT', 1, '2017-06-08 21:45:24'),
(8, 'invoice for test2 & test3', 500, 'null', 1, '2017-06-08 22:08:35'),
(9, 'invoice for orders (4, 6, 8)', 0, 'null', 1, '2017-06-08 22:30:27');

-- --------------------------------------------------------

--
-- Table structure for table `invoice_status`
--

CREATE TABLE IF NOT EXISTS `invoice_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `invoice_status`
--

INSERT INTO `invoice_status` (`id`, `status`) VALUES
(1, 'Active'),
(2, 'In Progress'),
(3, 'Fully');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nb_words` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `service_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `project_id`, `name`, `nb_words`, `created_date`, `service_id`) VALUES
(1, NULL, 'Document 1', 550, '2017-06-08 20:39:23', 1),
(2, 18, 'Document 2', 2345, '2017-06-08 20:22:41', 2);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `invoice_id` int(11) NOT NULL DEFAULT '0',
  `amount` double NOT NULL,
  `currency` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `project_id`, `invoice_id`, `amount`, `currency`, `status`, `created_date`) VALUES
(2, 3, 7, 354.345, 'mnt', 3, '0000-00-00 00:00:00'),
(3, 1, 7, 234, 'MNT', 3, '0000-00-00 00:00:00'),
(4, 4, 7, 89.24, 'MNT', 2, '2017-06-08 19:17:19'),
(5, 2, 0, 119.25, 'USD', 1, '2017-06-08 19:31:39'),
(6, 6, 8, 500, 'USD', 1, '2017-06-08 22:06:18'),
(7, 7, 8, 0, 'null', 3, '2017-06-08 22:06:30'),
(8, 8, 9, 0, 'null', 2, '2017-06-08 22:06:42'),
(9, 9, 9, 0, 'null', 2, '2017-06-08 22:06:56'),
(10, 10, 9, 0, 'null', 1, '2017-06-08 22:10:04'),
(11, 11, 0, 0, 'null', 1, '2017-06-08 22:15:20'),
(12, 15, 0, 0, 'null', 2, '2017-06-08 22:15:34'),
(13, 14, 0, 0, 'null', 3, '2017-06-08 22:15:49'),
(14, 13, 0, 0, 'null', 3, '2017-06-08 22:16:48'),
(15, 16, 0, 0, 'null', 2, '2017-06-08 22:29:24');

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE IF NOT EXISTS `order_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `order_status`
--

INSERT INTO `order_status` (`id`, `status`) VALUES
(1, 'Active'),
(2, 'In Progress'),
(3, 'Fully');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `SSN` int(20) DEFAULT NULL,
  `nationality` varchar(40) NOT NULL,
  `vendor_number` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `vendor_number` (`vendor_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` double DEFAULT NULL,
  `currency` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `vendor_id` (`vendor_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `title`, `amount`, `currency`, `vendor_id`, `created_date`) VALUES
(1, 'Translation 1', 2500, 'USD', 1, '2017-06-07 16:11:45'),
(2, '170602_SAM_MKKAFX_071_J437-J446+Offline_1 \\ Mongol - Cyrillic', 119.25, 'USD', 1, '2017-06-07 16:52:40'),
(3, '170405_SAM_MKKAFX_071_J276-J279 \\ Mongol - Cyrillic', 60.46, 'USD', 2, '2017-06-07 16:53:02'),
(4, '170113_STMS-170006_SAM_MKKAFX_071_J041-J050+Offline1-4 \\ Mongol - Cyrillic', 89.24, 'MNT', 1, '2017-06-07 16:53:18'),
(5, 'Test', 500, 'USD', 1, '2017-06-08 19:37:16'),
(6, 'Test 2', 500, 'USD', 1, '2017-06-08 19:39:11'),
(7, 'Test 3', NULL, 'null', NULL, '2017-06-08 19:40:15'),
(8, 'Test 4', NULL, 'null', NULL, '2017-06-08 19:43:02'),
(9, 'Test 6', NULL, 'null', NULL, '2017-06-08 19:43:44'),
(10, 'Test 8', NULL, 'null', NULL, '2017-06-08 19:46:08'),
(11, 'Mongolian Government Documents', NULL, 'null', NULL, '2017-06-08 19:46:37'),
(12, 'Fairfield Police Department Investigation', NULL, 'null', NULL, '2017-06-08 20:07:52'),
(13, 'Test', NULL, 'null', NULL, '2017-06-08 20:11:34'),
(14, 'DOT Documents', NULL, 'null', NULL, '2017-06-08 20:15:52'),
(15, 'Burger King Fairfield', NULL, 'null', NULL, '2017-06-08 20:17:19'),
(16, 'McDonalds Fairfield', NULL, 'null', NULL, '2017-06-08 20:18:26'),
(17, 'Test', NULL, 'null', NULL, '2017-06-08 20:25:15'),
(18, 'Walmart Fairfield', NULL, 'null', NULL, '2017-06-08 20:40:12');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`id`, `name`) VALUES
(1, 'RUS-MNG'),
(2, 'MNG-RUS');

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE IF NOT EXISTS `vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(10) NOT NULL,
  `account_number` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`,`account_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);
