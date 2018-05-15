-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 16-Maio-2018 às 01:08
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `codigoEstado` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`codigoEstado`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`codigoEstado`, `nome`) VALUES
(1, 'Goiás '),
(2, 'São Paulo'),
(3, 'Rio de Janeiro '),
(4, 'Bahia'),
(5, 'Minas Gerais'),
(6, 'Distrito Federal'),
(7, 'Rio Grande do Sul'),
(8, 'Pará'),
(9, 'Acre'),
(10, 'Rio Grande do Norte'),
(11, 'Mato Grosso'),
(12, 'Espirito Santo'),
(13, 'Amapá'),
(14, 'Ceará'),
(15, 'Mato Grosso do Sul'),
(16, 'Alagoas '),
(17, 'Amazonas'),
(18, 'Maranhão'),
(19, 'Paraiba'),
(20, 'Pernambuco'),
(21, 'Piauí'),
(22, 'Rondônia'),
(23, 'Roraima'),
(24, 'Tocantins'),
(25, 'Sergipe'),
(26, 'Santa Catarina');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
