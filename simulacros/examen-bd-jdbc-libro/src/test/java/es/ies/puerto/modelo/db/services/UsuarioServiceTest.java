package es.ies.puerto.modelo.db.services;

import es.ies.puerto.UtilidadesTest;
import es.ies.puerto.modelo.db.entidades.Usuario;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest extends UtilidadesTest{

    UsuarioService usuarioService = new UsuarioService();


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
}
