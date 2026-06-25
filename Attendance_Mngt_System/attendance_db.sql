-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: attendance_db
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `status` enum('present','absent','late') NOT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,1,1,'2026-04-29','present'),(2,1,2,'2026-04-29','absent'),(3,2,2,'2026-04-29','present'),(4,1,1,'2026-05-04','present'),(5,3,1,'2026-05-04','absent'),(6,1,1,'2026-05-04','present'),(7,3,1,'2026-05-04','absent'),(8,1,1,'2026-07-06','present'),(9,3,1,'2026-07-06','late'),(10,7,5,'2026-07-06','present'),(11,9,5,'2026-07-06','absent'),(12,4,5,'2026-07-06','late'),(13,7,5,'2026-07-06','present'),(14,9,5,'2026-07-06','absent'),(15,2,3,'2026-04-06','present'),(16,2,3,'2026-04-13','present'),(17,5,3,'2026-04-06','present'),(18,5,3,'2026-04-13','present'),(19,8,3,'2026-04-06','present'),(20,8,3,'2026-04-13','present'),(21,10,3,'2026-04-06','present'),(22,2,3,'2026-04-06','present'),(23,2,3,'2026-04-13','present'),(24,2,3,'2026-04-20','late'),(25,2,3,'2026-04-27','present'),(26,5,3,'2026-04-06','present'),(27,5,3,'2026-04-13','present'),(28,5,3,'2026-04-20','absent'),(29,5,3,'2026-04-27','present'),(30,8,3,'2026-04-06','present'),(31,8,3,'2026-04-13','present'),(32,8,3,'2026-04-20','present'),(33,8,3,'2026-04-27','present'),(34,10,3,'2026-04-06','present'),(35,10,3,'2026-04-13','present'),(36,10,3,'2026-04-20','late'),(37,10,3,'2026-04-27','absent'),(38,2,3,'2026-04-06','present'),(39,2,3,'2026-04-13','present'),(40,2,3,'2026-04-20','late'),(41,2,3,'2026-04-27','present'),(42,5,3,'2026-04-06','present'),(43,5,3,'2026-04-13','present'),(44,5,3,'2026-04-20','absent'),(45,5,3,'2026-04-27','present'),(46,8,3,'2026-04-06','present'),(47,8,3,'2026-04-13','present'),(48,8,3,'2026-04-20','present'),(49,8,3,'2026-04-27','present'),(50,10,3,'2026-04-06','present'),(51,10,3,'2026-04-13','present'),(52,10,3,'2026-04-20','late'),(53,10,3,'2026-04-27','absent'),(54,2,3,'2026-05-04','present'),(55,2,3,'2026-05-11','late'),(56,2,3,'2026-05-18','present'),(57,2,3,'2026-05-25','present'),(58,5,3,'2026-05-04','present'),(59,5,3,'2026-05-11','present'),(60,5,3,'2026-05-18','present'),(61,5,3,'2026-05-25','late'),(62,8,3,'2026-05-04','present'),(63,8,3,'2026-05-11','present'),(64,8,3,'2026-05-18','present'),(65,8,3,'2026-05-25','absent'),(66,10,3,'2026-05-04','absent'),(67,10,3,'2026-05-11','late'),(68,10,3,'2026-05-18','present'),(69,10,3,'2026-05-25','late'),(70,2,3,'2026-06-01','present'),(71,2,3,'2026-06-08','present'),(72,2,3,'2026-06-15','late'),(73,5,3,'2026-06-01','absent'),(74,5,3,'2026-06-08','present'),(75,5,3,'2026-06-15','absent'),(76,8,3,'2026-06-01','present'),(77,8,3,'2026-06-08','present'),(78,8,3,'2026-06-15','present'),(79,10,3,'2026-06-01','present'),(80,10,3,'2026-06-08','late'),(81,10,3,'2026-06-15','present'),(82,2,3,'2026-06-22','present'),(83,5,3,'2026-06-22','present'),(84,8,3,'2026-06-22','present'),(85,10,3,'2026-06-22','present'),(86,4,5,'2026-04-06','present'),(87,4,5,'2026-04-13','present'),(88,4,5,'2026-04-20','absent'),(89,4,5,'2026-04-27','present'),(90,7,5,'2026-04-06','late'),(91,7,5,'2026-04-13','present'),(92,7,5,'2026-04-20','present'),(93,7,5,'2026-04-27','present'),(94,9,5,'2026-04-06','present'),(95,9,5,'2026-04-13','present'),(96,9,5,'2026-04-20','late'),(97,9,5,'2026-04-27','present'),(98,4,5,'2026-05-04','present'),(99,4,5,'2026-05-11','present'),(100,4,5,'2026-05-18','present'),(101,7,5,'2026-05-04','absent'),(102,7,5,'2026-05-11','present'),(103,7,5,'2026-05-18','present'),(104,7,5,'2026-05-25','present'),(105,9,5,'2026-05-04','present'),(106,9,5,'2026-05-11','present'),(107,9,5,'2026-05-18','absent'),(108,9,5,'2026-05-25','present'),(109,4,5,'2026-05-25','late'),(110,4,5,'2026-06-01','present'),(111,4,5,'2026-06-08','late'),(112,4,5,'2026-06-15','late'),(113,4,5,'2026-06-22','present'),(114,7,5,'2026-06-01','present'),(115,7,5,'2026-06-08','present'),(116,7,5,'2026-06-15','present'),(117,7,5,'2026-06-22','present'),(118,9,5,'2026-06-01','present'),(119,9,5,'2026-06-08','present'),(120,9,5,'2026-06-15','late'),(121,9,5,'2026-06-22','late');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL,
  `lecturer_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `lecturer_id` (`lecturer_id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`lecturer_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Database Systems',2),(2,'Software Engineering',3),(3,'Computer Networks',2),(4,'Artificial Intelligence',3),(5,'Web Development',2);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_courses`
--

DROP TABLE IF EXISTS `student_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_courses` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `student_courses_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `student_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_courses`
--

LOCK TABLES `student_courses` WRITE;
/*!40000 ALTER TABLE `student_courses` DISABLE KEYS */;
INSERT INTO `student_courses` VALUES (1,1),(1,2),(2,2),(2,3),(3,1),(3,4),(4,5),(5,3),(5,4),(6,2),(7,1),(7,5),(8,3),(9,4),(9,5),(10,2),(10,3);
/*!40000 ALTER TABLE `student_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Alice Johnson'),(2,'Bob Smith'),(3,'Clara Niyonzima'),(4,'David Kamau'),(5,'Esther Uwimana'),(6,'Frank Habonimana'),(7,'Grace Mukamana'),(8,'Henry Ndayishimiye'),(9,'Irene Uwase'),(10,'Jonas Hakizimana');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','member') NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin1','System Administrator','adminpass','admin'),(2,'lecturer1','Dr. Alice Nkurunziza','lectpass1','member'),(3,'lecturer2','Prof. Bob Habimana','lectpass2','member'),(4,'lecturer3','Dr. Clara Uwase','lectpass3','member'),(5,'lecturer4','Prof. David Kamau','lectpass4','member'),(6,'lecturer5','Dr. Esther Uwimana','lectpass5','member');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-25  5:06:04
