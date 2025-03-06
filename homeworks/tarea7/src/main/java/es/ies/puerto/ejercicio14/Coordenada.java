package es.ies.puerto.ejercicio14;

/**
 * 14. Clase Coordenada con Métodos Matemáticos
 * Define una clase Coordenada con atributos x y y. Implementa métodos para calcular 
 * la distancia a otra coordenada y el desplazamiento a partir de un ángulo y una distancia. 
 * Sobrescribe toString() para mostrar la coordenada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Coordenada {
    private float x;
    private float y;

    /**
     * Constructor por defecto
     */
    public Coordenada() {
    }

    /**
     * Constructor con todas las propiedades 
     * @param x
     * @param y
     */
    public Coordenada(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Funcion para calcular la distancia de las coordenadas
     * @param otraCoordenada
     * @return la distancia de las coordenadas
     */
    public float calcularDistancia(Coordenada otraCoordenada) {
        float dx = otraCoordenada.x - this.x;
        float dy = otraCoordenada.y - this.y;
        return (float) Math.sqrt(dx * dx + dy * dy); 
    }
    
    /**
     * Funcion para calcular el desplazamiento de las coordenadas
     * @param anguloGrados
     * @param distancia
     * @return las nuevas coordenadas al ser desplazadas
     */
    public Coordenada desplazar(float anguloGrados, float distancia) {
        float anguloRadianes = (float) Math.toRadians(anguloGrados); 
        double nuevoX = this.x + distancia * Math.cos(anguloRadianes);
        float nuevoXf = (float) nuevoX;
        double nuevoY = this.y + distancia * Math.sin(anguloRadianes);
        float nuevoYf = (float) nuevoY;
        return new Coordenada(nuevoXf, nuevoYf); 
    }

    @Override
    public String toString() {
        return "Coordenada [x=" + x + ", y=" + y + "]";
    }
}