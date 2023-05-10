-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 09, 2023 at 12:21 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pronosticos_pron_deportivos`
--

-- --------------------------------------------------------

--
-- Table structure for table `pronostico_separador_coma`
--

CREATE TABLE `pronostico_separador_coma` (
  `Participante - id` int(1) DEFAULT NULL,
  `Participante - nombre` varchar(54) DEFAULT NULL,
  `Fase - id` int(1) DEFAULT NULL,
  `Fase - nombre` varchar(7) DEFAULT NULL,
  `Ronda - id` int(1) DEFAULT NULL,
  `Ronda - nro` int(1) DEFAULT NULL,
  `Equipo 1 - id` int(1) DEFAULT NULL,
  `Gana 1` varchar(1) DEFAULT NULL,
  `Empata` varchar(1) DEFAULT NULL,
  `Gana 2` varchar(1) DEFAULT NULL,
  `Equipo 2 - id` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `pronostico_separador_coma`
--

INSERT INTO `pronostico_separador_coma` (`Participante - id`, `Participante - nombre`, `Fase - id`, `Fase - nombre`, `Ronda - id`, `Ronda - nro`, `Equipo 1 - id`, `Gana 1`, `Empata`, `Gana 2`, `Equipo 2 - id`) VALUES
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 1, 1, 1, 'X', '', '', 2),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 1, 1, 3, '', 'X', '', 4),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 1, 1, 1, 'X', '', '', 4),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 1, 1, 2, '', '', 'X', 3),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 2, 2, 1, '', '', 'X', 5),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 2, 2, 6, '', 'X', '', 7),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 2, 2, 1, 'X', '', '', 7),
(1, 'X acierta todos en cada ronda menos uno (hay 2 rondas)', 1, 'Inicial', 2, 2, 5, 'X', '', '', 6),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 1, 1, 1, '', '', 'X', 2),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 1, 1, 3, '', 'X', '', 4),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 1, 1, 1, 'X', '', '', 4),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 1, 1, 2, '', '', 'X', 3),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 2, 2, 1, 'X', '', '', 5),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 2, 2, 6, '', 'X', '', 7),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 2, 2, 1, 'X', '', '', 7),
(2, 'X acierta todos en cada ronda (hay 2 rondas)', 1, 'Inicial', 2, 2, 5, 'X', '', '', 6),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 1, 1, 1, 'X', '', '', 2),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 1, 1, 3, '', 'X', '', 4),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 1, 1, 1, 'X', '', '', 4),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 1, 1, 2, '', '', 'X', 3),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 2, 2, 1, 'X', '', '', 5),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 2, 2, 6, '', 'X', '', 7),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 2, 2, 1, 'X', '', '', 7),
(3, 'Y acierta todos en una FASE menos uno', 1, 'Inicial', 2, 2, 5, 'X', '', '', 6),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 1, 1, 1, '', '', 'X', 2),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 1, 1, 3, '', 'X', '', 4),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 1, 1, 1, 'X', '', '', 4),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 1, 1, 2, '', '', 'X', 3),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 2, 2, 1, 'X', '', '', 5),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 2, 2, 6, '', 'X', '', 7),
(4, 'Y acierta todos en una FASE', 1, 'Inicial', 2, 2, 1, 'X', '', '', 7),
(4, 'X acierta todos en una FASE', 1, 'Inicial', 2, 2, 5, 'X', '', '', 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
