package es.ies.puerto.modelo.db.services;

import org.junit.jupiter.api.*;

import es.ies.puerto.UtilidadesTest;
import es.ies.puerto.modelo.db.entidades.Libro;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibroServiceTest extends UtilidadesTest{
    private LibroService libroService;

    @BeforeEach
    void setUp()  {
        libroService = new LibroService();
    }

    @Test
    void crearLibroTest() {
        Libro libro = new Libro();
        libro.setIdLibro("TEST-001");
        libro.setTitulo("Libro de prueba");
        libro.setAutorDni("12345678A");
        libro.setFechaPublicacion(getFecha("2020-01-01"));
        libro.setGenero("Prueba");

        assertTrue(libroService.crearLibro(libro));
        assertFalse(libroService.crearLibro(libro)); 
    }

    @Test
    void obtenerTodosLibrosTest() {
        int cantidadInicial = libroService.obtenerTodosLibros().size();

        libroService.crearLibro(new Libro("TEST-002", "Libro 1", "12345678A", getFecha("2022-05-05"), "Novela"));
        libroService.crearLibro(new Libro("TEST-003", "Libro 2", "98765432B", getFecha("2022-06-06"), "Fantasía"));

        List<Libro> libros = libroService.obtenerTodosLibros();
        assertEquals(cantidadInicial + 2, libros.size());
    }

    @Test
    void testObtenerLibroPorId() {
        Libro expected = new Libro("TEST-004", "Buscar Libro", "11222333C", getFecha("2023-01-01"), "Drama");
        libroService.crearLibro(expected);

        Libro actual = libroService.obtenerLibroPorId("TEST-004");
        assertNotNull(actual);
        assertEquals(expected.getIdLibro(), actual.getIdLibro());

        assertNull(libroService.obtenerLibroPorId("NO-EXISTE"));
    }

    @Test
    void testActualizarLibro() {
        Libro libro = new Libro("TEST-005", "Original", "44555666D", getFecha("2010-01-01"), "Acción");
        libroService.crearLibro(libro);

        libro.setTitulo("Actualizado");
        libro.setGenero("Terror");
        assertTrue(libroService.actualizarLibro(libro));

        Libro updated = libroService.obtenerLibroPorId("TEST-005");
        assertEquals("Actualizado", updated.getTitulo());
        assertEquals("Terror", updated.getGenero());
    }

    @Test
    void testEliminarLibro() {
        try {
            libroService.crearLibro(new Libro("TEST-006", "Eliminar", "12345678A", getFecha("2000-12-12"), "Suspenso"));
            assertTrue(libroService.eliminarLibro("TEST-006"));
            assertNull(libroService.obtenerLibroPorId("TEST-006"));

            assertFalse(libroService.eliminarLibro("NO-EXISTE"));
        } catch (Exception e) {
            Assertions.fail("No se ha obtenido el resultado esperado");
        }
    }

}
