-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               8.0.12 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for hotelmanager
CREATE DATABASE IF NOT EXISTS `hotelmanager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `hotelmanager`;

-- Dumping structure for table hotelmanager.prices
CREATE TABLE IF NOT EXISTS `prices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perhour` int(11) DEFAULT NULL,
  `perday` int(11) DEFAULT NULL,
  `des` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `idtype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_prices_types` (`idtype`),
  CONSTRAINT `FK_prices_types` FOREIGN KEY (`idtype`) REFERENCES `types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table hotelmanager.prices: ~6 rows (approximately)
/*!40000 ALTER TABLE `prices` DISABLE KEYS */;
INSERT INTO `prices` (`id`, `perhour`, `perday`, `des`, `idtype`) VALUES
	(1, 100, 450, 'regular-single', 1),
	(2, 150, 600, 'regular-double', 2),
	(3, 200, 750, 'regular-family', 3),
	(4, 400, 750, 'luxury-single', 1),
	(5, 600, 1000, 'luxury-double', 2),
	(6, 1000, 1300, 'luxury-family', 3);
/*!40000 ALTER TABLE `prices` ENABLE KEYS */;

-- Dumping structure for table hotelmanager.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomnumber` int(11) DEFAULT NULL,
  `roomstatus` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `idprice` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rooms_prices` (`idprice`),
  CONSTRAINT `FK_rooms_prices` FOREIGN KEY (`idprice`) REFERENCES `prices` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table hotelmanager.rooms: ~16 rows (approximately)
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` (`id`, `roomnumber`, `roomstatus`, `idprice`) VALUES
	(1, 101, 'booked', 1),
	(2, 102, 'free', 4),
	(3, 103, 'occu', 5),
	(4, 104, 'free', 1),
	(5, 105, 'booked', 1),
	(6, 201, 'occu', 5),
	(7, 202, 'free', 4),
	(8, 203, 'booked', 3),
	(9, 204, 'free', 2),
	(10, 205, 'free', 4),
	(11, 301, 'free', 5),
	(12, 302, 'free', 4),
	(13, 303, 'occu', 4),
	(14, 304, 'occu', 6),
	(15, 305, 'booked', 6),
	(16, 306, 'booked', 4);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;

-- Dumping structure for table hotelmanager.types
CREATE TABLE IF NOT EXISTS `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomtype` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `des` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table hotelmanager.types: ~3 rows (approximately)
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` (`id`, `roomtype`, `des`) VALUES
	(1, 'single', '1-2 person'),
	(2, 'couple', '2-3 person'),
	(3, 'family', 'more than 3');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
