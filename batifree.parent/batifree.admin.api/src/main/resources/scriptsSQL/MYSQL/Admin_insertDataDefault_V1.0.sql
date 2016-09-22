-- phpMyAdmin SQL Dump
-- version 3.4.3.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le : Jeu 08 Août 2013 à 02:00
-- Version du serveur: 5.5.15
-- Version de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `batifreeadmin`
--

--
-- Contenu de la table `connectiondb`
--

INSERT INTO `CONNECTIONDB` (`CON_ID`, `CON_DRIVER`, `CON_URL`, `CON_DIALECT`, `CON_LIMIT_USER_ALERT`, `CON_ROOT_LOGIN`, `CON_ROOT_PASSWORD`, `CON_ROOT_DBNAME`, `CON_ENABLED`) VALUES
(1, 'com.mysql.jdbc.Driver', 'jdbc:mysql://192.168.9.17:3306/', 'org.hibernate.dialect.MySQLDialect', 1, 'root', 'rootBF', 'batifreeadmin', 1),
(2, 'com.mysql.jdbc.Driver', 'jdbc:mysql://192.168.9.17:3306/', 'org.hibernate.dialect.MySQLDialect', 2, 'root', 'rootBF', 'batifreeadmin', 0);

--
-- Contenu de la table `project`
--

INSERT INTO `PROJECT` (`PRO_ID`, `PRO_NAME`, `PRO_CODE`) VALUES
(1, 'Batifree', 'BF'),
(2, 'Compta', 'COMPTA');

--
-- Contenu de la table `projectscript`
--

INSERT INTO `PROJECTSCRIPT` (`PSR_ID`, `PRO_ID`, `PSR_FILE_NAME`) VALUES
(1, 1, '/usr/share/apache-tomcat-8.0.11/tomcat/.jenkins/workspace/Package/batifree.api2/src/main/resources/scriptsSQL/MYSQL/Batifree_crebas_V1.0.sql'),
(2, 2, '/usr/share/apache-tomcat-8.0.11/tomcat/.jenkins/workspace/Package/batifree.api2/src/main/resources/scriptsSQL/MYSQL/Batifree_crebas_V1.0.sql');

--
-- Contenu de la table `role`
--

INSERT INTO `ROLE` (`ROL_ID`, `PRO_ID`, `ROL_CODE`) VALUES
(1, 1, 'ROLE_USER'),
(2, 2, 'ROLE_USER');

--
-- Contenu de la table `userappli`
--

INSERT INTO `USERAPPLI` (`USE_ID`, `USE_USERNAME`, `USE_PASSWORD`, `USE_MAIL`, `USE_DATE_CREATE`, `USE_DATE_EXPIRED`, `USE_LOCKED`) VALUES
(16, 'u1', 'ec6ef230f1828039ee794566b9c58adc', 'kero31@gmail.com', '2013-08-08 01:56:30', '2023-08-08 01:56:29', 0);

--
-- Contenu de la table `userproject`
--

INSERT INTO `USERPROJECT` (`PRO_ID`, `USE_ID`, `PSR_ID`, `CON_ID`, `USP_BD_LOGIN`, `USP_BD_PASSWORD`, `USP_BD_DBNAME`) VALUES
(1, 16, 1, 1, '16_BF', '16_BF', 'BF');

--
-- Contenu de la table `userrole`
--

INSERT INTO `USERROLE` (`ROL_ID`, `USE_ID`) VALUES
(1, 16);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
