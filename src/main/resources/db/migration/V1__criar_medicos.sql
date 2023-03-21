CREATE TABLE medicos(

    id INT PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    email VARCHAR(100) NOT NULL,
    crm VARCHAR(13) NOT NULL UNIQUE,
    especialidade VARCHAR(100) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL


);

INSERT INTO medicos VALUES(1, "Rodrigo ferreira", "5581987550512", "rodrigo.ferreira@medvoll.com", "01254758-0/PE","ORTOPEDIA","50721530","Condomonio bom Jesus","TRIPLEX", "BOA VISTA", 65, "RECIFE", "PE");
INSERT INTO medicos VALUES(2, "Mariana batista", "5581989951312", "mariana.batista@medvoll.com", "02154138-0/PE","CARDIOLOGIA","50721530","Condominio nossa praia","13° Andar", "BOA VIAGEM", 665, "RECIFE", "PE");