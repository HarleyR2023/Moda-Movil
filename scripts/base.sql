# TABLAS
CREATE TABLE Categoria (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100)
);

CREATE TABLE Proveedor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  direccion VARCHAR(100),
  telefono VARCHAR(100),
  correo VARCHAR(100)
);

CREATE TABLE Productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  categoria_id INT,
  proveedor_id INT,
  nombre VARCHAR(100),
  descripcion VARCHAR(100),
  precio DECIMAL,
  stock INT,
  fecha_ingreso DATE,
  FOREIGN KEY (categoria_id) REFERENCES Categoria(id),
  FOREIGN KEY (proveedor_id) REFERENCES Proveedor(id)
);

CREATE TABLE Entidad (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE Usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  contra INT,
  entidad_id INT,
  FOREIGN KEY (entidad_id) REFERENCES Entidad(id)
);

CREATE TABLE Clientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  direccion VARCHAR(100),
  ciudad VARCHAR(100),
  telefono VARCHAR(100),
  correo VARCHAR(100),
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

CREATE TABLE Trabajadores (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  cargo VARCHAR(100),
  fecha_contratacion DATE,
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

CREATE TABLE Ventas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  fecha DATE,
  total DECIMAL,
  metodo_pago VARCHAR(100),
  estado VARCHAR(100),
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

CREATE TABLE detallesVentas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  producto_id INT,
  cantidad INT,
  precio_unitario DECIMAL,
  FOREIGN KEY (venta_id) REFERENCES Ventas(id),
  FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

CREATE TABLE Envio (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  tipo_envio VARCHAR(100),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id)
);

CREATE TABLE historialVentas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  fecha DATE,
  total DECIMAL,
  metodo_pago VARCHAR(100),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id)
);

CREATE TABLE Facturas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  usuario_id INT,
  fecha DATE,
  total DECIMAL,
  metodo_pago VARCHAR(100),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id),
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

# DATOS---
# Insertar datos en la tabla Categoria
INSERT INTO Categoria (nombre) VALUES 
  ('Electrónicos'),
  ('Ropa'),
  ('Hogar'),
  ('Alimentos'),
  ('Juguetes');

# Insertar datos en la tabla Proveedor
INSERT INTO Proveedor (nombre, direccion, telefono, correo) VALUES 
  ('ElectroTech', 'Calle Principal 123', '123456789', 'info@electrotech.com'),
  ('FashionStyle', 'Avenida Central 456', '987654321', 'info@fashionstyle.com'),
  ('CasaDecor', 'Plaza Mayor 789', '456789123', 'info@casadecor.com');

# Insertar datos en la tabla Productos
INSERT INTO Productos (categoria_id, proveedor_id, nombre, descripcion, precio, stock, fecha_ingreso) VALUES 
  (1, 1, 'Televisor LED', 'Televisor de alta definición', 599.99, 50, '2024-05-01'),
  (2, 2, 'Camiseta de algodón', 'Camiseta de color blanco', 19.99, 100, '2024-05-03'),
  (3, 3, 'Lámpara de techo', 'Lámpara moderna de techo', 79.99, 30, '2024-05-05'),
  (4, 1, 'Arroz', 'Arroz blanco de calidad premium', 5.99, 200, '2024-05-10'),
  (5, 3, 'Rompecabezas', 'Rompecabezas de 1000 piezas', 29.99, 80, '2024-05-12');

# Insertar datos en la tabla Entidad
INSERT INTO Entidad (name) VALUES 
  ('Entidad1'),
  ('Entidad2'),
  ('Entidad3');

# Insertar datos en la tabla Usuarios
INSERT INTO Usuarios (nombre, contra, entidad_id) VALUES 
  ('Usuario1', 123456, 1),
  ('Usuario2', 654321, 2),
  ('Usuario3', 987654, 3);

# Insertar datos en la tabla Clientes
INSERT INTO Clientes (usuario_id, nombre, apellido, direccion, ciudad, telefono, correo) VALUES 
  (1, 'Juan', 'Pérez', 'Calle A 123', 'Ciudad1', '123456789', 'juan@example.com'),
  (2, 'María', 'Gómez', 'Avenida B 456', 'Ciudad2', '987654321', 'maria@example.com'),
  (3, 'Carlos', 'López', 'Plaza C 789', 'Ciudad3', '456789123', 'carlos@example.com');

# Insertar datos en la tabla Trabajadores
INSERT INTO Trabajadores (usuario_id, nombre, apellido, cargo, fecha_contratacion) VALUES 
  (1, 'Pedro', 'Martínez', 'Gerente de ventas', '2024-01-15'),
  (2, 'Ana', 'Ruiz', 'Asistente de administración', '2024-02-20'),
  (3, 'Laura', 'Hernández', 'Operario de almacén', '2024-03-25');

# Insertar datos en la tabla Ventas
INSERT INTO Ventas (usuario_id, fecha, total, metodo_pago, estado) VALUES 
  (1, '2024-05-01', 799.99, 'Tarjeta de crédito', 'Completado'),
  (2, '2024-05-02', 119.98, 'Transferencia bancaria', 'Pendiente'),
  (3, '2024-05-03', 99.98, 'Efectivo', 'Completado');

# Insertar datos en la tabla detallesVentas
INSERT INTO detallesVentas (venta_id, producto_id, cantidad, precio_unitario) VALUES 
  (1, 1, 1, 599.99),
  (2, 2, 2, 19.99),
  (3, 3, 1, 79.99);

# Insertar datos en la tabla Envio
INSERT INTO Envio (venta_id, tipo_envio) VALUES 
  (1, 'Express'),
  (2, 'Estándar'),
  (3, 'Express');

# Insertar datos en la tabla historialVentas
INSERT INTO historialVentas (venta_id, fecha, total, metodo_pago) VALUES 
  (1, '2024-05-01', 799.99, 'Tarjeta de crédito'),
  (2, '2024-05-02', 119.98, 'Transferencia bancaria'),
  (3, '2024-05-03', 99.98, 'Efectivo');

# Insertar datos en la tabla Facturas
INSERT INTO Facturas (venta_id, usuario_id, fecha, total, metodo_pago) VALUES 
  (1, 1, '2024-05-01', 799.99, 'Tarjeta de crédito'),
  (2, 2, '2024-05-02', 119.98, 'Transferencia bancaria'),
  (3, 3, '2024-05-03', 99.98, 'Efectivo');