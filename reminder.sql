-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2020 at 07:05 AM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reminder`
--

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `uid` int(90) NOT NULL,
  `UserName` varchar(70) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Name` varchar(90) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`uid`, `UserName`, `Password`, `Name`, `Gender`, `Email`, `Phone`) VALUES
(1, 'neha', '123', 'Neha kharel', 'Female', 'nehakharel44@gmail.com', 1234567),
(2, 'eva', '456', 'Eva Thapa', 'Female', 'arjukharel03@gmail.com', 3456789),
(3, 'Tulsi', '44', 'Tulsi Kharel', 'Male', 'kirantr44@gmail.com', 4567890),
(5, 'alina', '456', 'Alina Joshi', 'Female', 'alina03@gmail.com', 6879809),
(6, 'rax96', '96', 'Raj Adhikari', 'Male', 'raj@gmail.com', 6789),
(7, 'test', '45', 'test', 'Male', 'nk@gmail.com', 456576),
(8, 'test', 'test', 'test', 'Female', 'test@gmail.com', 12345);

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `uid` int(90) NOT NULL,
  `event_id` int(50) NOT NULL,
  `Purpose` varchar(100) NOT NULL,
  `Event` varchar(100) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`uid`, `event_id`, `Purpose`, `Event`, `Date`) VALUES
(5, 1, 'Personal', 'Wedding', '0000-00-00'),
(6, 2, 'Personal', 'club', '0000-00-00'),
(7, 3, 'Personal', 'test', '0000-00-00'),
(1, 4, 'Personal', 'med4', '2020-03-09'),
(1, 5, 'Personal', 'med5', '2020-03-06'),
(1, 6, 'Personal', 'med8', '2020-08-08'),
(1, 7, 'Personal', 'med5', '2020-08-09'),
(2, 8, 'Personal', 'med1', '2020-03-08'),
(2, 9, 'Personal', 'test2', '2020-03-07'),
(2, 10, 'Personal', 'test6', '2020-04-07'),
(1, 11, 'Personal', 'test08', '2020-08-03'),
(1, 12, 'Personal', 'event1', '2020-03-11'),
(1, 13, 'Personal', 'event1', '2020-03-10'),
(1, 14, 'Personal', 'event1', '2020-03-12'),
(1, 15, 'Personal', 'test', '2020-03-11'),
(1, 16, 'Personal', 'test', '2020-03-11'),
(1, 17, 'Personal', 'test', '2020-08-09'),
(1, 18, 'Personal', 'kaku', '2020-03-12'),
(1, 19, 'Personal', 'kaku', '2020-03-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `FK` (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `uid` int(90) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `userdata`
--
ALTER TABLE `userdata`
  MODIFY `event_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
