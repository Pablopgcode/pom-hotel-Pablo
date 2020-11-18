CREATE DATABASE  IF NOT EXISTS `pom_hotel` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pom_hotel`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: pom_hotel
-- ------------------------------------------------------
-- Server version	8.0.21

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fk_client_id` bigint DEFAULT NULL,
  `fk_room_id` bigint DEFAULT NULL,
  `checkIn` date DEFAULT NULL,
  `checkOut` date DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `safebox` tinyint DEFAULT '0',
  `wedge` tinyint DEFAULT '0',
  `laundry` tinyint DEFAULT '0',
  `parking` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_room_id` (`fk_room_id`),
  KEY `fk_client_id` (`fk_client_id`),
  CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`fk_room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`fk_client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastname` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Pablo','Garcia','Garcia@seat.es'),(2,'Oscar','Garcia','OGarcia@seat.com'),(3,'Miguel','de Pablos','mdpablos@seat.com');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logins`
--

DROP TABLE IF EXISTS `logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logins` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fk_client_id` bigint DEFAULT NULL,
  `username` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `password` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `role` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_client_id` (`fk_client_id`),
  UNIQUE KEY `username` (`username`),
  CONSTRAINT `logins_ibfk_1` FOREIGN KEY (`fk_client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logins`
--

LOCK TABLES `logins` WRITE;
/*!40000 ALTER TABLE `logins` DISABLE KEYS */;
INSERT INTO `logins` VALUES (1,1,'Garcia1989','1234','ROLE_CLIENT',1),(2,2,'Oscar2000','1234','ROLE_CLIENT',1),(3,3,'Miguel','1234','ROLE_CLIENT',1);
/*!40000 ALTER TABLE `logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offers` (
  `id` bigint NOT NULL,
  `childrens` int DEFAULT NULL,
  `discountChilds` double DEFAULT NULL,
  `description` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES (1,1,0.03,'You have a 3% discount extra for a child'),(2,2,0.05,'You have a 5% discount extra for two childs'),(3,3,0.07,'You have a 7% discount extra for three childs');
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fk_roomtype_id` bigint DEFAULT NULL,
  `code` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  `pricePerNight` double DEFAULT NULL,
  `image` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `guests` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_roomtype_id` (`fk_roomtype_id`),
  CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`fk_roomtype_id`) REFERENCES `roomtypes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,1,'SU1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum doloribus sed, magnam corrupti sapiente aspernatur dolorum ullam sequi officia dignissimos et neque maiores dolore provident. Illo rem ex labore ut?',300,'room-3.jpg',2),(2,1,'SU2','Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita libero porro incidunt error recusandae possimus necessitatibus iure assumenda suscipit? Ratione!',320,'room-5.jpg',2),(3,1,'SU3','Lorem ipsum dolor sit amet consectetur adipisicing elit. Id dolorum aspernatur suscipit aut rem earum perferendis laboriosam architecto, numquam voluptates officia nulla quam! Praesentium, earum iure cumque veniam perspiciatis id illum culpa ipsum repudiandae molestias eaque minus nostrum, quo ut?',290,'room-3.jpg',2),(4,1,'SU4','Lorem ipsum dolor sit amet consectetur, adipisicing elit. Commodi, necessitatibus facere debitis odit dolor animi laboriosam dolorum facilis eaque nulla illo cupiditate deleniti sit? Ratione reiciendis hic doloribus illum labore laboriosam ut, dolorum inventore est aperiam quis omnis aut architecto.',285,'room-5.jpg',2),(5,2,'IN1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis! Aliquid, modi sint! Molestiae, minima mollitia aliquid velit quidem pariatur vero reprehenderit voluptatibus sunt ex ullam adipisci cupiditate eveniet corporis non dolore laudantium accusantium.',50,'camere-10.jpg',1),(6,2,'IN2','Lorem ipsum dolor, sit amet consectetur adipisicing elit. Optio labore dolor molestiae dolores at voluptates, ad rerum culpa veritatis. Rem adipisci voluptatibus rerum. Aliquam quia recusandae distinctio ut.',65,'room-1.jpg',1),(7,2,'IN3','Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur at tenetur fuga non totam quas sapiente odio ullam. Obcaecati ab eius aliquam qui facilis eligendi ipsa impedit laborum consequuntur ut!',65,'room-1.jpg',1),(8,2,'IN4','Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum quas accusamus nobis illo, autem illum nisi, distinctio corporis dolore reprehenderit nam voluptatum rem? Fugiat, deleniti voluptatum! Minus cupiditate voluptatibus totam beatae ducimus velit obcaecati, mollitia sint illum.',55,'camere-10.jpg',1),(9,3,'FAM1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur, nam pariatur? Minus, praesentium itaque ex quam mollitia dicta obcaecati necessitatibus!',155,'camere-9.jpg',4),(10,3,'FAM2','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fuga reiciendis, veritatis maiores ex numquam voluptatum facere natus a accusamus nesciunt alias nulla tempora quaerat autem laudantium quibusdam quo excepturi velit laboriosam obcaecati qui, optio illo explicabo.',160,'camere-9.jpg',5),(11,4,'LUX1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis iure molestias, recusandae dolorum officiis quia ex architecto, deserunt tempore laudantium quae veritatis provident corrupti nihil sequi delectus dolores quas accusamus.',450,'camere-4.jpg',2),(12,4,'LUX2','Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus iure a quod cum. Voluptatum repellat similique facilis nisi libero corrupti natus repellendus, sit, eaque quis eos ut odit molestias voluptas.',550,'camere-4.jpg',3),(13,4,'LUX3','Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita, sunt laboriosam saepe earum nemo ullam veniam corrupti ratione dolorum eaque, distinctio sed maxime sequi ea provident amet aut optio atque!',500,'camere-4.jpg',2),(14,5,'DOU1','Lorem ipsum dolor, sit amet consectetur adipisicing elit. Optio labore dolor mo...',80,'room-6.jpg',2),(15,5,'DOU2','Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus iure a quod cum. Voluptatum repellat similique facilis nisi libero co',70,'room-4.jpg',2),(16,5,'DOU3','Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis!',85,'room-6.jpg',2),(17,5,'DOU4','Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad id facilis nesciunt animi perferendis!',90,'room-4.jpg',3);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtypes`
--

DROP TABLE IF EXISTS `roomtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomtypes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(300) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtypes`
--

LOCK TABLES `roomtypes` WRITE;
/*!40000 ALTER TABLE `roomtypes` DISABLE KEYS */;
INSERT INTO `roomtypes` VALUES (1,'Suite room','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),(2,'Individual room','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),(3,'Family room','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),(4,'Luxury room','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?'),(5,'Double room','Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vero eum at qui, deserunt repudiandae sint sunt quam accusamus ipsam unde! Aliquid odio doloremque illo perferendis cum eaque magni eius harum?');
/*!40000 ALTER TABLE `roomtypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pom_hotel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-18 21:25:30
