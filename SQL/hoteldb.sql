-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hoteldb
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `booking_start_date` date NOT NULL,
  `booking_end_date` date NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  KEY `fk_Bookings_Clients1_idx` (`client_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `fk_Bookings_Clients1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
  CONSTRAINT `room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (24,27,'2020-01-16','2020-01-18',1),(25,28,'2020-01-23','2020-01-25',1),(26,29,'2020-01-16','2020-01-20',3),(27,30,'2020-01-23','2020-01-25',3),(28,31,'2020-07-11','2020-07-18',4),(29,32,'2020-02-01','2020-02-04',4),(30,33,'2020-02-02','2020-02-04',1),(34,37,'2020-03-20','2020-03-21',1),(35,38,'2020-03-22','2020-03-23',1),(36,39,'2020-03-24','2020-03-25',1),(37,40,'2022-01-21','2022-01-22',1),(38,41,'2024-01-21','2024-01-22',1),(39,42,'2026-01-21','2026-01-22',1),(40,43,'2028-01-21','2028-01-21',1),(41,44,'2030-12-24','2032-01-21',3),(42,45,'2040-03-24','2040-03-25',1),(43,46,'2050-03-24','2050-03-25',1),(44,47,'2060-03-24','2060-03-25',1),(45,48,'2020-05-15','2020-05-13',1),(46,49,'2070-03-24','2070-03-25',1);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_first_name` varchar(45) NOT NULL,
  `client_last_name` varchar(45) DEFAULT NULL,
  `client_email` varchar(45) DEFAULT NULL,
  `client_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `idClients_UNIQUE` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'John','Doe','email@co.at','Kettenbruckengasse 17'),(2,'Peter','Smith','peter@co.uk','Alser Strasse 16'),(3,'Dereck','Hart','dereck@co.at','Stephansplatz 1'),(4,'Laszlo','Sandor','laszlo@co.uk','Reumanplatz 2'),(5,'kecske','teszt','macska','csicska@'),(6,'tamasteszt','tamaslast','tamasemail','kecskeutca 3'),(7,'teszt','teszt','teszt','teszt'),(8,'mohammad','furmamrana','mhlfa@gmail.com','mohamad street 27'),(9,'h','h','h','h'),(10,'barni','valami','valamimas','cim'),(11,'lazlo','something','anything','anthingstreet'),(12,'lazlo','something','anything','an'),(13,'teszti','tesztri','teszti','tesziti'),(14,'k','k','k','k'),(15,'k','kewkr','kqrwk','qkwqek'),(16,'rwqr','rqweqwe','rqwe','qr'),(17,'jessi','j','hallo','bro'),(18,'Laszlo','Hallo','elsoteszt@gmail.com','helloka kukac'),(19,'Szia','Laci','lacivagyok@gmail.com','Hello'),(20,'Barni','Helloka','asd@gmail.com','kkear 24. utca'),(22,'Mert','Xyz','xyz@gmail.com','Hello'),(23,'Milán','Varga','varga.milan0236@gmail.com','8481 Somlóvásárhely Viola u. 1.'),(24,'Vinz','Grues','heh@gmail.com','Hekllloo'),(25,'Yoda','Mester','spamme@lucasart.com','jsjsmdk'),(26,'hello','teszt','gea@teaszt.com','ldskaksd'),(27,'Laszlo','Sandor','ls@gmail.com','Hello Straße 43 / 1231'),(28,'Tamas','Piski','tp@gmail.com','Tamasino Straße 23a / 22'),(29,'Philipp','Dörner','pd@gmail.com','Philip Straße 23'),(30,'Vinzenz','Griesbro','griesbro@gmail.com','Gries Straße 69 / 69'),(31,'Jessica','Messica','jm@gmail.com','Jessistrasse 7 / 1293'),(32,'Sebastian','Mekk','meks@gmail.com','Meks Staße 23 / 1231'),(33,'Edwin','Hallo','edwh@gmail.com','Edhin Street 27'),(37,'David','Copperfield','dc@kecske.com','Naschmarkt'),(38,'David','Copperfield','dc@kecske.com','Naschmarkt'),(39,'David','Copperfield','dc@kecske.com','Naschmarkt'),(40,'X','Z','t@gm.com','J'),(41,'','','',''),(42,'','','',''),(43,'','','',''),(44,'','','',''),(45,'David','Copperfield','dc@kecske.com','Naschmarkt'),(46,'David','Copperfield','dc@kecske.com','Naschmarkt'),(47,'David','Copperfield','dc@kecske.com','Naschmarkt'),(48,'XY','XY','xy@gmail.com','xy'),(49,'David','Copperfield','dc@kecske.com','Naschmarkt');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `facility_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_coffee_machine` tinyint(4) DEFAULT NULL,
  `is_wifi` tinyint(4) DEFAULT NULL,
  `is_tv` tinyint(4) DEFAULT NULL,
  `is_balcony` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`facility_id`),
  UNIQUE KEY `facility_id_UNIQUE` (`facility_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES (1,1,1,0,1),(2,0,1,1,0),(3,1,1,1,1),(4,1,0,1,0);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoices` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `invoice_total` int(11) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  UNIQUE KEY `invoice_id_UNIQUE` (`invoice_id`),
  KEY `fk_Invoices_Clients_idx` (`client_id`),
  CONSTRAINT `fk_Invoices_Clients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoices`
--

LOCK TABLES `invoices` WRITE;
/*!40000 ALTER TABLE `invoices` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_type_id` int(11) NOT NULL,
  `room_facility_id` int(11) NOT NULL,
  `room_is_booked` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `fk_Rooms_Roomtypes1_idx` (`room_type_id`),
  KEY `FKcfy6jm3kn8n6vnlvrx13kp6xg` (`room_facility_id`),
  CONSTRAINT `FKcfy6jm3kn8n6vnlvrx13kp6xg` FOREIGN KEY (`room_facility_id`) REFERENCES `facilities` (`facility_id`),
  CONSTRAINT `fk_Rooms_Roomtypes1` FOREIGN KEY (`room_type_id`) REFERENCES `roomtypes` (`roomtype_id`),
  CONSTRAINT `room_type_id` FOREIGN KEY (`room_type_id`) REFERENCES `roomtypes` (`roomtype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,1,1,0),(2,2,3,1),(3,3,2,0),(4,4,4,0);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtypes`
--

DROP TABLE IF EXISTS `roomtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomtypes` (
  `roomtype_id` int(11) NOT NULL AUTO_INCREMENT,
  `roomtype_name` varchar(45) NOT NULL,
  `room_price` int(11) DEFAULT NULL,
  `room_capacity` int(11) DEFAULT NULL,
  `room_size` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roomtype_id`),
  UNIQUE KEY `roomtype_id_UNIQUE` (`roomtype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtypes`
--

LOCK TABLES `roomtypes` WRITE;
/*!40000 ALTER TABLE `roomtypes` DISABLE KEYS */;
INSERT INTO `roomtypes` VALUES (1,'Single',50,1,'24'),(2,'Double',75,2,'35'),(3,'Junior Suite',110,2,'42'),(4,'Superior',250,4,'65');
/*!40000 ALTER TABLE `roomtypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-23  9:22:10
