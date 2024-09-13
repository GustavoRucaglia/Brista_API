CREATE TABLE USERS (
   id VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    password varchar(50) NOT NULL,
    role TEXT NOT NULL
);

CREATE TABLE ponto_roteiro (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    nota DECIMAL(5, 2) NOT NULL,
    data_de_criacao TIMESTAMP NULL,
    cep VARCHAR(20) NULL,
    fotos TEXT NULL,
    state BOOLEAN NOT NULL
);

INSERT INTO USERS (id, login, password, role) 
VALUES ( '5535','ADMIN@gmail.com', '123456', '0');