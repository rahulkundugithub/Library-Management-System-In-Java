-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2023 at 05:39 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `ID` int(20) NOT NULL,
  `Author_Name` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Phone_Number` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`ID`, `Author_Name`, `Address`, `Phone_Number`) VALUES
(1, 'Salman Rushdie', 'Mumbai', 9820382780),
(4, 'Shyamal Ganguly', 'Kolkata', 8908989897),
(6, 'Shuva Das', 'Bangalore', 9878986789),
(7, 'Gautam Kundu', 'Pune', 9087599688),
(8, 'Asha Devi', 'Batanagar', 9678457887);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` int(11) NOT NULL,
  `Book_Name` varchar(255) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Author` int(11) NOT NULL,
  `Publisher` int(11) NOT NULL,
  `Isbn_No` varchar(255) NOT NULL,
  `Edition` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `Book_Name`, `Category`, `Author`, `Publisher`, `Isbn_No`, `Edition`) VALUES
(1, 'Current GK Book', '1', 1, 2, 'ISBN 81789738', '3'),
(2, 'Core Java', '4', 1, 2, 'ISBN 36628889', '6'),
(4, 'Indian Polity', '3', 7, 2, 'ISBN 81789994', '14'),
(5, 'Nuclear Physics', '6', 6, 4, 'ISBN 56389738', '9'),
(6, 'Course on C++', '4', 6, 5, 'ISBN 12479738', '2'),
(9, 'Atomica', '6', 4, 4, 'ISBN 67569738', '2'),
(10, 'Ancient History', '10', 4, 5, 'ISBN 45893738', '2');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `ID` int(20) NOT NULL,
  `CategoryName` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`ID`, `CategoryName`, `Status`) VALUES
(1, 'GK', 'Active'),
(3, 'Politics', 'Active'),
(4, 'Computer Application', 'Active'),
(6, 'Physics', 'Active'),
(10, 'History', 'Active'),
(11, 'Chemistry', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE `issuebook` (
  `id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `issuedate` date NOT NULL,
  `returndate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issuebook`
--

INSERT INTO `issuebook` (`id`, `member_id`, `book_id`, `issuedate`, `returndate`) VALUES
(9, 5, 5, '2023-02-13', '2023-02-22'),
(11, 6, 9, '2023-02-14', '2023-02-21');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `member_address` varchar(255) NOT NULL,
  `member_phone` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `member_name`, `member_address`, `member_phone`) VALUES
(1, 'Krishna Menon', 'Gopalnagar', 9089786758),
(2, 'Peter James', 'Bongaon Palla', 9788656788),
(4, 'Suniti Patra', 'Kolkata', 8976754677),
(5, 'Katha Kundu', 'Madhyamgram', 8578997898),
(6, 'Soumya Roy', 'Sodepore', 9786789786),
(7, 'Gopa Kundu', 'Batanagar', 9987898678),
(8, 'Payel Kundu', 'Dumdum', 9876543210);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `ID` int(11) NOT NULL,
  `Publisher_Name` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Phone_Number` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`ID`, `Publisher_Name`, `Address`, `Phone_Number`) VALUES
(2, 'Dev Prakashani', '35 Madan Pal Lane, Kolkata 25', 9089786756),
(3, 'Mc Graw Hill', '12 BT Road, Kolkata 22', 9078451256),
(4, 'Ananda', '32 APC Road,Kolkata 20', 8978896756),
(5, 'Suprokash', '16 Bankim lane, Kolkata 32', 9885673427);

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `id` int(11) NOT NULL,
  `memberid` int(11) NOT NULL,
  `membername` varchar(255) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `returndate` varchar(255) NOT NULL,
  `actualreturndate` date NOT NULL,
  `elapsed` int(11) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`id`, `memberid`, `membername`, `bookname`, `returndate`, `actualreturndate`, `elapsed`, `fine`) VALUES
(8, 1, 'Krishna Menon', 'Course on C++', '2023-02-15', '2023-02-17', 2, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `issuebook`
--
ALTER TABLE `issuebook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `returnbook`
--
ALTER TABLE `returnbook`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `issuebook`
--
ALTER TABLE `issuebook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `returnbook`
--
ALTER TABLE `returnbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
