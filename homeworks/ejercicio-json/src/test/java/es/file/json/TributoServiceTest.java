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

import es.file.json.dos.*;

class TributoServiceTest {
   
    TributoService tributoService;
    Tributo tributo;

    @BeforeEach 
    void beforeEach() {
        tributoService = new TributoService();
        tributo = new Tributo(5, "Dios" , 12, false, "2025-02-28");
        tributoService.add(tributo);
    }

    @AfterEach
    void afterEach() {
        tributoService.delete(tributo);
        Assertions.assertEquals(4, tributoService.getList().size());
    } 

    @Test
    void tributoNoEqualsTest() {
        String example = "example";
        Assertions.assertNotEquals(tributo,example);
    }

    @Test
    void addTributoTest() {
        Assertions.assertEquals(5, tributoService.getList().size());
    }

    @Test
    void addTributoNullTest() {
        boolean addTributo = tributoService.add(null);
        Assertions.assertFalse(addTributo);
    }

    @Test
    void addTributoExistTest() {
        boolean addTributo = tributoService.add(tributo);
        Assertions.assertFalse(addTributo);
    }

    @Test
    void searchTributoByIdTest() {
        Tributo tributoSearch = tributoService.findById(tributo.getId());
        Assertions.assertEquals(tributo,tributoSearch);
        Assertions.assertEquals(tributo.getVoluntario(),tributoSearch.getVoluntario());
        Assertions.assertEquals(tributo.isVoluntario(),tributoSearch.isVoluntario());
    }

    @Test
    void searchTributoByIdNotExistTest() {
        Tributo tributoSearch = tributoService.findById(999);
        Assertions.assertNull(tributoSearch); 
    }

    @Test
    void searchTributoByIdNegativoTest() {
        Tributo tributoSearch = tributoService.findById(-1);
        Assertions.assertNull(tributoSearch); 
    }

    @Test
    void searchTributoDeleteNotExistTest() {
        Tributo tributoNotExist = new Tributo(999);
        boolean delete = tributoService.delete(tributoNotExist);
        Assertions.assertFalse(delete); 
    }

    @Test
    void searchListTributosRangeExistTest() {
        List<Tributo> tributos = tributoService.findByDateRange("1970-04-15", "2000-04-15");
        Assertions.assertEquals(2, tributos.size());
    }

    @Test
    void searchListCaballerosRangeNullTest() {
        List<Tributo> tributos = tributoService.findByDateRange("2023-01-01", null);
        Assertions.assertNotNull(tributos, "El resultado no es el esperado");
        Assertions.assertTrue(tributos.isEmpty(), "La lista deberia estar vacia");
        List<Tributo> tributos2 = tributoService.findByDateRange(null, null);
        Assertions.assertNotNull(tributos2, "El resultado no es el esperado");
        Assertions.assertTrue(tributos2.isEmpty(), "La lista deberia estar vacia");
    }

    @Test
    void deleteTributoNullTest() {
        boolean result = tributoService.delete(null);
        Assertions.assertFalse(result, "El resultado no es el esperado");
    }

    @Test
    void saveFileCatchTest() {
        File file = new File("/ruta/no/escribible");
        List<Tributo> tributos = Collections.emptyList();
        tributoService.saveFile(file, tributos);
        Assertions.assertTrue(true);
    }

    @Test
    void testConstructorVacio() {
        Tributo tributo = new Tributo();
        assertNotNull(tributo, "El objeto Caballero no deberia ser null");
    }

    @Test
    void testToString() {
        Tributo tributo = new Tributo();
        tributo.setId(1);
        tributo.setNombre("Seiya");
        tributo.setDistrito(9);
        tributo.setVoluntario(true);
        tributo.setFechaSeleccion("2023-01-01");
        String expected = "Tributo [id=1, nombre=Seiya, distrito=9, voluntario=true, fechaSeleccion=2023-01-01]";
        assertEquals(expected, tributo.toString());
    }
}