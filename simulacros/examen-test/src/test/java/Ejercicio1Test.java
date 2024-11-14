import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import es.ies.examen.Ejercicio1;

class Ejercicio1Test {

    @Test
    void testSumaArray10() {
        assertEquals(10, Ejercicio1.sumArray(new int[]{1, 2, 3, 4}));
    }

    @Test
    void testSumaArray0() {
        assertEquals(0, Ejercicio1.sumArray(new int[]{})); 
    }

    @Test
    void testSumaArrayNegativo() {
        assertEquals(-10, Ejercicio1.sumArray(new int[]{-5, -5}));
    }

    @Test
    void testSumaArray15() {
        assertEquals(15, Ejercicio1.sumArray(new int[]{5, 5, 5}));
    }
}   