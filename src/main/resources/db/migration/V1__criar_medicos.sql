create table medicos(

    id bigint NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    email VARCHAR(100) NOT NULL,
    crm VARCHAR(11) NOT NULL UNIQUE,
    especialidade VARCHAR(100) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL
    cidade VARCHAR(100) NOT NULL,
    estado CHAR(2) NOT NULL,
    PRIMARY KEY (id)

);

INSERT INTO medicos VALUES(1, "Rodrigo ferreira", "5581987550512", "rodrigo.ferreira@medvoll.com", "01254758-0/PE","ORTOPEDIA","50721530","Condomonio bom Jesus","TRIPLEX", "BOA VISTA", "RECIFE", "PE");
INSERT INTO medicos VALUES(1, "Mariana batista", "5581989951312", "mariana.batista@medvoll.com", "02154138-0/PE","CARDIOLOGIA","50721530","Condominio nossa praia","13° Andar", "BOA VIAGEM", "RECIFE", "PE");