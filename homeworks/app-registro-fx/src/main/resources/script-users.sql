DROP TABLE IF EXISTS usuarios;

DROP INDEX IF EXISTS idx_email;

CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    password TEXT NOT NULL
);

CREATE INDEX idx_email ON usuarios (email);

INSERT INTO usuarios (user, email, name, password) VALUES 
    ('Usuario-1', 'email1@example.com', 'Nombre1', 'contraseña123'),
    ('Usuario-2', 'email2@example.com', 'Nombre2', 'abc456'),
    ('Usuario-3', 'email3@example.com', 'Nombre3', 'xyz789');