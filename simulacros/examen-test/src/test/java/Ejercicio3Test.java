import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import es.ies.examen.*;
class Ejercicio3Test {

    @Test
    void testToString() {
        Friki friki = new Friki(1, "Juan", 10, "Videojuegos");
        String expected = "Friki{identificador='1', nombre='Juan', nivelFrikismo='10', especialidad='Videojuegos'}";
        assertEquals(expected, friki.toString());
    }
    
    @Test
    void testEqualsSameIdDifferentProperties() {
        Friki friki1 = new Friki(1, "Juan", 10, "Videojuegos");
        Friki friki2 = new Friki(1, "Ana", 8, "Comics");
        assertTrue(friki1.equals(friki2));
    }
    
    @Test
    void testEqualsDifferentId() {
        Friki friki1 = new Friki(1, "Juan", 10, "Videojuegos");
        Friki friki2 = new Friki(2, "Juan", 10, "Videojuegos");
        assertFalse(friki1.equals(friki2));
    }
    
    @Test
    void testEqualsSameObject() {
        Friki friki = new Friki(1, "Juan", 10, "Videojuegos");
        assertTrue(friki.equals(friki));
    }
    
    @Test
    void testEqualsNull() {
        Friki friki = new Friki(1, "Juan", 10, "Videojuegos");
        assertFalse(friki.equals(null));
    }
    
    @Test
    void testEqualsDifferentClass() {
        Friki friki = new Friki(1, "Juan", 10, "Videojuegos");
        String notAFriki = "Not a Friki Object";
        assertFalse(friki.equals(notAFriki));
    }
}   