-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2022 at 01:35 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rrrs`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_email` text NOT NULL,
  `admin_pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_email`, `admin_pass`) VALUES
(1, 'admin2022@gmail.com', 'admin123'),
(2, 'aseel', '123');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `c_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  `c_info` text NOT NULL,
  `c_date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `msgs`
--

CREATE TABLE `msgs` (
  `msg_id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  `msg_info` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `rate_id` int(11) NOT NULL,
  `user-id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  `services_rate` float NOT NULL,
  `foodquality_rate` float NOT NULL,
  `Priceforservice_rate` float NOT NULL,
  `Cleanliness_rate` float NOT NULL,
  `avg_rate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rate_id`, `user-id`, `res_id`, `services_rate`, `foodquality_rate`, `Priceforservice_rate`, `Cleanliness_rate`, `avg_rate`) VALUES
(1, 3, 6, 3, 3, 3, 3, 3),
(2, 1, 1, 5, 4, 3, 4, 4),
(3, 1, 2, 5, 5, 5, 5, 5),
(7, 2, 5, 5, 5, 5, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `res_id` int(11) NOT NULL,
  `res_name` text NOT NULL,
  `res_city` text NOT NULL,
  `res_main_image` text NOT NULL,
  `res_image1` text DEFAULT NULL,
  `res_image2` text DEFAULT NULL,
  `res_menu` text NOT NULL,
  `owner_id` int(11) NOT NULL,
  `middle_image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`res_id`, `res_name`, `res_city`, `res_main_image`, `res_image1`, `res_image2`, `res_menu`, `owner_id`, `middle_image`) VALUES
(1, 'Dominos', 'nablus', '/image/d2.png', NULL, NULL, '...', 1, NULL),
(2, 'Treio', 'nablus', '/image/T100.png', NULL, NULL, '...', 1, NULL),
(3, 'w', 'nablus', '/image/w1.jpg', NULL, NULL, '...', 1, NULL),
(4, 'Solitaire', 'nablus', '/image/solitare.jpg', NULL, NULL, '...', 1, NULL),
(5, 'ward', 'nablus', '/image/ward.jpg', '/image/new_ward1stjpg.jpg', '/image/new_ward2nd.jpg', '...', 1, '/image/new_w3rdjpg.jpg'),
(6, 'Lemon W Na3na3', 'nablus', '/image/l1.jpg', '/image/lemoon4.jpg', '/image/lemoon3.jpg', '...', 1, '/image/lemoon2.jpg'),
(7, '90S', 'nablus', '/image/N33jpg.jpg', '/image/new_90s3rd.jpg', '/image/new_90s1st.jpg', '...', 1, '/image/new_90s2nd.jpg'),
(8, 'KFC', 'nablus', '/image/k2.jpg', '/image/new_KFC3rd.jpg', '/image/new_KFC2ndjpg.jpg', '...', 1, '/image/new_KFC1st.jpg'),
(9, 'Hardees', 'nablus', '/image/Hrdees.jpg', NULL, NULL, '...', 1, NULL),
(10, 'BFC', 'Nablus', '/image/BFC.jpg', '/image/BFC1.jpg', '/image/BFC2.jpg', '/image/BFCM.jpg', 1, '/image/BFC3.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `restaurants_owners`
--

CREATE TABLE `restaurants_owners` (
  `owner_id` int(11) NOT NULL,
  `owner_name` text NOT NULL,
  `owner_email` text NOT NULL,
  `owner_pass` text NOT NULL,
  `owner_phone` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurants_owners`
--

INSERT INTO `restaurants_owners` (`owner_id`, `owner_name`, `owner_email`, `owner_pass`, `owner_phone`) VALUES
(1, 'baraa', 'baraa5hfg@gmail.com', '1234', '0567067293'),
(2, 'aseel', 'aseel', '123', '635265');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` text NOT NULL,
  `user_email` text NOT NULL,
  `user_city` text NOT NULL,
  `user_pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_city`, `user_pass`) VALUES
(1, 'baraa', 'baraa5hfg@gmail.com', 'Nablus', '12344321'),
(2, 'ahmad', 'ahmad@gmail.com', 'nablus', '1234'),
(3, 'aseel', 'aseel', 'nablus', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`c_id`),
  ADD KEY `f4` (`user_id`),
  ADD KEY `f5` (`res_id`);

--
-- Indexes for table `msgs`
--
ALTER TABLE `msgs`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`rate_id`),
  ADD KEY `f2` (`user-id`),
  ADD KEY `f3` (`res_id`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`res_id`),
  ADD KEY `forgin1` (`owner_id`);

--
-- Indexes for table `restaurants_owners`
--
ALTER TABLE `restaurants_owners`
  ADD PRIMARY KEY (`owner_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `f4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `f5` FOREIGN KEY (`res_id`) REFERENCES `restaurants` (`res_id`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `f2` FOREIGN KEY (`user-id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `f3` FOREIGN KEY (`res_id`) REFERENCES `restaurants` (`res_id`);

--
-- Constraints for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD CONSTRAINT `forgin1` FOREIGN KEY (`owner_id`) REFERENCES `restaurants_owners` (`owner_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
