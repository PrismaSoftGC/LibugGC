-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15-Maio-2018 às 19:38
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
-- Estrutura da tabela `obra`
--

CREATE TABLE IF NOT EXISTS `obra` (
  `codigoObra` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `subtitulo` varchar(50) DEFAULT NULL,
  `editora_codigoEditora` int(11) NOT NULL,
  `cidade_codigoCidade` int(11) DEFAULT NULL,
  `edicao` int(11) DEFAULT NULL,
  `ano` date NOT NULL,
  `categoria_codigoCategoria` int(11) NOT NULL,
  `situacao` varchar(12) NOT NULL,
  `status` varchar(12) NOT NULL,
  `codBarras` varchar(50) DEFAULT NULL,
  `qtdEstoqueTotal` int(11) NOT NULL,
  `qtdEstoqueDisponivel` int(11) NOT NULL,
  PRIMARY KEY (`codigoObra`),
  KEY `fk_Obra_Editora_idx` (`editora_codigoEditora`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Extraindo dados da tabela `obra`
--

INSERT INTO `obra` (`codigoObra`, `titulo`, `subtitulo`, `editora_codigoEditora`, `cidade_codigoCidade`, `edicao`, `ano`, `categoria_codigoCategoria`, `situacao`, `status`, `codBarras`, `qtdEstoqueTotal`, `qtdEstoqueDisponivel`) VALUES
(24, 'DOM CASMURRO', NULL, 14, NULL, 1, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(25, 'A ROSA DO POVO', NULL, 12, NULL, 3, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(26, 'CAPITAES DA AREIA', NULL, 13, NULL, 4, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(27, 'COMPILADORES', NULL, 13, NULL, 1, '0000-00-00', 0, 'Prateleira', 'Ativado', NULL, 0, 0),
(28, 'CADILACKES', NULL, 12, NULL, 4, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(29, 'a culpa', NULL, 12, NULL, 5, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(30, 'A CRUZ PERDIDA', NULL, 14, NULL, 1, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(31, 'o poeta', NULL, 12, NULL, 877, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0),
(32, 'HARRY POTTER', NULL, 12, NULL, 5, '0000-00-00', 0, 'Emprestado', 'Ativado', NULL, 0, 0);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `fk_Obra_Editora` FOREIGN KEY (`editora_codigoEditora`) REFERENCES `editora` (`codigoEditora`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
