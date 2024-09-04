create database pizzeria;

use pizzeria;

CREATE TABLE tipos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE ingredientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    cantidad DECIMAL(10, 2) NOT NULL,
    tipo_id INT NOT NULL,
    FOREIGN KEY (tipo_id) REFERENCES tipos(id)
);

CREATE TABLE productos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion TEXT NOT NULL
);

CREATE TABLE empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    puesto VARCHAR(40) NOT NULL,
    fecha_nacimiento DATE NOT NULL
);

CREATE TABLE ventas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    empleado_id INT NOT NULL,
    FOREIGN KEY (empleado_id) REFERENCES empleados(id)
);

CREATE TABLE producto_ingrediente (
    producto_id INT NOT NULL,
    ingrediente_id INT NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (ingrediente_id) REFERENCES ingredientes(id),
    PRIMARY KEY (producto_id, ingrediente_id)
);

CREATE TABLE producto_venta (
    producto_id INT NOT NULL,
    venta_id INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (venta_id) REFERENCES ventas(id),
    PRIMARY KEY (producto_id, venta_id)
);
