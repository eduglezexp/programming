package es.ies.puerto.modelo.db.services;

import es.ies.puerto.UtilidadesTest;
import es.ies.puerto.modelo.db.entidades.Autor;
import es.ies.puerto.modelo.db.entidades.Libro;
import es.ies.puerto.modelo.db.entidades.Prestamo;
import es.ies.puerto.modelo.db.entidades.Usuario;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;

class UsuarioServiceTest extends UtilidadesTest{

    UsuarioService usuarioService;
    PrestamoService prestamoService;
    AutorService autorService;
    LibroService libroService;

    @BeforeEach
    void setUp() throws Exception {
        usuarioService = new UsuarioService();
        prestamoService = new PrestamoService();
        autorService = new AutorService();
        libroService = new LibroService();
    }


    @Test
    void crearUsuarioTest() {
        Usuario usuario = new Usuario("USR001", "Prueba", "correo@prueba.com", "123456789", getFecha("2024-01-01"));
        assertTrue(usuarioService.crearUsuario(usuario));
        assertFalse(usuarioService.crearUsuario(usuario));
    }

    @Test
    void obtenerTodosUsuariosTest() {
        int inicial = usuarioService.obtenerTodosUsuarios().size();

        usuarioService.crearUsuario(new Usuario("USR002", "Juan", "juan@correo.com", "111", new Date()));
        usuarioService.crearUsuario(new Usuario("USR003", "Ana", "ana@correo.com", "222", new Date()));

        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        assertEquals(inicial + 2, usuarios.size());
    }

    @Test
    void testObtenerUsuarioPorId() {
        Usuario esperado = new Usuario("USR004", "Buscado", "buscado@correo.com", "333", getFecha("2023-01-01"));
        usuarioService.crearUsuario(esperado);

        Usuario actual = usuarioService.obtenerUsuarioPorId("USR004");
        assertNotNull(actual);
        assertEquals("USR004", actual.getIdUsuario());

        assertNull(usuarioService.obtenerUsuarioPorId("NOEXISTE"));
    }

    @Test
    void testActualizarUsuario() {
        Usuario usuario = new Usuario("USR005", "Nombre", "old@correo.com", "444", null);
        usuarioService.crearUsuario(usuario);

        usuario.setNombre("NuevoNombre");
        usuario.setEmail("nuevo@correo.com");
        assertTrue(usuarioService.actualizarUsuario(usuario));

        Usuario actualizado = usuarioService.obtenerUsuarioPorId("USR005");
        assertEquals("NuevoNombre", actualizado.getNombre());
        assertEquals("nuevo@correo.com", actualizado.getEmail());
    }

    @Test
    void testEliminarUsuario() {
        usuarioService.crearUsuario(new Usuario("USR006", "Eliminar", "delete@correo.com", "555", null));
        assertTrue(usuarioService.eliminarUsuario("USR006"));
        assertNull(usuarioService.obtenerUsuarioPorId("USR006"));

        assertFalse(usuarioService.eliminarUsuario("NOEXISTE"));
    }

    @Test
    void testObtenerUsuariosRegistradosEn() {
        usuarioService.crearUsuario(new Usuario("USR007", "Usuario 2023", "u2023@correo.com", "111", getFecha("2023-05-10")));
        usuarioService.crearUsuario(new Usuario("USR008", "Usuario 2024", "u2024@correo.com", "222", getFecha("2024-03-15")));
        usuarioService.crearUsuario(new Usuario("USR009", "Usuario 2024 bis", "u2024b@correo.com", "333", getFecha("2024-07-01")));
        List<Usuario> usuarios2024 = usuarioService.obtenerUsuariosRegistradosEn(2024);
        assertNotNull(usuarios2024);
        assertTrue(usuarios2024.stream().anyMatch(u -> "USR008".equals(u.getIdUsuario())));
        assertTrue(usuarios2024.stream().anyMatch(u -> "USR009".equals(u.getIdUsuario())));
        assertTrue(usuarios2024.stream().noneMatch(u -> "USR007".equals(u.getIdUsuario())));
        List<Usuario> usuarios2023 = usuarioService.obtenerUsuariosRegistradosEn(2023);
        assertNotNull(usuarios2023);
        assertTrue(usuarios2023.stream().anyMatch(u -> "USR007".equals(u.getIdUsuario())));
        assertTrue(usuarios2023.stream().noneMatch(u -> "USR008".equals(u.getIdUsuario())));
    }
}
