-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2021 at 06:29 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phonebook_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `CONTACT_ID` int(11) NOT NULL,
  `name` text NOT NULL,
  `address` text NOT NULL,
  `city` text NOT NULL,
  `state` text NOT NULL,
  `phone` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`CONTACT_ID`, `name`, `address`, `city`, `state`, `phone`) VALUES
(32, 'Calvo, Danille E.', '90 tour st.', 'Everett', 'MA', '617-228-3272'),
(345, 'Catallozzi, Lori A.', '12 donetree Way', 'dinglogtown', 'MA', '617-228-2048'),
(352, 'Brennan, Lauren', '45 Mian st.', 'Chelsea', 'MA', '617-336-5059'),
(435, 'Anand, Monic', '43 Tree st.', 'Framingham', 'MA', '617-228-2158'),
(461, 'Ali', '21 Henry St.', 'Somerville', 'MA', '879-516-5741'),
(467, 'Banton, Corry H.', '67 Maple st.', 'Smalltown', 'NH', '617-936-1911'),
(478, 'Burns, James F.', '7 elevor way', 'stonetown', 'NH', '617-228-2326'),
(542, 'Souzan', '243 Henry St.', 'East Boston', 'MA', '987-432-7176'),
(712, 'Jack', '242 Boylston St.', 'Medford', 'NY', '762-891-3482'),
(823, 'Amanda', '122 harvard', 'Marlborough', 'MA', '691-227-8721'),
(883, 'Mariam', '124 Southern St.', 'Melrose', 'MA', '761-834-9891'),
(902, 'Cifuni, Margaret', '78 Yushu st.', 'Boston', 'MA', '617-228-3236'),
(921, 'Michael', '653 haha St.', 'Charlestown', 'MA', '538-219-2671'),
(2343, 'Siggelkoe, Erik R.', '23 Washingtown st.', 'Newtown', 'MA', '617-228-3320'),
(2678, 'Naggie, Lindsay A.', '30 Timeberview Way', 'Charlestown', 'MA', '617-228-3234'),
(3453, 'Bhuiya, Akram H.', '23 Main st.', 'Framingham', 'MA', '617-228-2333'),
(3532, 'Akai-Dennis, Naoko', '56 Griklse st.', 'Stonetown', 'MA', '617-228-2156'),
(4534, 'Akerley-Procopio, Donna', '78 xiaojun st.', 'hometown', 'NH', '617-228-2388'),
(4562, 'Cheng, Linda', '78 home st.', 'Charlestown', 'MA', '617-936-1975'),
(6721, 'Peter Morgan', '78 Harvard St.', 'East Boston', 'MA', '891-432-7681'),
(6823, 'Hariklia Delta', '652 North St.', 'Charelstown', 'MA', '617-228-2484'),
(7553, 'Cruz, Zoe', '78 Huku st.', 'yushutown ', 'NJ', '617-336-5089'),
(7821, 'Elizabeth Miller', '34267 Glendale Parkwway', 'Portland', 'NH', '971-888-9134'),
(8721, 'Harris Williams', '781 Henry St.', 'Charlestown', 'MA', '617-228-2204'),
(8912, 'Nasser', '234 Ferry St.', 'Malden', 'MA', '872-349-2193'),
(8965, 'Chen, Yanming J.', '739 Timeview way', 'Charlestown', 'MA', '617-228-1989'),
(8971, 'Michael Curry', '78 Harvard St.', 'Boston', 'MA', '617-228-2412');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD UNIQUE KEY `CONTACT_ID` (`CONTACT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
