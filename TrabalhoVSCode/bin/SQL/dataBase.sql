CREATE DATABASE hospitaldb;
USE hospitaldb;

CREATE TABLE doador(
    cpf INTEGER NOT NULL,
    nome VARCHAR(80) NOT NULL,
    nascimento DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone INTEGER NOT NULL,
    tipoSanguinio VARCHAR(4) NOT NULL,
    PRIMARY KEY(cpf)
);


CREATE TABLE agendamento(
    id INTEGER NOT NULL,
    dataA DATE NOT NULL,
    horario VARCHAR(10) NOT NULL,
    sala INTEGER NOT NULL,
    pessoaCPF INTEGER NOT NULL,
    funcionarioRegistro INTEGER NOT NULL,
    PRIMARY KEY(id)
);
