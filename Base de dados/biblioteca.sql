-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Jun-2018 às 23:16
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
(28, 32),
(26, 34),
(28, 35),
(29, 36),
(26, 37),
(24, 0),
(24, 1),
(24, 2),
(25, 3),
(25, 4);

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
(1, 1, '2018-05-18'),
(2, 2, '2018-05-18');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `codigoCategoria` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`codigoCategoria`, `nome`) VALUES
(1, 'ROMANCE'),
(2, 'TERROR');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `codigoCidade` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`codigoCidade`, `nome`) VALUES
(1, 'RIO VERDE');

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
(13, 'GUEDES', 'Desativado', '05223284151', 23, ''),
(14, 'Erick Moraes', 'Ativado', '70000000000', 24, 'erickmoraes_rv@hotmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `codigoEditora` int(11) NOT NULL,
  `nomeFantasia` varchar(45) NOT NULL,
  `razaoSocial` varchar(45) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
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
  `devolucao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`codigoEmprestimo`, `funcionario_codigoFuncionario`, `saida`, `codigoCliente`, `devolucao`) VALUES
(3, 0, '2018-05-17', 12, '2018-05-18');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `codigoEndereco` int(11) NOT NULL,
  `cliente_codigoCliente` int(11) DEFAULT NULL,
  `cidade_codigoCidade` int(11) NOT NULL,
  `editora_codigoEditora` int(11) DEFAULT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
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
(3, 'teste', 'etet', 14, 1, 5, '2018-05-17', 2, 'Prateleira', 'Ativado', '', 2, 5),
(4, 'SISTEMAS OPERACIONAIS', 'JANTAR DOS FILOSOFOS', 16, 1, 1, '2018-05-17', 2, 'Prateleira', 'Ativado', '', 3, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigoUsuario` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `perfil` int(1) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigoUsuario`, `nome`, `perfil`, `login`, `senha`) VALUES
(1, 'cristian', 0, 'cristianperes', '12345'),
(2, 'erick', 0, 'erickmoraes', '12345'),
(3, 'gerentePrisma', 1, 'prismasoft', '12345'),
(4, 'felipe', 0, 'felipe_peretti', '12345'),
(5, 'jefferson', 0, 'jeffersonguedes', '12345');

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
  MODIFY `codigoCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `codigoCidade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigoCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `editora`
--
ALTER TABLE `editora`
  MODIFY `codigoEditora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `emprestimo`
--
ALTER TABLE `emprestimo`
  MODIFY `codigoEmprestimo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `codigoEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `obra`
--
ALTER TABLE `obra`
  MODIFY `codigoObra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
