
SELECT * FROM libros 
WHERE fecha_publicacion BETWEEN '1980-01-01' AND '1990-12-31';


SELECT * FROM prestamos 
WHERE fecha_devolucion IS NULL;

SELECT l.*, a.nombre as autor 
FROM libros l
JOIN autores a ON l.autor_dni = a.dni
WHERE a.dni = '12345678A';

SELECT * FROM usuarios
WHERE fecha_registro >= DATE('now', '-1 months');