-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-03-2019 a las 04:03:59
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estacionamientov2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacionamiento`
--

CREATE TABLE `estacionamiento` (
  `patente` varchar(10) NOT NULL,
  `propietario` varchar(20) NOT NULL,
  `fechaIngreso` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fechaSalida` datetime DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `idPersona` int(11) NOT NULL,
  `idTipoVehiculo` int(11) DEFAULT NULL,
  `idPuesto` int(11) NOT NULL,
  `numeroTicket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estacionamiento`
--

INSERT INTO `estacionamiento` (`patente`, `propietario`, `fechaIngreso`, `fechaSalida`, `importe`, `idPersona`, `idTipoVehiculo`, `idPuesto`, `numeroTicket`) VALUES
('OXQ128', 'ROMINA MARTINEZ', '2019-03-16 18:11:56', '2019-03-21 00:00:32', 1000, 1, 1, 1, 1),
('YHU123', 'JONY QUEST', '2019-03-20 21:55:23', '2019-03-20 23:59:53', 40, 1, 1, 4, 3),
('OPX736', 'OSCAR JOFRE', '2019-03-19 21:55:48', '2019-03-21 00:00:06', 280, 1, 1, 1, 4),
('JKU123', 'SERGIO DIAZ', '2019-03-20 14:02:04', '2019-03-25 23:07:54', 1280, 1, 1, 1, 5),
('UED098', 'PABLO JORDAN', '2019-03-20 15:02:21', '2019-03-21 00:31:38', 100, 1, 2, 2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE `perfil` (
  `nombrePerfil` varchar(20) NOT NULL,
  `idPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`nombrePerfil`, `idPerfil`) VALUES
('admin', 1),
('administrativo', 2),
('operario', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `nombrePersona` varchar(30) NOT NULL,
  `dniPersona` double NOT NULL,
  `direccionPersona` varchar(50) NOT NULL,
  `telefonoPersona` double NOT NULL,
  `idPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`nombrePersona`, `dniPersona`, `direccionPersona`, `telefonoPersona`, `idPersona`) VALUES
('Marnia Carrizo', 123333444, 'Rio Negro s/n - Gllen', 303456, 1),
('Victor perez', 355521124, 'roma 3546', 2615060480, 2),
('Martinez Romina', 3566231, 'Bebedero 1234 - Rodeo de la Cruz', 2616122732, 4),
('Benjamin Perez', 55000222, 'Roma 3456 - Guaymallen', 4502582, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE `puesto` (
  `numPuesto` varchar(255) NOT NULL,
  `estadoPuesto` tinyint(1) NOT NULL DEFAULT '0',
  `idPuesto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`numPuesto`, `estadoPuesto`, `idPuesto`) VALUES
('P-1', 0, 1),
('P-2', 0, 2),
('P-3', 0, 3),
('P-4', 0, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipovehiculo`
--

CREATE TABLE `tipovehiculo` (
  `tipoVehiculo` varchar(10) NOT NULL,
  `idTipoVehiculo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipovehiculo`
--

INSERT INTO `tipovehiculo` (`tipoVehiculo`, `idTipoVehiculo`) VALUES
('auto', 1),
('camioneta', 2),
('moto', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `nombreTurno` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `idTurno` int(11) NOT NULL,
  `idTipoVehiculo` int(11) NOT NULL,
  `inicio` time NOT NULL DEFAULT '00:00:00',
  `fin` time NOT NULL DEFAULT '00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`nombreTurno`, `precio`, `idTurno`, `idTipoVehiculo`, `inicio`, `fin`) VALUES
('DIA', 40, 1, 1, '07:00:00', '19:00:00'),
('NOCHE', 50, 2, 1, '19:00:00', '23:59:59'),
('DIA', 50, 3, 2, '07:00:00', '19:00:00'),
('NOCHE', 60, 4, 2, '19:00:00', '23:59:59'),
('DIA', 30, 5, 3, '07:00:00', '19:00:00'),
('NOCHE', 35, 6, 3, '19:00:00', '23:59:59');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombreUsuario` varchar(20) NOT NULL,
  `contrasenia` varchar(10) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombreUsuario`, `contrasenia`, `idPerfil`, `idPersona`) VALUES
('marina', '1234', 1, 1),
('vperez', 'abcd', 2, 2),
('rmartinez', 'qwerty', 3, 4),
('bperez', '', 1, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estacionamiento`
--
ALTER TABLE `estacionamiento`
  ADD PRIMARY KEY (`numeroTicket`),
  ADD KEY `FK_Estacionamiento` (`idPersona`),
  ADD KEY `FK_tarifaEstacionamiento` (`idTipoVehiculo`),
  ADD KEY `FK_puesto` (`idPuesto`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`idPerfil`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `puesto`
--
ALTER TABLE `puesto`
  ADD PRIMARY KEY (`idPuesto`);

--
-- Indices de la tabla `tipovehiculo`
--
ALTER TABLE `tipovehiculo`
  ADD PRIMARY KEY (`idTipoVehiculo`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`idTurno`),
  ADD KEY `FK_Turno` (`idTipoVehiculo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idPersona`),
  ADD KEY `FK_perfil` (`idPerfil`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estacionamiento`
--
ALTER TABLE `estacionamiento`
  MODIFY `numeroTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `idPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `puesto`
--
ALTER TABLE `puesto`
  MODIFY `idPuesto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipovehiculo`
--
ALTER TABLE `tipovehiculo`
  MODIFY `idTipoVehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `idTurno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estacionamiento`
--
ALTER TABLE `estacionamiento`
  ADD CONSTRAINT `FK_Estacionamiento` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  ADD CONSTRAINT `FK_puesto` FOREIGN KEY (`idPuesto`) REFERENCES `puesto` (`idPuesto`),
  ADD CONSTRAINT `FK_tarifaEstacionamiento` FOREIGN KEY (`idTipoVehiculo`) REFERENCES `tipovehiculo` (`idTipoVehiculo`);

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `FK_Turno` FOREIGN KEY (`idTipoVehiculo`) REFERENCES `tipovehiculo` (`idTipoVehiculo`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_Usuario` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  ADD CONSTRAINT `FK_perfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
