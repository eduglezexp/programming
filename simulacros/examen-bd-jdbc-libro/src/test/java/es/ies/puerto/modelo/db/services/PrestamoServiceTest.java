package es.ies.puerto.modelo.db.services;

import es.ies.puerto.modelo.db.entidades.Prestamo;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoServiceTest {

    PrestamoService prestamoService = new PrestamoService();

    Date getFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    void crearPrestamoTest() {
        Prestamo prestamo = new Prestamo("PRE001", "LIB-001", "USR001", getFecha("2024-04-01"), getFecha("2024-05-01"));
        assertTrue(prestamoService.crearPrestamo(prestamo));
        //verifico que no se puede insertar dos veces
        assertFalse(prestamoService.crearPrestamo(prestamo)); 
    }

    @Test
    void obtenerTodosPrestamosTest() {
        int inicial = prestamoService.obtenerTodosPrestamos().size();

        prestamoService.crearPrestamo(new Prestamo("PRE002", "LIB-002", "USR002", getFecha("2024-03-01"), getFecha("2024-03-30")));
        prestamoService.crearPrestamo(new Prestamo("PRE003", "LIB-003", "USR003", getFecha("2024-02-01"), getFecha("2024-02-28")));

        List<Prestamo> prestamos = prestamoService.obtenerTodosPrestamos();
        assertEquals(inicial + 2, prestamos.size());
    }

    @Test
    void obtenerPrestamoPorIdTest() {
        Prestamo esperado = new Prestamo("PRE004", "LIB-004", "USR004", getFecha("2024-01-01"), getFecha("2024-01-20"));
        prestamoService.crearPrestamo(esperado);

        Prestamo actual = prestamoService.obtenerPrestamoPorId("PRE004");
        assertNotNull(actual);
        assertEquals("PRE004", actual.getIdPrestamo());

        assertNull(prestamoService.obtenerPrestamoPorId("NOEXISTE"));
    }

    @Test
    void actualizarPrestamoTest() {
        Prestamo prestamo = new Prestamo("PRE005", "LIB-005", "USR005", getFecha("2024-01-01"), getFecha("2024-01-15"));
        prestamoService.crearPrestamo(prestamo);

        prestamo.setLibroId("LIB-006");
        prestamo.setFechaDevolucion(getFecha("2024-02-01"));
        assertTrue(prestamoService.actualizarPrestamo(prestamo));

        Prestamo actualizado = prestamoService.obtenerPrestamoPorId("PRE005");
        assertEquals("LIB-006", actualizado.getLibroId());
    }

    @Test
    void eliminarPrestamoTest() {
        prestamoService.crearPrestamo(new Prestamo("PRE006", "LIB-001", "USR001", getFecha("2024-04-15"), getFecha("2024-04-30")));
        assertTrue(prestamoService.eliminarPrestamo("PRE006"));
        assertNull(prestamoService.obtenerPrestamoPorId("PRE006"));

        assertFalse(prestamoService.eliminarPrestamo("NOEXISTE"));
    }

    @Test
void obtenerPrestamosVencidosTest() {
    prestamoService.crearPrestamo(new Prestamo("PRE007", "LIB-007", "USR007", getFecha("2023-01-01"), getFecha("2023-02-01")));
    prestamoService.crearPrestamo(new Prestamo("PRE008", "LIB-008", "USR007", getFecha("2024-01-01"), getFecha("2025-01-01")));

    List<Prestamo> vencidos = prestamoService.obtenerPrestamosVencidos(getFecha("2024-01-01"));
    assertTrue(vencidos.stream().anyMatch(p -> p.getIdPrestamo().equals("PRE007")));
    assertTrue(vencidos.stream().noneMatch(p -> p.getIdPrestamo().equals("PRE008")));
}

@Test
void obtenerPrestamosPorUsuarioTest() {
    prestamoService.crearPrestamo(new Prestamo("PRE009", "LIB-009", "USR008", getFecha("2024-04-01"), getFecha("2024-04-20")));
    prestamoService.crearPrestamo(new Prestamo("PRE010", "LIB-010", "USR008", getFecha("2024-04-02"), getFecha("2024-04-25")));

    List<Prestamo> prestamos = prestamoService.obtenerPrestamosPorUsuario("USR008");
    assertEquals(2, prestamos.size());
    assertTrue(prestamos.stream().allMatch(p -> p.getUsuarioId().equals("USR008")));
}

@Test
void obtenerPrestamosActivosTest() {
    Date hoy = new Date();
    Calendar futuro = Calendar.getInstance();
    futuro.add(Calendar.DAY_OF_MONTH, 10);

    prestamoService.crearPrestamo(new Prestamo("PRE011", "LIB-011", "USR009", getFecha("2024-04-10"), getFecha("2024-04-15")));
    prestamoService.crearPrestamo(new Prestamo("PRE012", "LIB-012", "USR009", getFecha("2024-04-20"), futuro.getTime()));

    List<Prestamo> activos = prestamoService.obtenerPrestamosActivos();
    assertTrue(activos.stream().anyMatch(p -> p.getIdPrestamo().equals("PRE012")));
    assertTrue(activos.stream().noneMatch(p -> p.getIdPrestamo().equals("PRE011")));
}


    
}
