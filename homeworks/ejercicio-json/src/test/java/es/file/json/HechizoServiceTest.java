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

import es.file.json.tres.*;

class HechizoServiceTest {
   
    HechizoService hechizoService;
    Hechizo hechizo;

    @BeforeEach 
    void beforeEach() {
        hechizoService = new HechizoService();
        hechizo = new Hechizo(10, "Expelliarmus", "Defensivo", false, "1899-06-15");

        hechizoService.add(hechizo);
    }

    @AfterEach
    void afterEach() {
        hechizoService.delete(hechizo);
        Assertions.assertEquals(4, hechizoService.getList().size());
    } 

    @Test
    void HechizoNoEqualsTest() {
        String example = "example";
        Assertions.assertNotEquals(hechizo,example);
    }

    @Test
    void addHechizoTest() {
        Assertions.assertEquals(5, hechizoService.getList().size());
    }

    @Test
    void addHechizoNullTest() {
        boolean addHechizo = hechizoService.add(null);
        Assertions.assertFalse(addHechizo);
    }

    @Test
    void addHechizoExistTest() {
        boolean addHechizo = hechizoService.add(hechizo);
        Assertions.assertFalse(addHechizo);
    }

    @Test
    void searchHechizoByIdTest() {
        Hechizo hechizoSearch = hechizoService.findById(hechizo.getId());
        Assertions.assertEquals(hechizo,hechizoSearch);
        Assertions.assertEquals(hechizo.getEsOscuro(),hechizoSearch.getEsOscuro());
        Assertions.assertEquals(hechizo.getTipo(),hechizoSearch.getTipo());
        Assertions.assertEquals(hechizo.getNombre(),hechizoSearch.getNombre());
        Assertions.assertEquals(hechizo.isEsOscuro(),hechizoSearch.isEsOscuro());

    }

    @Test
    void searchHechizoByIdNotExistTest() {
        Hechizo hechizoSearch = hechizoService.findById(999);
        Assertions.assertNull(hechizoSearch); 
    }

    @Test
    void searchHechizoByIdNegativoTest() {
        Hechizo hechizoSearch = hechizoService.findById(-1);
        Assertions.assertNull(hechizoSearch); 
    }

    @Test
    void searchHechizoDeleteNotExistTest() {
        Hechizo hechizoSearch = new Hechizo(999);
        boolean delete = hechizoService.delete(hechizoSearch);
        Assertions.assertFalse(delete); 
    }

    @Test
    void searchListHechizosRangeExistTest() {
        List<Hechizo> hechizos = hechizoService.findByDateRange("1500-06-11", "1500-06-13");
        Assertions.assertEquals(1, hechizos.size());
    }

    @Test
    void searchListHechizosRangeNullTest() {
        List<Hechizo> hechizo = hechizoService.findByDateRange("2023-01-01", null);
        Assertions.assertNotNull(hechizo, "El resultado no es el esperado");
        Assertions.assertTrue(hechizo.isEmpty(), "La lista deberia estar vacia");
        List<Hechizo> hechizo2 = hechizoService.findByDateRange(null, null);
        Assertions.assertNotNull(hechizo2, "El resultado no es el esperado");
        Assertions.assertTrue(hechizo2.isEmpty(), "La lista deberia estar vacia");
    }

    @Test
    void deleteHechizoNullTest() {
        boolean result = hechizoService.delete(null);
        Assertions.assertFalse(result, "El resultado no es el esperado");
    }

    @Test
    void saveFileCatchTest() {
        File file = new File("/ruta/no/escribible");
        List<Hechizo> hechizos = Collections.emptyList();
        hechizoService.saveFile(file, hechizos);
        Assertions.assertTrue(true);
    }

    @Test
    void testConstructorVacio() {
        Hechizo hechizo = new Hechizo();
        assertNotNull(hechizo, "El objeto Caballero no deberia ser null");
    }

    @Test
    void testToString() {
        Hechizo hechizo = new Hechizo();
        hechizo.setId(1);
        hechizo.setNombre("Seiya");
        hechizo.setTipo("Pegasus");
        hechizo.setEsOscuro(true);
        hechizo.setFechaCreacion("2023-01-01");
        String expected = "Hechizo [id=1, nombre=Seiya, tipo=Pegasus, esOscuro=true, fechaCreacion=2023-01-01]";
        assertEquals(expected, hechizo.toString());
    }
}