-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 22 May 2022, 17:59:43
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `realestateautomation`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `estate`
--

CREATE TABLE `estate` (
  `ID` int(11) NOT NULL,
  `City` text NOT NULL,
  `Country` text NOT NULL,
  `District` text NOT NULL,
  `NumberOfRooms` varchar(40) NOT NULL,
  `HomeHeatingSystem` text NOT NULL,
  `Furnished` tinyint(1) NOT NULL DEFAULT 0,
  `Adress` text NOT NULL,
  `Price` mediumint(9) NOT NULL,
  `SquareMeters` int(11) NOT NULL,
  `BuildingAge` date NOT NULL,
  `Situation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `estate`
--

INSERT INTO `estate` (`ID`, `City`, `Country`, `District`, `NumberOfRooms`, `HomeHeatingSystem`, `Furnished`, `Adress`, `Price`, `SquareMeters`, `BuildingAge`, `Situation`) VALUES
(24, 'Adana', 'Artuklu', '13 Mart', '1+0', 'Boilers', 0, 'aaaaaaaaaaabbbbbbbb', 123, 32144, '2023-07-01', 'For Sell'),
(31, 'Adana', 'Ceyhan', 'Adana Mahallesi', '2+1', 'Heat Pumps', 1, 'asd', 133, 243, '2018-05-15', 'For Rent'),
(32, 'Adana', 'Ceyhan', 'Adana Mahallesi', '3+1', 'Heat Pumps', 1, 'asdasdasff', 123, 16, '2022-05-25', 'For Rent'),
(33, 'Adana', 'Arakli', 'Adana Mahallesi', '2+1', 'Heat Pumps', 1, 'adana', 200, 300, '2016-05-18', 'For Rent'),
(34, 'Trabzon', 'Ceyhan', 'Adana Mahallesi', '2+1', 'Electric Space Heaters', 1, 'asd', 1233, 42424, '2022-05-18', 'For Rent'),
(35, 'Trabzon', 'Ceyhan', 'Trabzon Mahallesi', '1+1', 'Boilers', 1, 'zcvxcv', 1234, 1234, '2022-05-26', 'For Sell'),
(36, 'Adana', 'Arakli', 'Adana Mahallesi', '1+1', 'Boilers', 1, 'aasdasd', 1234, 124123, '2022-05-17', 'For Rent'),
(37, 'Adana', 'Ceyhan', 'Trabzon Mahallesi', '2+1', 'Boilers', 1, 'dfggdfgdf', 123, 124, '2022-05-18', 'For Rent');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `First_Name` text NOT NULL,
  `Last_Name` text NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(300) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Type` tinyint(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`ID`, `First_Name`, `Last_Name`, `Email`, `Password`, `Username`, `Type`) VALUES
(14, '1', '23', '1', 'e5deefdfb9681fa407fd275047904567', 'omer44', 0),
(15, 'omer', 'gokcen', 'omergokcen@hotmail.com', 'd9b1d7db4cd6e70935368a1efb10e377', 'omergokcen48', 0),
(16, 'omer', 'gokcen', 'omergokcen@email.com', 'd9b1d7db4cd6e70935368a1efb10e377', 'omergokcen3', 1),
(20, 'yusuf', 'koroglu', 'yusuftravego@hotmail.com', '98e183db0d21e71d5e11e225a930296f', 'yusuf33', 0),
(30, 'omer', 'gokcen', 'omergokcen@hotmail.com', 'd9b1d7db4cd6e70935368a1efb10e377', 'omergokcen1', 0),
(31, 'omer', 'gokcen', 'omergokcen@hotmail.com', 'd9b1d7db4cd6e70935368a1efb10e377', 'omergokcen1', 0);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `estate`
--
ALTER TABLE `estate`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `estate`
--
ALTER TABLE `estate`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
