package es.ies.puerto.modelo.db.services;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ies.puerto.UtilidadesTest;
import es.ies.puerto.modelo.db.entidades.Autor;

class AutorServiceTest extends UtilidadesTest{
    private AutorService autorService;

    @BeforeEach
    void setUp() {
        autorService = new AutorService();
    }

    @Test
    void crearAutorTest() {
        Autor autor = new Autor("123", "Test Autor", "España", getFecha("2000-01-01"));
        assertTrue(autorService.crearAutor(autor));
        assertFalse(autorService.crearAutor(autor));
    }

    @Test
    void obtenerTodosAutoresTest() {
        assertEquals(4, autorService.obtenerTodosAutores().size());
        
        autorService.crearAutor(new Autor("456", "Autor 1", "Francia", new Date()));
        autorService.crearAutor(new Autor("789", "Autor 2", "Italia", new Date()));
        
        List<Autor> autores = autorService.obtenerTodosAutores();
        assertEquals(6, autores.size());
    }

    @Test
    void testObtenerAutorPorDni() {
        Autor expected = new Autor("111", "Test", "Alemania", getFecha("1990-05-05"));
        autorService.crearAutor(expected);
        
        Autor actual = autorService.obtenerAutorPorDni("111");
        assertNotNull(actual);
        assertEquals(expected.getDni(), actual.getDni());
        
        assertNull(autorService.obtenerAutorPorDni("999"));
    }

    @Test
    void testActualizarAutor() {
        Autor autor = new Autor("222", "Original", "Portugal", null);
        autorService.crearAutor(autor);
        
        autor.setNombre("Actualizado");
        autor.setNacionalidad("Brasil");
        assertTrue(autorService.actualizarAutor(autor));
        
        Autor updated = autorService.obtenerAutorPorDni("222");
        assertEquals("Actualizado", updated.getNombre());
        assertEquals("Brasil", updated.getNacionalidad());
    }

    @Test
    void testEliminarAutor()  {
        try {
            autorService.crearAutor(new Autor("333", "Eliminar", "Grecia", null));
            assertTrue(autorService.eliminarAutor("333"));
            assertNull(autorService.obtenerAutorPorDni("333"));
            
            assertFalse(autorService.eliminarAutor("12345699B"));
        } catch (Exception e) {
            Assertions.fail("No se ha obtenido el resultado esperado");
        }
    } 

    @Test
    void testObtenerNacionalidadAutor() {
        autorService.crearAutor(new Autor("NAT001", "Autor Español", "España", getFecha("1970-01-01")));
        autorService.crearAutor(new Autor("NAT002", "Autor Francés", "Francia", getFecha("1980-02-02")));
        autorService.crearAutor(new Autor("NAT003", "Otro Español", "España", getFecha("1990-03-03")));
        List<Autor> autoresEspanioles = autorService.obtenerNacionalidadAutor("España");
        assertNotNull(autoresEspanioles);
        assertFalse(autoresEspanioles.isEmpty(), "La lista de autores no debería estar vacía");
        assertTrue(autoresEspanioles.stream().allMatch(a -> "España".equals(a.getNacionalidad())),
                "Todos los autores deberían ser de nacionalidad 'España'");
        assertTrue(autoresEspanioles.stream().anyMatch(a -> "NAT001".equals(a.getDni())));
        assertTrue(autoresEspanioles.stream().anyMatch(a -> "NAT003".equals(a.getDni())));
        assertFalse(autoresEspanioles.stream().anyMatch(a -> "NAT002".equals(a.getDni())));
    }
}
