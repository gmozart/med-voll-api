CREATE TABLE pacientes(

    id INT PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL unique,
    cpf VARCHAR(14) NOT NULL unique,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    cidade VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    ativo CHAR(1) NOT NULL

);