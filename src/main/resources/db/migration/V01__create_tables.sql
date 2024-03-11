CREATE TABLE `tb_cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `celular` varchar(15) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` int DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `renda_mensal` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`cpf`)
);

CREATE TABLE `tb_conta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `agencia` varchar(4) NOT NULL,
  `conta` varchar(7) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `cliente_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`conta`),
  UNIQUE KEY (`cliente_id`),
  CONSTRAINT FOREIGN KEY (`cliente_id`) REFERENCES `tb_cliente` (`id`)
);