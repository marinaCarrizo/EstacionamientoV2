/*
SQLyog Ultimate v8.61 
MySQL - 5.6.34-log : Database - estacionamientov2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`estacionamientov2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `estacionamientov2`;

/*Table structure for table `estacionamiento` */

DROP TABLE IF EXISTS `estacionamiento`;

CREATE TABLE `estacionamiento` (
  `patente` varchar(10) NOT NULL,
  `propietario` varchar(20) NOT NULL,
  `fechaIngreso` datetime NOT NULL,
  `fechaSalida` datetime DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `idPersona` int(11) NOT NULL,
  `idTarifaVehiculo` int(11) DEFAULT NULL,
  `idPuesto` int(11) NOT NULL,
  `idIngreso` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idIngreso`),
  KEY `FK_Estacionamiento` (`idPersona`),
  KEY `FK_tarifaEstacionamiento` (`idTarifaVehiculo`),
  KEY `FK_puesto` (`idPuesto`),
  CONSTRAINT `FK_Estacionamiento` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `FK_puesto` FOREIGN KEY (`idPuesto`) REFERENCES `puesto` (`idPuesto`),
  CONSTRAINT `FK_tarifaEstacionamiento` FOREIGN KEY (`idTarifaVehiculo`) REFERENCES `tarifavehiculo` (`idTarifaVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estacionamiento` */

/*Table structure for table `perfil` */

DROP TABLE IF EXISTS `perfil`;

CREATE TABLE `perfil` (
  `nombrePerfil` varchar(20) NOT NULL,
  `idPerfil` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `perfil` */

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `nombrePersona` varchar(30) NOT NULL,
  `dniPersona` double NOT NULL,
  `direccionPersona` varchar(50) NOT NULL,
  `telefonoPersona` double NOT NULL,
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `persona` */

/*Table structure for table `puesto` */

DROP TABLE IF EXISTS `puesto`;

CREATE TABLE `puesto` (
  `numPuesto` int(11) NOT NULL,
  `estadoPuesto` tinyint(1) NOT NULL,
  `idPuesto` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `puesto` */

/*Table structure for table `tarifavehiculo` */

DROP TABLE IF EXISTS `tarifavehiculo`;

CREATE TABLE `tarifavehiculo` (
  `tipoVehiculo` varchar(10) NOT NULL,
  `idTarifaVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idTarifaVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tarifavehiculo` */

/*Table structure for table `turno` */

DROP TABLE IF EXISTS `turno`;

CREATE TABLE `turno` (
  `nombreTurno` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `idTurno` int(11) NOT NULL AUTO_INCREMENT,
  `idTarifaVehiculo` int(11) NOT NULL,
  PRIMARY KEY (`idTurno`),
  KEY `FK_Turno` (`idTarifaVehiculo`),
  CONSTRAINT `FK_Turno` FOREIGN KEY (`idTarifaVehiculo`) REFERENCES `tarifavehiculo` (`idTarifaVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `turno` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `nombreUsuario` varchar(20) NOT NULL,
  `contrasenia` varchar(10) NOT NULL,
  `idPerfilUsuario` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUsuario`),
  KEY `FK_perfil` (`idPerfilUsuario`),
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `FK_perfil` FOREIGN KEY (`idPerfilUsuario`) REFERENCES `perfil` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
