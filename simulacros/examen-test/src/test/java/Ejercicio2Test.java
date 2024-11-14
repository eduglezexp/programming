import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import es.ies.examen.*;

class Ejercicio2Test {

    @Test
    public void testCalculateArea() {
        Rectangulo rect = new Rectangulo(5, 10);
        assertEquals(50.0, rect.calculateArea(), 0.001);

        Rectangulo square = new Rectangulo(4, 4);
        assertEquals(16.0, square.calculateArea(), 0.001);
    }

    @Test
    public void testCalculatePerimeter() {
        Rectangulo rect = new Rectangulo(5, 10);
        assertEquals(30.0, rect.calculatePerimeter(), 0.001);

        Rectangulo square = new Rectangulo(4, 4);
        assertEquals(16.0, square.calculatePerimeter(), 0.001);
    }
}   
