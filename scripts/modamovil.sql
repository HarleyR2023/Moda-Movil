# Crear tabla de Categorias
CREATE TABLE Categoria (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100)
);

# Crear tabla de Proveedor
CREATE TABLE Proveedor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  direccion VARCHAR(100),
  telefono VARCHAR(100),
  correo VARCHAR(100)
);

# Crear tabla de Productos
CREATE TABLE Productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  categoria_id INT,
  proveedor_id INT,
  nombre VARCHAR(100),
  descripcion VARCHAR(100),
  precio DECIMAL(10,2),
  stock INT,
  fecha_ingreso DATE,
  url_imagen VARCHAR(255),
  FOREIGN KEY (categoria_id) REFERENCES Categoria(id),
  FOREIGN KEY (proveedor_id) REFERENCES Proveedor(id)
);

# Crear tabla de Usuarios
CREATE TABLE Usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombreuser VARCHAR(100),
  contra VARCHAR(100),
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  telefono VARCHAR(100),
  correo VARCHAR(100),
  indicador VARCHAR(100)
);

# Crear tabla de Ventas
CREATE TABLE Ventas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  fecha DATE,
  total DECIMAL(10,2),
  metodo_pago VARCHAR(100),
  estado VARCHAR(100),
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

# Crear tabla de detallesVentas
CREATE TABLE detallesVentas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  producto_id INT,
  cantidad INT,
  precio_unitario DECIMAL(10,2),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id),
  FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

# Crear tabla de Envio
CREATE TABLE Envio (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  tipo_envio VARCHAR(100),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id)
);

# Crear tabla de historialVentas
CREATE TABLE historialVentas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  fecha DATE,
  total DECIMAL(10,2),
  metodo_pago VARCHAR(100),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id)
);

# Crear tabla de Facturas
CREATE TABLE Facturas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  venta_id INT,
  usuario_id INT,
  fecha DATE,
  total DECIMAL(10,2),
  metodo_pago VARCHAR(100),
  FOREIGN KEY (venta_id) REFERENCES Ventas(id),
  FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

# Insertar datos en la tabla Categoria
INSERT INTO Categoria (nombre) VALUES 
  ('CAMISAS'),
  ('POLOS'),
  ('SHORTS');

# Insertar datos en la tabla Proveedor
INSERT INTO Proveedor (nombre, direccion, telefono, correo) VALUES 
  ('ElectroTech', 'Calle Principal 123', '123456789', 'info@electrotech.com'),
  ('FashionStyle', 'Avenida Central 456', '987654321', 'info@fashionstyle.com'),
  ('CasaDecor', 'Plaza Mayor 789', '456789123', 'info@casadecor.com');

# Insertar datos en la tabla Productos
INSERT INTO Productos (categoria_id, proveedor_id, nombre, descripcion, precio, stock, fecha_ingreso, url_imagen) VALUES
    (1, 1, 'Camisa', 'Camisa Hombre Space Ibiza - Negro', 59.00 , 50, '2024-05-19', 'https://beatsnvibes.com/cdn/shop/products/PostVertical4_4.png?v=1673713881'),
    (1, 1, 'Camisa', 'Relaxed Brick - Ladrillo - Ladrillo', 59.00 , 50, '2024-05-19', 'https://beatsnvibes.com/cdn/shop/products/4_19.png?v=1671662884&width=823'),
    (1, 1, 'Camisa', 'Camisa Hombre Hawaiian Tropic - Azul Noche', 59.00 , 50, '2024-05-19', 'https://beatsnvibes.com/cdn/shop/products/20_6_c5914158-3f89-4d14-a47a-f7c0936f22ca.png?v=1671663823&width=823'),
    (2, 2, 'Polo', 'Polo Hombre Side by Side Flower - Negro', 40.00, 30, '2024-05-18', 'https://beatsnvibes.com/cdn/shop/products/PostVertical4_6.png?v=1674491690&width=823'),
    (2, 2, 'Polo', 'S - Polo Hombre Pure Vibes - Verde Oscuro', 40.00, 30, '2024-05-18', 'https://beatsnvibes.com/cdn/shop/products/PostVertical4_7.png?v=1674492205&width=823'),
    (2, 2, 'Polo', 'Polo Hombre Skull Underground - Negro', 40.00, 30, '2024-05-18', 'https://beatsnvibes.com/cdn/shop/products/9_13.png?v=1674506644&width=823'),
    (3, 3, 'Shorts', 'Short CARGO Hombre -Negro', 39.99, 20, '2024-05-17', 'https://beatsnvibes.com/cdn/shop/files/PostVertical10.png?v=1711383258&width=823'),
    (3, 3, 'Shorts', 'Short Hombre HARD - Negro', 50.00, 20, '2024-05-17', 'https://beatsnvibes.com/cdn/shop/products/108_2.png?v=1667499314&width=823'),
    (3, 3, 'Shorts', 'Short Hombre Thriller X - Gris', 50.00, 20, '2024-05-17', 'https://beatsnvibes.com/cdn/shop/products/110_2.png?v=1667499553&width=823');

# Insertar datos en la tabla Usuarios
INSERT INTO Usuarios (nombreuser, contra, nombre, apellido, telefono, correo, indicador) VALUES 
('usuario1', '123456', 'Juan', 'Pérez', '123456789', 'juan@example.com', 'C'),
('usuario4', '123456', 'Pedro', 'Martínez', '111222333', 'pedro@example.com', 'T');

# Insertar datos en la tabla Ventas
INSERT INTO Ventas (usuario_id, fecha, total, metodo_pago, estado) VALUES 
  (1, '2024-05-01', 59.00, 'Tarjeta de crédito', 'Completado'),
  (1, '2024-05-02', 40.00, 'Transferencia bancaria', 'Completado');

# Insertar datos en la tabla detallesVentas
INSERT INTO detallesVentas (venta_id, producto_id, cantidad, precio_unitario) VALUES 
  (1, 1, 1, 59.00),
  (2, 4, 1, 40.00);

# Insertar datos en la tabla Envio
INSERT INTO Envio (venta_id, tipo_envio) VALUES 
  (1, 'Delivery'),
  (2, 'Recogo En Tienda');

# Insertar datos en la tabla historialVentas
INSERT INTO historialVentas (venta_id, fecha, total, metodo_pago) VALUES 
  (1, '2024-05-01', 59.00, 'Tarjeta de crédito'),
  (2, '2024-05-02', 40.00, 'Transferencia bancaria');

# Insertar datos en la tabla Facturas
INSERT INTO Facturas (venta_id, usuario_id, fecha, total, metodo_pago) VALUES 
  (1, 1, '2024-05-01', 59.00, 'Tarjeta de crédito'),
  (2, 1, '2024-05-02', 40.00, 'Transferencia bancaria');
