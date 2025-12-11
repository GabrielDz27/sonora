CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE TABLE usuarios
(
    id    uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    login VARCHAR(60)  NOT NULL UNIQUE,
    email VARCHAR(250) NOT NULL UNIQUE,
    senha TEXT         NOT NULL,
    role  VARCHAR(50)  NOT NULL
);

CREATE TABLE membros
(
    id              SERIAL PRIMARY KEY NOT NULL,
    usuario_id      uuid UNIQUE REFERENCES usuarios (id),
    cpf             VARCHAR(11)        NOT NULL UNIQUE,
    data_nascimento DATE               NOT NULL,
    nome            VARCHAR(255)       NOT NULL,
    email           VARCHAR(250)       NOT NULL,
    logradouro      VARCHAR(100)       NOT NULL,
    bairro          VARCHAR(100)       NOT NULL,
    cep             VARCHAR(9)         NOT NULL,
    complemento     VARCHAR(100),
    numero          VARCHAR(20),
    uf              CHAR(2)            NOT NULL,
    cidade          VARCHAR(100)       NOT NULL,
    telefone        VARCHAR(20)        NOT NULL
);

CREATE TABLE salas
(
    id             SERIAL PRIMARY KEY NOT NULL,
    nome           VARCHAR(100)       NOT NULL UNIQUE,
    capacidade     INTEGER            NOT NULL,
    tem_abafadores BOOLEAN DEFAULT FALSE
);

CREATE TABLE instrumentos
(
    id                 SERIAL PRIMARY KEY NOT NULL,
    tipos_instrumentos VARCHAR(50),
    nome               VARCHAR(100)       NOT NULL,
    modelo             VARCHAR(100)       NOT NULL,
    numero_serie       VARCHAR(100) UNIQUE,
    ano_fabricacao     INTEGER            NOT NULL,
    pais_origem        VARCHAR(100)       NOT NULL,
    estado_conservacao VARCHAR(50)        NOT NULL,
    caracteristica     VARCHAR(255),
    sala_fixa_id       INTEGER REFERENCES salas (id)
);

CREATE TABLE reservas
(
    id                 SERIAL PRIMARY KEY            NOT NULL,
    membro_id          INTEGER                       NOT NULL REFERENCES membros (id),
    instrumento_id     INTEGER REFERENCES instrumentos (id),
    sala_id            INTEGER REFERENCES salas (id) NOT NULL,
    data_hora_inicio   TIMESTAMP                     NOT NULL,
    data_hora_fim      TIMESTAMP                     NOT NULL,
    data_hora_registro TIMESTAMP                     NOT NULL,
    tem_proximo        BOOLEAN,
    tipo_uso           VARCHAR(50)                   NOT NULL,
    observacoes        TEXT
);


