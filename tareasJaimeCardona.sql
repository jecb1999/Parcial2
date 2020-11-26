-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-11-2020 a las 20:50:31
-- Versión del servidor: 10.0.31-MariaDB-0ubuntu0.16.04.2
-- Versión de PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `P09728_1_11`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareasJaimeCardona`
--

CREATE TABLE `tareasJaimeCardona` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `to_do` int(11) DEFAULT NULL,
  `doing` int(11) DEFAULT NULL,
  `done` int(11) DEFAULT NULL,
  `fecha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tareasJaimeCardona`
--

INSERT INTO `tareasJaimeCardona` (`id`, `descripcion`, `to_do`, `doing`, `done`, `fecha`) VALUES
(37, 'Hacer Los Requerimientos', 0, 0, 1, '25/11/2020'),
(38, 'Trabajar En el Front', 0, 0, 1, '25/11/2020'),
(39, 'Trabajar en El Back', 1, 0, 0, '25/11/2020'),
(40, 'Retroalimentacion del Cliente', 0, 1, 0, '25/11/2020'),
(41, 'Pulir', 1, 0, 0, '25/11/2020'),
(42, 'Finalizar Proyecto', 1, 0, 0, '25/11/2020'),
(43, 'Pagar a Los Diseñadores', 1, 0, 0, '25/11/2020'),
(44, 'Contratar Expertos en redes', 1, 0, 0, '25/11/2020');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tareasJaimeCardona`
--
ALTER TABLE `tareasJaimeCardona`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tareasJaimeCardona`
--
ALTER TABLE `tareasJaimeCardona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
