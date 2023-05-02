CREATE TABLE pacientes(

    id bigint NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL unique,
    cpf VARCHAR(14) NOT NULL unique,
    cep VARCHAR(10) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    ativo CHAR(1) NOT NULL,
    primary key(id)

);