package es.ies.puerto.modelo.db.services;

import org.junit.jupiter.api.*;

import es.ies.puerto.UtilidadesTest;
import es.ies.puerto.modelo.db.entidades.Autor;
import es.ies.puerto.modelo.db.entidades.Libro;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibroServiceTest extends UtilidadesTest{
    private LibroService libroService;
    private AutorService autorService;

    @BeforeEach
    void setUp()  {
        libroService = new LibroService();
        autorService = new AutorService();
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

    @Test
    void testObtenerLibrosPublicadosDespuesDe() {
        libroService.crearLibro(new Libro("TEST-007", "Libro Antiguo", "11111111A", getFecha("1975-01-01"), "Historia"));
        libroService.crearLibro(new Libro("TEST-008", "Libro Reciente", "22222222B", getFecha("1990-05-05"), "Ciencia ficción"));
        libroService.crearLibro(new Libro("TEST-009", "Libro Muy Reciente", "33333333C", getFecha("2021-08-08"), "Tecnología"));
        List<Libro> libros = libroService.obtenerLibrosPublicadosDespuesDe(1980);
        assertNotNull(libros);
        for (Libro libro : libros) {
            String fecha = libro.getFechaPublicacion(); 
            assertTrue(fecha.compareTo("1980-12-31") > 0, "Libro con fecha invalida: " + fecha);
        }
        assertFalse(libros.stream().anyMatch(libro -> "TEST-007".equals(libro.getIdLibro())));
    }

    @Test
    void obtenerLibrosAutoresTest() {
        Autor autor = new Autor("444", "Autor Conocido", "Chile", getFecha("1980-04-04"));
        autorService.crearAutor(autor);
        Libro libro = new Libro("TEST-010", "Libro Autor Conocido", "444", getFecha("2020-10-10"), "Biografía");
        assertTrue(libroService.crearLibro(libro));
        List<Libro> librosConAutores = libroService.obtenerLibrosAutores();
        assertNotNull(librosConAutores);
        assertFalse(librosConAutores.isEmpty());
        Libro resultado = librosConAutores.stream()
        .filter(l -> "TEST-010".equals(l.getIdLibro())).findFirst().orElse(null);
        assertNotNull(resultado, "El libro con autor no fue encontrado.");
        assertEquals("Libro Autor Conocido", resultado.getTitulo());
        assertEquals("444", resultado.getAutorDni());
    }
}
