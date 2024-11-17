La base de datos se encuentra en la carpeta database.

Para crear la base de datos ejecute:

CREATE DATABASE crud_turismo; 	
use crud_turismo;
CREATE TABLE destino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo VARCHAR(20) NOT NULL,
    precio FLOAT,
    destino VARCHAR(20) NOT NULL
);