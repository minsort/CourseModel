-- MariaDB dump 10.19  Distrib 10.5.12-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: forTest
-- ------------------------------------------------------
-- Server version	10.5.12-MariaDB-1

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
-- Sequence structure for `hibernate_sequence`
--

DROP SEQUENCE IF EXISTS `hibernate_sequence`;
CREATE SEQUENCE `hibernate_sequence` start with 1 minvalue 1 maxvalue 9223372036854775806 increment by 1 cache 1000 nocycle ENGINE=InnoDB;
SELECT SETVAL(`hibernate_sequence`, 1, 0);

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `name` varchar(255) NOT NULL,
  `cost` float NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `course_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('Chemistry',3300,1),('Geometriya',4000,2),('Informatics',5000,2);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursecompletion`
--

DROP TABLE IF EXISTS `coursecompletion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursecompletion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `coursecompletion_id_uindex` (`id`),
  KEY `FK7gq7cf41mm2iwkua6oj5jd6dv` (`score`),
  KEY `coursecompletion_students_name_fk` (`student_name`),
  KEY `coursecompletion_course_name_fk` (`course_name`),
  CONSTRAINT `coursecompletion_course_name_fk` FOREIGN KEY (`course_name`) REFERENCES `course` (`name`),
  CONSTRAINT `coursecompletion_students_name_fk` FOREIGN KEY (`student_name`) REFERENCES `students` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursecompletion`
--

LOCK TABLES `coursecompletion` WRITE;
/*!40000 ALTER TABLE `coursecompletion` DISABLE KEYS */;
INSERT INTO `coursecompletion` VALUES (1,5,'Chemistry','Anton');
/*!40000 ALTER TABLE `coursecompletion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prof_course`
--

DROP TABLE IF EXISTS `prof_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prof_course` (
  `id` int(11) NOT NULL,
  `professor_name` varchar(20) DEFAULT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prof_course_professors_name_fk` (`professor_name`),
  KEY `prof_course_course_name_fk` (`course_name`),
  CONSTRAINT `prof_course_course_name_fk` FOREIGN KEY (`course_name`) REFERENCES `course` (`name`),
  CONSTRAINT `prof_course_professors_name_fk` FOREIGN KEY (`professor_name`) REFERENCES `professors` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prof_course`
--

LOCK TABLES `prof_course` WRITE;
/*!40000 ALTER TABLE `prof_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `prof_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professors`
--

DROP TABLE IF EXISTS `professors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professors` (
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `pay` float DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `professors_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professors`
--

LOCK TABLES `professors` WRITE;
/*!40000 ALTER TABLE `professors` DISABLE KEYS */;
INSERT INTO `professors` VALUES ('Selaev','jjnjnjnj',3500,'99090909');
/*!40000 ALTER TABLE `professors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud_course`
--

DROP TABLE IF EXISTS `stud_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud_course` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `students_name` varchar(20) DEFAULT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stud_course_students_name_fk` (`students_name`),
  KEY `stud_course_course_name_fk` (`course_name`),
  CONSTRAINT `stud_course_course_name_fk` FOREIGN KEY (`course_name`) REFERENCES `course` (`name`),
  CONSTRAINT `stud_course_students_name_fk` FOREIGN KEY (`students_name`) REFERENCES `students` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_course`
--

LOCK TABLES `stud_course` WRITE;
/*!40000 ALTER TABLE `stud_course` DISABLE KEYS */;
INSERT INTO `stud_course` VALUES (5,'John','Informatics'),(8,'John','Chemistry'),(10,'Mark','Informatics');
/*!40000 ALTER TABLE `stud_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `number_phone` varchar(255) DEFAULT NULL,
  `student_performance` float DEFAULT NULL,
  `record_book` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `id` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `students_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('Anton','min@xx.ru','9999999',2.5,124,'Sergdcvey',20),('John','zz@mm.ru','7777777',3.2,345,'klnnjnj',21),('Artur','art@gmail.ry','677777',3.2,347,'fsgfgfgs',22),('Mark','mark@l.ru','55445454',5.7,233,'ererere',23);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-08 15:52:31
