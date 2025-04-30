
DROP TABLE IF EXISTS prestamos;
DROP TABLE IF EXISTS libros;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS autores;

CREATE TABLE autores (
    dni VARCHAR(9) PRIMARY KEY,
    nombre TEXT NOT NULL,
    nacionalidad TEXT,
    fecha_nacimiento DATE
);

CREATE TABLE libros (
    id_libro VARCHAR(10) PRIMARY KEY,
    titulo TEXT NOT NULL,
    autor_dni VARCHAR(9),
    fecha_publicacion DATE,
    genero TEXT,
    FOREIGN KEY (autor_dni) REFERENCES autores(dni)
);

CREATE TABLE usuarios (
    id_usuario VARCHAR(10) PRIMARY KEY,
    nombre TEXT NOT NULL,
    email TEXT UNIQUE,
    telefono TEXT,
    fecha_registro DATE
);

CREATE TABLE prestamos (
    id_prestamo VARCHAR(10) PRIMARY KEY,
    libro_id VARCHAR(10),
    usuario_id VARCHAR(10),
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (libro_id) REFERENCES libros(id_libro),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario)
);


INSERT INTO autores (dni, nombre, nacionalidad, fecha_nacimiento) VALUES
('12345678A', 'Gabriel García Márquez', 'Colombia', '1927-03-06'),
('98765432B', 'J.K. Rowling', 'Reino Unido', '1965-07-31'),
('11222333C', 'Isabel Allende', 'Chile', '1942-08-02'),
('44555666D', 'Mario Vargas Llosa', 'Perú', '1936-03-28');

-- Insertar 6 libros
INSERT INTO libros (id_libro, titulo, autor_dni, fecha_publicacion, genero) VALUES
('LIB-001', 'Cien años de soledad', '12345678A', '1967-05-30', 'Realismo mágico'),
('LIB-002', 'Harry Potter y la piedra filosofal', '98765432B', '1997-06-26', 'Fantasía'),
('LIB-003', 'La casa de los espíritus', '11222333C', '1982-01-01', 'Novela'),
('LIB-004', 'La ciudad y los perros', '44555666D', '1963-10-10', 'Novela'),
('LIB-005', 'Crónicas de una muerte anunciada', '12345678A', '1981-01-01', 'Novela'),
('LIB-006', 'El amor en los tiempos del cólera', '12345678A', '1985-03-12', 'Novela');

-- Insertar 5 usuarios
INSERT INTO usuarios (id_usuario, nombre, email, telefono, fecha_registro) VALUES
('USER-001', 'María López', 'mlopez@mail.com', '600111222', '2023-01-15'),
('USER-002', 'Carlos Ruiz', 'cruiz@mail.com', '600222333', '2023-02-20'),
('USER-003', 'Ana Martínez', 'amartinez@mail.com', '600333444', '2023-03-10'),
('USER-004', 'Pedro Sánchez', 'psanchez@mail.com', '600444555', '2023-04-05'),
('USER-005', 'Laura García', 'lgarcia@mail.com', '600555666', '2023-05-01');

-- Insertar 5 préstamos
INSERT INTO prestamos (id_prestamo, libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES
('PREST-001', 'LIB-001', 'USER-001', '2023-06-01', '2023-06-15'),
('PREST-002', 'LIB-002', 'USER-002', '2023-06-05', NULL),
('PREST-003', 'LIB-003', 'USER-003', '2023-05-20', '2023-06-10'),
('PREST-004', 'LIB-005', 'USER-004', '2023-06-10', NULL),
('PREST-005', 'LIB-004', 'USER-005', '2023-06-12', '2023-06-18');