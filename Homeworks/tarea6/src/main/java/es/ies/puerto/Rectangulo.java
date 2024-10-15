package es.ies.puerto;

/**
 * Ejercicio 5
 * Crea una clase llamada Rectangulo con los atributos base y altura. 
 * Implementa un método que calcule el área del rectángulo. 
 * Usa getters y setters para los atributos.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Rectangulo con base 5 y altura 10. 
 * Muestra el área calculada del rectángulo.
 * Ejercicio 6
 * Añade un método en la clase Rectangulo que calcule el perímetro del rectángulo.
 * La fórmula para calcular el perímetro de un rectángulo es:
 *  𝑃 = 2⋅(𝑏+ℎ)
 * Donde:
 *  P es el perímetro.
 *  b es la longitud de la base del rectángulo.
 *  h es la altura del rectángulo.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Rectangulo con base 4 y altura 7. 
 * Muestra el perímetro calculado del rectángulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Rectangulo {
    private float base;
    private float altura;

    public Rectangulo() {

    }

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calcularArea() {
        return base * altura;
    }
    
    public float calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return "Rectangulo [base=" + base + ", altura=" + altura + "]";
    }

    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(5, 10);
        float area = rectangulo1.calcularArea();
        System.out.println(rectangulo1+ " Area: " +area);
        Rectangulo rectangulo2 = new Rectangulo(4, 7);
        float perimetro = rectangulo2.calcularPerimetro();
        System.out.println(rectangulo2+ " Perimetro: " +perimetro);
    }
}