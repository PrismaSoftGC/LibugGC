-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06-Maio-2018 às 18:06
-- Versão do servidor: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca`
--
CREATE DATABASE IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `biblioteca`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `autor`
--

CREATE TABLE `autor` (
  `codigoAutor` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `conteudo` varchar(45) NOT NULL,
  `cpf` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `autor`
--

INSERT INTO `autor` (`codigoAutor`, `nome`, `status`, `conteudo`, `cpf`) VALUES
(22, 'MACHADO DE ASSIS', 'Ativado', 'POESIA', '2322344'),
(23, 'CARLOS DRUMOMOND', 'Ativado', 'SONETO', '2233309909'),
(24, 'JORGE AMADO', 'Ativado', 'NAO LEMBRO', '3340000'),
(25, 'GUIMARAES ', 'Ativado', 'PIOROU', '877778'),
(26, 'CLARISSE LIS', 'Ativado', 'LASCOU', '99900'),
(27, 'ADEJAR', 'Ativado', 'NAO SEI', '344'),
(28, 'ADEJAIR', 'Desativado', 'JJ', '009999'),
(29, 'ANDRE', 'Ativado', 'RGR', '12345'),
(30, 'jamel da silva', 'Ativado', '', '34343434'),
(31, 'MARIA BARBOSA', 'Ativado', 'INFANTIL', '3343444');

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
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `codigoCliente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `status` varchar(11) NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `idade` int(11) NOT NULL,
  `rua` varchar(50) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`codigoCliente`, `nome`, `status`, `cpf`, `idade`, `rua`, `bairro`, `complemento`, `cidade`) VALUES
(1, 'MARIA NAZARETH RODRIGUES', 'Ativado', '343434', 58, 'FRANCISCO FERDINANDO CORREA', 'CENTRO', 'DE FRENTE A FARMACIA', 'QUIRINOPOLIS -GO'),
(2, 'ADA KEYSE SANTOS RODRIGUES', 'Ativado', '555588', 23, 'ELUCIDARIA QD 14 LOTE 15', 'ANHANGUERA', 'EM FRENTE O PASTO', 'RIO VERDE - GO'),
(3, 'GLAUCIENE SOUZA PERES', 'Ativado', '34343498880', 47, '', '', '', ''),
(4, 'ALERRANDRO BARBOSA DE FARIAS', 'Ativado', '34443434', 16, '', '', '', ''),
(5, 'ADEJAR SOARES MARTINS', 'Desativado', '435454545', 23, '', '', '', ''),
(6, 'MaurHy de Jesus', 'Ativado', '245362343', 31, 'Rua das aboboras', 'abobral', 'sfgs', 'Rio Verde'),
(7, 'maria joaquina', 'Ativado', '34343434343', 0, '', '', '', ''),
(8, 'FELIPE PERET', 'Ativado', '75373785172', 6, '', '', '', ''),
(9, 'VANESSA CAMARGO', 'Ativado', '444889978', 0, '', '', '', ''),
(10, 'JOAO PARAIBA', 'Ativado', '75373785172', 33, '', '', '', ''),
(11, 'MARCELO VOAVENTURA', 'Ativado', '343434344', 5, '', '', '', ''),
(12, 'Esdras Goulart Bueno', 'Ativado', '02555939105', 14, '', '', '', ''),
(13, 'GUEDES', 'Desativado', '05223284151', 23, '', '', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `codigoEditora` int(11) NOT NULL,
  `nomeFantasia` varchar(45) NOT NULL,
  `razaoSocial` varchar(45) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `editora`
--

INSERT INTO `editora` (`codigoEditora`, `nomeFantasia`, `razaoSocial`, `cnpj`, `rua`, `bairro`, `complemento`, `cidade`, `telefone`, `status`) VALUES
(11, 'GLOBO', 'rodruiges e dutra ltda', '434343', '', '', '', '', '', 'Desativado'),
(12, 'SEXTANTE', 'NAO INFORMADO', '34343435599', '', '', '', '', '', 'Ativado'),
(13, 'VEJA', 'VEJA EDICAO LTDA ERELI', '343434356', '', '', '', '', '', 'Ativado'),
(14, 'EDIOURO', 'SIGILOSO', '3434', '', '', '', '', '', 'Ativado'),
(15, 'RECORD', 'CRISTIAN AMPERES', '1111', '', '', '', '', '', 'Desativado'),
(16, 'UNIRV-RV', 'UNIRV', '123456789', 'RUA ', 'JD', 'RD', 'RIO VERDE', '', 'Ativado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimo`
--

CREATE TABLE `emprestimo` (
  `codigoEmprestimo` int(11) NOT NULL,
  `saida` date NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `devolucao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`codigoEmprestimo`, `saida`, `codigoCliente`, `devolucao`) VALUES
(4, '2017-11-26', 1, '2017-11-26'),
(5, '2017-11-26', 1, '2017-11-26'),
(6, '2017-11-26', 1, '2017-11-28'),
(7, '2017-11-26', 1, '2017-11-27'),
(8, '2017-11-26', 2, '2017-11-30'),
(9, '2017-11-26', 2, '2017-11-26'),
(15, '2017-11-28', 2, '2017-11-29'),
(16, '2017-11-28', 3, '2017-11-30'),
(17, '2017-11-28', 2, '2017-12-02'),
(18, '2017-11-28', 3, '2017-12-03'),
(19, '2017-11-28', 2, '2017-12-02'),
(20, '2017-11-29', 0, '1111-11-11'),
(21, '2017-11-29', 3, '2019-11-23'),
(22, '2017-11-26', 2, '2017-11-26'),
(23, '2017-11-29', 3, '3335-10-03'),
(24, '2017-11-29', 2, '3335-10-03'),
(25, '2017-11-29', 2, '8895-06-27'),
(26, '2017-11-29', 3, '4447-09-13'),
(27, '2017-11-29', 3, '3335-10-03'),
(28, '2017-11-29', 3, '2017-11-30'),
(29, '2017-11-29', 2, '7783-07-16'),
(30, '2017-11-29', 2, '1111-11-11'),
(31, '2017-11-29', 3, '5559-08-24'),
(32, '2017-11-29', 4, '2223-10-22'),
(33, '2017-11-29', 4, '5559-08-24'),
(34, '2017-11-29', 4, '5559-08-24'),
(35, '2017-11-30', 5, '0002-11-30'),
(36, '2017-11-30', 5, '3335-10-03'),
(37, '2017-12-01', 5, '1993-12-12'),
(38, '2017-12-02', 6, '2017-12-01'),
(39, '2017-12-02', 6, '2017-11-01'),
(40, '2017-12-07', 8, '2017-12-05'),
(41, '2017-12-21', 8, '2017-12-22'),
(42, '2017-12-21', 14, '2017-12-22'),
(43, '2017-12-21', 13, '2017-12-29'),
(44, '2017-12-21', 14, '2017-12-22'),
(45, '2018-01-09', 6, '2018-01-10'),
(46, '2018-01-11', 10, '2018-01-15'),
(47, '2018-01-18', 10, '2018-01-26'),
(48, '2018-04-17', 4, '2018-04-20'),
(49, '2018-04-27', 10, '2018-04-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `codigoEndereco` int(11) NOT NULL,
  `codigoCliente` int(11) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`codigoEndereco`, `codigoCliente`, `cidade`, `rua`, `bairro`, `complemento`) VALUES
(1, 1, 'RIO VERDE', 'MARIA MERQUEDES', 'MARANATA', 'Q.32 LT.10'),
(2, 1, 'SÃO PAULO', 'Av. Engenheiro ', 'Eusébio Stevaux', '823'),
(3, 2, 'RIO VERDE', 'R João Vaiano', 'Vitória RégiA', '440 - LT 2 A SL A'),
(4, 2, 'GOIANIA', 'Av. Tocantins', 'St. Central', 'N 675'),
(5, 2, 'RIO DE JANEIRO', 'Av. Pres. Vargas', 'CENTRO', '1997'),
(6, 3, 'CURITIBA', 'Av. Cândido de Abreu', 'centro', 'n 817'),
(7, 3, 'BAHIA', 'Av. Anhanguera', 'St.Central', '4603'),
(8, 4, 'PALMAS', 'Norte Rua', 'NORTE', ' Q. 104 ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `obra`
--

CREATE TABLE `obra` (
  `codigoObra` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `codigoEditora` int(11) NOT NULL,
  `edicao` int(11) DEFAULT NULL,
  `situacao` varchar(12) NOT NULL,
  `status` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `obra`
--

INSERT INTO `obra` (`codigoObra`, `titulo`, `codigoEditora`, `edicao`, `situacao`, `status`) VALUES
(24, 'DOM CASMURRO', 14, 1, 'Emprestado', 'Ativado'),
(25, 'A ROSA DO POVO', 12, 3, 'Emprestado', 'Ativado'),
(26, 'CAPITAES DA AREIA', 13, 4, 'Emprestado', 'Ativado'),
(27, 'COMPILADORES', 13, 1, 'Prateleira', 'Ativado'),
(28, 'CADILACKES', 12, 4, 'Emprestado', 'Ativado'),
(29, 'a culpa', 12, 5, 'Emprestado', 'Ativado'),
(30, 'A CRUZ PERDIDA', 14, 1, 'Emprestado', 'Ativado'),
(31, 'o poeta', 12, 877, 'Emprestado', 'Ativado'),
(32, 'HARRY POTTER', 12, 5, 'Emprestado', 'Ativado');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`codigoAutor`);

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
-- Indexes for table `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`codigoObra`),
  ADD KEY `fk_Obra_Editora_idx` (`codigoEditora`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `autor`
--
ALTER TABLE `autor`
  MODIFY `codigoAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

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
-- AUTO_INCREMENT for table `obra`
--
ALTER TABLE `obra`
  MODIFY `codigoObra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `fk_Obra_Editora` FOREIGN KEY (`codigoEditora`) REFERENCES `editora` (`codigoEditora`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
