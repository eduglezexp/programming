package es.ies.puerto;

import es.ies.puerto.modelo.db.entidades.*;
import es.ies.puerto.modelo.db.services.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PruebaApp {
    static AutorService autorService = new AutorService();
    static LibroService libroService = new LibroService();
    static UsuarioService usuarioService = new UsuarioService();
    static PrestamoService prestamoService = new PrestamoService();

    public static void main(String[] args) {
        crearAutor();
        crearLibro();
        crearUsuario();
        crearPrestamo();

        mostrarAutores();
        mostrarLibros();
        mostrarUsuarios();
        mostrarPrestamos();

        prestamosPorUsuario("USR001");
        prestamosVencidos("2024-04-01");
        prestamosActivos();
        try {
            tearDown();
        } catch (Exception e) {
           e.printStackTrace();
        }
 
    }

    static Date getFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (Exception e) {
            return null;
        }
    }

    static void crearAutor() {
        Autor autor = new Autor("12345678A", "Gabriel García Márquez", "Colombia", getFecha("1927-03-06"));
        boolean creado = autorService.crearAutor(autor);
        System.out.println("Autor creado: " + creado);
    }

    static void crearLibro() {
        Libro libro = new Libro("LIB-001", "Cien años de soledad", "12345678A", getFecha("1967-05-30"), "Realismo mágico");
        boolean creado = libroService.crearLibro(libro);
        System.out.println("Libro creado: " + creado);
    }

    static void crearUsuario() {
        Usuario usuario = new Usuario("USR001", "Juan Pérez", "juan@example.com", "600123123", getFecha("2023-12-01"));
        boolean creado = usuarioService.crearUsuario(usuario);
        System.out.println("Usuario creado: " + creado);
    }

    static void crearPrestamo() {
        Prestamo prestamo = new Prestamo("PRE001", "LIB-001", "USR001", getFecha("2024-04-01"), getFecha("2024-05-01"));
        boolean creado = prestamoService.crearPrestamo(prestamo);
        System.out.println("Préstamo creado: " + creado);
    }

    static void mostrarAutores() {
        List<Autor> autores = autorService.obtenerTodosAutores();
        System.out.println("Autores:");
        autores.forEach(a -> System.out.println(" - " + a.getNombre()));
    }

    static void mostrarLibros() {
        List<Libro> libros = libroService.obtenerTodosLibros();
        System.out.println("Libros:");
        libros.forEach(l -> System.out.println(" - " + l.getTitulo()));
    }

    static void mostrarUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        System.out.println("Usuarios:");
        usuarios.forEach(u -> System.out.println(" - " + u.getNombre()));
    }

    static void mostrarPrestamos() {
        List<Prestamo> prestamos = prestamoService.obtenerTodosPrestamos();
        System.out.println("Préstamos:");
        prestamos.forEach(p -> System.out.println(" - ID: " + p.getIdPrestamo() + ", Libro: " + p.getLibroId() + ", Usuario: " + p.getUsuarioId()));
    }

    static void prestamosPorUsuario(String idUsuario) {
        List<Prestamo> prestamos = prestamoService.obtenerPrestamosPorUsuario(idUsuario);
        System.out.println("Préstamos del usuario " + idUsuario + ":");
        prestamos.forEach(p -> System.out.println(" - " + p.getIdPrestamo()));
    }

    static void prestamosVencidos(String fechaStr) {
        Date fecha = getFecha(fechaStr);
        List<Prestamo> vencidos = prestamoService.obtenerPrestamosVencidos(fecha);
        System.out.println("Préstamos vencidos antes de " + fechaStr + ":");
        vencidos.forEach(p -> System.out.println(" - " + p.getIdPrestamo()));
    }

    static void prestamosActivos() {
        List<Prestamo> activos = prestamoService.obtenerPrestamosActivos();
        System.out.println("Préstamos activos:");
        activos.forEach(p -> System.out.println(" - " + p.getIdPrestamo()));
    }
    static void tearDown() throws SQLException {
       
        File originalDB = new File("src/main/resources/biblioteca.db");
        File backupDB = new File("src/main/backup/biblioteca.db");  
        
        System.out.println("Path original: " + originalDB.getAbsolutePath());
        System.out.println("Path backup: " + backupDB.getAbsolutePath());
        System.out.println("Backup existe? " + backupDB.exists());
    

        if (!backupDB.exists()) {
            throw new SQLException("El archivo de backup no existe en: " + backupDB.getAbsolutePath());
        }
    

        if (originalDB.exists()) {
            boolean deleted = originalDB.delete();
            if (!deleted) {
                throw new SQLException("No se pudo eliminar la base de datos original");
            }
        }
    
        try {
            Files.copy(
                backupDB.toPath(),
                originalDB.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Base de datos restaurada exitosamente");
        } catch (IOException e) {
            throw new SQLException("Error copiando el backup", e);
        }
    }

}

