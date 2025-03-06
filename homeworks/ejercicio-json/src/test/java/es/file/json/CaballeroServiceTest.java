package es.file.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.file.json.uno.*;

class CaballeroServiceTest {
   
    CaballeroService caballeroService;
    Caballero caballero;

    @BeforeEach 
    void beforeEach() {
        caballeroService = new CaballeroService();
        caballero =  new Caballero(7, "Seila","Pegaso", 10, "2025-02-28");
        caballeroService.add(caballero);
    }

    @AfterEach
    void afterEach() {
        caballeroService.delete(caballero);
        Assertions.assertEquals(4, caballeroService.getList().size());
    } 

    @Test
    void caballeroNoEqualsTest() {
        String example = "example";
        Assertions.assertNotEquals(caballero,example);
    }

    @Test
    void addTributoTest() {
        Assertions.assertEquals(5, caballeroService.getList().size());
    }

    @Test
    void addTributoNullTest() {
        boolean addTributo = caballeroService.add(null);
        Assertions.assertFalse(addTributo);
    }

    @Test
    void addTributoExistTest() {
        boolean addTributo = caballeroService.add(caballero);
        Assertions.assertFalse(addTributo);
    }

    @Test
    void searchCaballeroByIdTest() {
        Caballero caballeroSearch = caballeroService.findById(caballero.getId());
        Assertions.assertEquals(caballero,caballeroSearch);
    }

    @Test
    void searchTributoByIdNotExistTest() {
        Caballero caballeroSearch = caballeroService.findById(999);
        Assertions.assertNull(caballeroSearch); 
    }

    @Test
    void searchTributoByIdNegativoTest() {
        Caballero caballeroSearch = caballeroService.findById(-1);
        Assertions.assertNull(caballeroSearch); 
    }

    @Test
    void searchTributoDeleteNotExistTest() {
        Caballero caballeroNotExist = new Caballero(999);
        boolean delete = caballeroService.delete(caballeroNotExist);
        Assertions.assertFalse(delete); 
    }

    @Test
    void searchListCaballerosRangeExistTest() {
        List<Caballero> caballeros = caballeroService.findByDateRange("1986-10-11", "1986-10-13");
        Assertions.assertEquals(3, caballeros.size());
    }

    @Test
    void searchListCaballerosRangeNullTest() {
        List<Caballero> caballeros = caballeroService.findByDateRange("2023-01-01", null);
        Assertions.assertNotNull(caballeros, "El resultado no es el esperado");
        Assertions.assertTrue(caballeros.isEmpty(), "La lista deberia estar vacia");
        List<Caballero> caballeros2 = caballeroService.findByDateRange(null, null);
        Assertions.assertNotNull(caballeros2, "El resultado no es el esperado");
        Assertions.assertTrue(caballeros2.isEmpty(), "La lista deberia estar vacia");
    }

    @Test
    void deleteCaballeroNullTest() {
        boolean result = caballeroService.delete(null);
        Assertions.assertFalse(result, "El resultado no es el esperado");
    }

    @Test
    void saveFileCatchTest() {
        File file = new File("/ruta/no/escribible");
        List<Caballero> caballeros = Collections.emptyList();
        caballeroService.saveFile(file, caballeros);
        Assertions.assertTrue(true);
    }

    @Test
    void testConstructorVacio() {
        Caballero caballero = new Caballero();
        assertNotNull(caballero, "El objeto Caballero no deberia ser null");
    }

    @Test
    void testToString() {
        Caballero caballero = new Caballero();
        caballero.setId(1);
        caballero.setNombre("Seiya");
        caballero.setConstelacion("Pegasus");
        caballero.setNivel(10);
        caballero.setFechaIngreso("2023-01-01");
        String expected = "Caballero [id=1, nombre=Seiya, constelacion=Pegasus, nivel=10, fechaIngreso=2023-01-01]";
        assertEquals(expected, caballero.toString());
    }
}