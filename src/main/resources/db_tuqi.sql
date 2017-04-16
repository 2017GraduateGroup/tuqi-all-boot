-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: db_tuqi
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `daily_record`
--

DROP TABLE IF EXISTS `daily_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_record` (
  `recordId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `title` varchar(45) DEFAULT NULL COMMENT '日志标题',
  `content` longtext COMMENT '日志内容',
  `status` varchar(5) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `user_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`recordId`,`user_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_record`
--

LOCK TABLES `daily_record` WRITE;
/*!40000 ALTER TABLE `daily_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program_type`
--

DROP TABLE IF EXISTS `program_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program_type` (
  `prog_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `prog_type_name` varchar(45) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`prog_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_type`
--

LOCK TABLES `program_type` WRITE;
/*!40000 ALTER TABLE `program_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `program_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programme`
--

DROP TABLE IF EXISTS `programme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programme` (
  `programmeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程编号',
  `content` text,
  `status` varchar(5) NOT NULL COMMENT '状态：1-存在 0-删除',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `programme_time` datetime DEFAULT NULL COMMENT '事件发生时间',
  `program_user_id` bigint(20) NOT NULL COMMENT '用户规划',
  `program_type_id` int(11) NOT NULL COMMENT '日程类型:1-普通 2-出行 3-会议 4-约会 5-纪念日 6-其他',
  PRIMARY KEY (`programmeId`),
  KEY `fk_programme_user_idx` (`program_user_id`),
  KEY `fk_programme_program_type1_idx` (`program_type_id`),
  CONSTRAINT `fk_programme_program_type1` FOREIGN KEY (`program_type_id`) REFERENCES `program_type` (`prog_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_programme_user` FOREIGN KEY (`program_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programme`
--

LOCK TABLES `programme` WRITE;
/*!40000 ALTER TABLE `programme` DISABLE KEYS */;
/*!40000 ALTER TABLE `programme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(45) NOT NULL COMMENT '用户名',
  `user_nick_name` varchar(45) DEFAULT NULL,
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `user_position_id` int(11) NOT NULL COMMENT '用户职业',
  PRIMARY KEY (`user_id`),
  KEY `fk_user_user_position1_idx` (`user_position_id`),
  CONSTRAINT `fk_user_user_position1` FOREIGN KEY (`user_position_id`) REFERENCES `user_position` (`position_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'森森','Karry','96e79218965eb72c92a549dd5a330112','2017-04-14 16:22:30','2017-04-14 16:22:30',1),(2,'林林','Duke','96e79218965eb72c92a549dd5a330112','2017-04-14 16:24:16','2017-04-14 16:24:16',1),(3,'伊泽瑞尔','EZ','96e79218965eb72c92a549dd5a330112','2017-04-14 16:39:11','2017-04-14 16:39:11',5),(4,'内瑟斯','狗头','202cb962ac59075b964b07152d234b70','2017-04-14 16:42:42','2017-04-14 16:42:42',7),(5,'内瑟斯','狗头','202cb962ac59075b964b07152d234b70','2017-04-14 16:48:46','2017-04-14 16:48:46',7),(6,'艾希','寒冰','698d51a19d8a121ce581499d7b701668','2017-04-14 17:07:18','2017-04-14 17:07:18',7);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_position`
--

DROP TABLE IF EXISTS `user_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_position` (
  `position_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职业编号',
  `position_name` varchar(45) DEFAULT NULL COMMENT '职业名称',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_position`
--

LOCK TABLES `user_position` WRITE;
/*!40000 ALTER TABLE `user_position` DISABLE KEYS */;
INSERT INTO `user_position` VALUES (1,'学生',NULL,NULL),(2,'律师',NULL,NULL),(3,'警察',NULL,NULL),(4,'医生',NULL,NULL),(5,'设计师',NULL,NULL),(6,'教师',NULL,NULL),(7,'自由职业者',NULL,NULL),(8,'其他职业',NULL,NULL);
/*!40000 ALTER TABLE `user_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_tuqi'
--

--
-- Dumping routines for database 'db_tuqi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-16 12:26:26
