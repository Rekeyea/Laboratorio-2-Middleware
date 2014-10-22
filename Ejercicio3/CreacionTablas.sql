CREATE DATABASE Ejercicio3;
CREATE TABLE Persona (
	Id bigint(20) NOT NULL AUTO_INCREMENT,
    Nombre varchar(50) NOT NULL,
    Apellido varchar(50) NOT NULL,
    TipoDocumento char(1) NOT NULL,
    NumeroDocumento varchar(20) NOT NULL,
    DocumentoPais char(3) NOT NULL,
    Genero int(1) NOT NULL,
    FechaNacimiento date NOT NULL,
    PRIMARY KEY(Id)
);

CREATE TABLE TipoDocumento (
	TipoDocumento char(1) NOT NULL,
    Nombre varchar(9) NOT NULL,
    PRIMARY KEY (TipoDocumento)
);

CREATE TABLE CodigoPais (
	CodigoPais char(3),
    Nombre varchar(100),
    PRIMARY KEY(CodigoPais)
);
