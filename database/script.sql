-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: 192.168.99.100    Database: fiap_online_school
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cargaHoraria` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `sobre` text NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `id_escola` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_27gbelf6red3fu97u2hwv2y9a` (`uuid`),
  KEY `FK_3cs8ss4ho28dte7x6widj6r2w` (`id_escola`),
  CONSTRAINT `FK_3cs8ss4ho28dte7x6widj6r2w` FOREIGN KEY (`id_escola`) REFERENCES `escola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,300,'MBA em Desenvolvimento de Aplicações Java SOA e Internet das Coisas','Curso criado automaticamente para ser usado como demostração.','1e49cd77-5cb6-4984-bf87-d5dcf0c32a86',1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `conteudoProgramatico` text NOT NULL,
  `nome` varchar(80) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `id_curso` bigint(20) NOT NULL,
  `id_professor` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h9h823mt4db7i5ukruv3ego41` (`uuid`),
  KEY `FK_na39k2hubw8cbjhqahgtv7q7i` (`id_curso`),
  KEY `FK_20279jdho688ibee0muf6v5d9` (`id_professor`),
  CONSTRAINT `FK_20279jdho688ibee0muf6v5d9` FOREIGN KEY (`id_professor`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_na39k2hubw8cbjhqahgtv7q7i` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'- JSP / Servlets\n- Spring MVC\n- JSF\n- Primefaces JSTL','Java na WEB','f5c30feb-7e7b-4fe8-bbed-2d2a804de0ca',1,3),(2,'- Hibernate\n- TopLink\n- JPA\n- JDBC','Persistência em Java (JDBC e JPA)','556522d1-e92c-4103-a376-8d4b08bb1bd4',1,3);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola`
--

DROP TABLE IF EXISTS `escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escola` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `observacao` text,
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1hap0m0tfyqmq5ecf54xg2ho7` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (1,'Escola Demonstração','Escola criada automaticamente para ser usada como demostração.','2c543b57-9bcd-40b5-a34c-25be4101eb8a');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logger`
--

DROP TABLE IF EXISTS `logger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataEvento` datetime NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `ip` varchar(255) NOT NULL,
  `metodo` varchar(255) NOT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qlyfojouj7hjpxawk6eq62qy8` (`uuid`),
  KEY `FK_q97dx5vdp8w49bkc96ulfnht8` (`id_usuario`),
  CONSTRAINT `FK_q97dx5vdp8w49bkc96ulfnht8` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logger`
--

LOCK TABLES `logger` WRITE;
/*!40000 ALTER TABLE `logger` DISABLE KEYS */;
/*!40000 ALTER TABLE `logger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cancelamentoEm` datetime DEFAULT NULL,
  `codigo` varchar(255) NOT NULL,
  `matriculadoEm` datetime DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `id_aluno` bigint(20) NOT NULL,
  `id_curso` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_evqwmn7ubvlw539jqcotegco6` (`id_curso`,`id_aluno`),
  UNIQUE KEY `UK_enw3fxcpwv1uxfclibh32de0s` (`codigo`),
  UNIQUE KEY `UK_ryebf32pjanptlm53r3cosqew` (`uuid`),
  KEY `FK_s7lj4xhe2wig1qwgdcetmcvc9` (`id_aluno`),
  CONSTRAINT `FK_6oklx67ann9160y4h09vywm4w` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `FK_s7lj4xhe2wig1qwgdcetmcvc9` FOREIGN KEY (`id_aluno`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,NULL,'1701142155202','2017-01-14 21:55:13','c4893390-5a84-4047-91e0-47e1932343b2',2,1);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `atividadePratica` decimal(4,2) DEFAULT NULL,
  `projeto1` decimal(4,2) DEFAULT NULL,
  `projeto2` decimal(4,2) DEFAULT NULL,
  `id_disciplina` bigint(20) NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e98i3uh32eg9pvilcwpox7jxl` (`id_usuario`,`id_disciplina`),
  KEY `FK_qt733gdt5yq8dgh24dbyomi7l` (`id_disciplina`),
  CONSTRAINT `FK_7l49w9mlloebw8401wcqifhro` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_qt733gdt5yq8dgh24dbyomi7l` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin` bit(1) NOT NULL,
  `email` varchar(120) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `senha` varchar(120) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  UNIQUE KEY `UK_l8q1tlaiyb03eemicl6qgvddu` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'','admin@fiap.com.br','admin','$2a$12$bfyvMuY89YZJn6zCZ64kAe0V/2Vw1P4FFjZ55rKBm3tG7oYPXWFAe','5172e06d-c112-486e-ac21-6fbeb5b42f80'),(2,'\0','aluno@fiap.com.br','Diego Saouda','$2a$12$5EsIVXoqX5BUYUJOhsw4H.seN0aXTVPzUubC/Ycjbi/4NW.F5OOB2','8312082b-2e87-4d92-b02c-beaea415d73a'),(3,'\0','professor@fiap.com.br','Celso','$2a$12$nt6whZ78oEbeGCK7L5rPHOWPwyZgfncTCLE8XGbMAQgWzNHrFmVFe','b85f9e3a-e409-44cb-96c7-2f7b56dfdeed');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-14 23:55:52
