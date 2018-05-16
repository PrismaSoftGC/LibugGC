-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16-Maio-2018 às 13:09
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca`
--
CREATE DATABASE IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `biblioteca`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `autor`
--

CREATE TABLE `autor` (
  `codigoAutor` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `autor`
--

INSERT INTO `autor` (`codigoAutor`, `nome`, `status`) VALUES
(22, 'MACHADO DE ASSIS', 'Ativado'),
(23, 'CARLOS DRUMOMOND', 'Ativado'),
(24, 'JORGE AMADO', 'Ativado'),
(25, 'GUIMARAES ', 'Ativado'),
(26, 'CLARISSE LIS', 'Ativado'),
(27, 'ADEJAR', 'Ativado'),
(28, 'ADEJAIR', 'Desativado'),
(29, 'ANDRE', 'Ativado'),
(30, 'jamel da silva', 'Ativado'),
(31, 'MARIA BARBOSA', 'Ativado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `aux_autor_obra`
--

CREATE TABLE `aux_autor_obra` (
  `codigoAutor` int(11) NOT NULL,
  `codigoObra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aux_autor_obra`
--

INSERT INTO `aux_autor_obra` (`codigoAutor`, `codigoObra`) VALUES
(22, 24),
(26, 24),
(29, 27),
(25, 28),
(23, 25),
(26, 29),
(29, 29),
(24, 26),
(27, 26),
(29, 26),
(29, 30),
(25, 31),
(26, 32),
(28, 32);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aux_emprestimo_obra`
--

CREATE TABLE `aux_emprestimo_obra` (
  `codigoEmprestimo` int(11) NOT NULL,
  `codigoObra` int(11) NOT NULL,
  `chegada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aux_emprestimo_obra`
--

INSERT INTO `aux_emprestimo_obra` (`codigoEmprestimo`, `codigoObra`, `chegada`) VALUES
(5, 4, '2017-11-28'),
(16, 24, '2017-11-30'),
(25, 27, '8895-06-27'),
(33, 26, '5559-08-24'),
(35, 28, '2017-11-30'),
(42, 26, '2017-12-22'),
(43, 25, '2017-12-29'),
(42, 24, '2017-12-22'),
(46, 29, '2018-01-15'),
(47, 30, '2018-01-26'),
(48, 31, '2018-04-20'),
(49, 32, '2018-04-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `codigoCategoria` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `codigoCidade` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `estado_codigoEstado` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `codigoCliente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `status` varchar(11) NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `idade` int(11) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`codigoCliente`, `nome`, `status`, `cpf`, `idade`, `email`) VALUES
(1, 'MARIA NAZARETH RODRIGUES', 'Ativado', '343434', 58, ''),
(2, 'ADA KEYSE SANTOS RODRIGUES', 'Ativado', '555588', 23, ''),
(3, 'GLAUCIENE SOUZA PERES', 'Ativado', '34343498880', 47, ''),
(4, 'ALERRANDRO BARBOSA DE FARIAS', 'Ativado', '34443434', 16, ''),
(5, 'ADEJAR SOARES MARTINS', 'Desativado', '435454545', 23, ''),
(6, 'MaurHy de Jesus', 'Ativado', '245362343', 31, ''),
(7, 'maria joaquina', 'Ativado', '34343434343', 0, ''),
(8, 'FELIPE PERET', 'Ativado', '75373785172', 6, ''),
(9, 'VANESSA CAMARGO', 'Ativado', '444889978', 0, ''),
(10, 'JOAO PARAIBA', 'Ativado', '75373785172', 33, ''),
(11, 'MARCELO VOAVENTURA', 'Ativado', '343434344', 5, ''),
(12, 'Esdras Goulart Bueno', 'Ativado', '02555939105', 14, ''),
(13, 'GUEDES', 'Desativado', '05223284151', 23, '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `codigoEditora` int(11) NOT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `razaoSocial` varchar(45) NOT NULL,
  `cnpj` varchar(20) DEFAULT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `editora`
--

INSERT INTO `editora` (`codigoEditora`, `nomeFantasia`, `razaoSocial`, `cnpj`, `status`) VALUES
(11, 'GLOBO', 'rodruiges e dutra ltda', '434343', 'Desativado'),
(12, 'SEXTANTE', 'NAO INFORMADO', '34343435599', 'Ativado'),
(13, 'VEJA', 'VEJA EDICAO LTDA ERELI', '343434356', 'Ativado'),
(14, 'EDIOURO', 'SIGILOSO', '3434', 'Ativado'),
(15, 'RECORD', 'CRISTIAN AMPERES', '1111', 'Desativado'),
(16, 'UNIRV-RV', 'UNIRV', '123456789', 'Ativado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimo`
--

CREATE TABLE `emprestimo` (
  `codigoEmprestimo` int(11) NOT NULL,
  `funcionario_codigoFuncionario` int(11) NOT NULL,
  `saida` date NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `devolucao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`codigoEmprestimo`, `funcionario_codigoFuncionario`, `saida`, `codigoCliente`, `devolucao`) VALUES
(4, 0, '2017-11-26', 1, '2017-11-26'),
(5, 0, '2017-11-26', 1, '2017-11-26'),
(6, 0, '2017-11-26', 1, '2017-11-28'),
(7, 0, '2017-11-26', 1, '2017-11-27'),
(8, 0, '2017-11-26', 2, '2017-11-30'),
(9, 0, '2017-11-26', 2, '2017-11-26'),
(15, 0, '2017-11-28', 2, '2017-11-29'),
(16, 0, '2017-11-28', 3, '2017-11-30'),
(17, 0, '2017-11-28', 2, '2017-12-02'),
(18, 0, '2017-11-28', 3, '2017-12-03'),
(19, 0, '2017-11-28', 2, '2017-12-02'),
(20, 0, '2017-11-29', 0, '1111-11-11'),
(21, 0, '2017-11-29', 3, '2019-11-23'),
(22, 0, '2017-11-26', 2, '2017-11-26'),
(23, 0, '2017-11-29', 3, '3335-10-03'),
(24, 0, '2017-11-29', 2, '3335-10-03'),
(25, 0, '2017-11-29', 2, '8895-06-27'),
(26, 0, '2017-11-29', 3, '4447-09-13'),
(27, 0, '2017-11-29', 3, '3335-10-03'),
(28, 0, '2017-11-29', 3, '2017-11-30'),
(29, 0, '2017-11-29', 2, '7783-07-16'),
(30, 0, '2017-11-29', 2, '1111-11-11'),
(31, 0, '2017-11-29', 3, '5559-08-24'),
(32, 0, '2017-11-29', 4, '2223-10-22'),
(33, 0, '2017-11-29', 4, '5559-08-24'),
(34, 0, '2017-11-29', 4, '5559-08-24'),
(35, 0, '2017-11-30', 5, '0002-11-30'),
(36, 0, '2017-11-30', 5, '3335-10-03'),
(37, 0, '2017-12-01', 5, '1993-12-12'),
(38, 0, '2017-12-02', 6, '2017-12-01'),
(39, 0, '2017-12-02', 6, '2017-11-01'),
(40, 0, '2017-12-07', 8, '2017-12-05'),
(41, 0, '2017-12-21', 8, '2017-12-22'),
(42, 0, '2017-12-21', 14, '2017-12-22'),
(43, 0, '2017-12-21', 13, '2017-12-29'),
(44, 0, '2017-12-21', 14, '2017-12-22'),
(45, 0, '2018-01-09', 6, '2018-01-10'),
(46, 0, '2018-01-11', 10, '2018-01-15'),
(47, 0, '2018-01-18', 10, '2018-01-26'),
(48, 0, '2018-04-17', 4, '2018-04-20'),
(49, 0, '2018-04-27', 10, '2018-04-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `codigoEndereco` int(11) NOT NULL,
  `cliente_codigoCliente` int(11) DEFAULT NULL,
  `cidade_codigoCidade` int(11) DEFAULT NULL,
  `editora_codigoEditora` int(11) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`codigoEndereco`, `cliente_codigoCliente`, `cidade_codigoCidade`, `editora_codigoEditora`, `rua`, `bairro`, `complemento`) VALUES
(1, 1, 0, NULL, 'MARIA MERQUEDES', 'MARANATA', 'Q.32 LT.10'),
(2, 1, 0, NULL, 'Av. Engenheiro ', 'Eusébio Stevaux', '823'),
(3, 2, 0, NULL, 'R João Vaiano', 'Vitória RégiA', '440 - LT 2 A SL A'),
(4, 2, 0, NULL, 'Av. Tocantins', 'St. Central', 'N 675'),
(5, 2, 0, NULL, 'Av. Pres. Vargas', 'CENTRO', '1997'),
(6, 3, 0, NULL, 'Av. Cândido de Abreu', 'centro', 'n 817'),
(7, 3, 0, NULL, 'Av. Anhanguera', 'St.Central', '4603'),
(8, 4, 0, NULL, 'Norte Rua', 'NORTE', ' Q. 104 ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `codigoEstado` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `obra`
--

CREATE TABLE `obra` (
  `codigoObra` int(11) NOT NULL,
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
  `qtdEstoqueDisponivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigoUsuario` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `perfil` tinyint(4) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`codigoAutor`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`codigoCategoria`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`codigoCidade`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigoCliente`);

--
-- Indexes for table `editora`
--
ALTER TABLE `editora`
  ADD PRIMARY KEY (`codigoEditora`);

--
-- Indexes for table `emprestimo`
--
ALTER TABLE `emprestimo`
  ADD PRIMARY KEY (`codigoEmprestimo`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`codigoEndereco`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`codigoEstado`);

--
-- Indexes for table `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`codigoObra`),
  ADD KEY `fk_Obra_Editora_idx` (`editora_codigoEditora`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigoUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `autor`
--
ALTER TABLE `autor`
  MODIFY `codigoAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `codigoCategoria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `codigoCidade` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigoCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `editora`
--
ALTER TABLE `editora`
  MODIFY `codigoEditora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `emprestimo`
--
ALTER TABLE `emprestimo`
  MODIFY `codigoEmprestimo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `codigoEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `codigoEstado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `obra`
--
ALTER TABLE `obra`
  MODIFY `codigoObra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT;
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
