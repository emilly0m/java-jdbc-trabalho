CREATE DATABASE loja;
USE loja;

CREATE TABLE loja (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    sobrenome VARCHAR(50),
    idade INT,
    salario DECIMAL(10, 2)
);

CREATE TABLE funcionario (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    sobrenome VARCHAR(50),
    idade     INT,
    salario   DECIMAL(10, 2)
);

INSERT INTO funcionario (nome, sobrenome, idade, salario) VALUES
    ('João', 'Flores', 32, 2132.12),
    ('Carla', 'Fachin', 35, 4332.44),
    ('Mario', 'Corleone', 28, 2322.39);