INSERT INTO tb_cliente(id, cpf, nome, celular, email, logradouro, cep, numero, complemento, bairro, data_nascimento, renda_mensal) VALUES
(1, '27634071021', 'Lilian Sousa', '11987654322', 'lilian@git.com', 'Rua Anhumas', '07134060','567', 'casa terrea', 'Jardim Flores', '1987-12-12', 5400.00),
(2, '01686658087', 'Laura Andrade', '11976543422', 'laura@git.com', 'Rua Terezinha', '07123090', '234', 'apto 34', 'Jardim Prato', '1985-03-30', 5000.00),
(3, '15886223045', 'Ana Cristiana Cruz', '11976543455', 'anacruz@git.com', 'Rua Belas Artes', '41295790', '99', 'apto 90', 'Jardim Rocha', '1991-05-22', 1800.00),
(4, '89306490097', 'Joana Bernardes', '11987654322', 'joanabianca@git.com', 'Rua Maravilha', '57316100', '900', 'sobrado', 'Jardim Cosmos', '1979-09-17', 2500.00),
(5, '33231708060', 'Lavinia Silva','11976564433', 'lavinia@git.com', 'Rua Tucano', '69917516', '276', 'casa', 'Jardim Pedra', '1966-07-01', 3600.00);


INSERT INTO tb_conta(id, agencia, conta, senha, cliente_id) VALUES
(1, '1704', '16858-3', 'Voe#gWLV!3xaoieV5A!pHG', 1),
(2, '1704', '25812-8', 'b8V#h32#6TPFX#Yq9wiGUL', 2),
(3, '1704', '32145-7', 'sW%Ry%Py5%2thVSP!B5Gtx', 3),
(4, '1704', '33221-4', 'Zr%Hfk2bcKuJjoVUn!rUfN', 4),
(5, '1704', '85349-0','XgH95NEBrPBwr35pUq!XMC', 5);