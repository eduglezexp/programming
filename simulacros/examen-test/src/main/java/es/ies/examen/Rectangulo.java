package es.ies.examen;

public class Rectangulo {
    private double width;
    private double height;

    /**
     * Constructor por defecto
     */
    public Rectangulo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param width
     * @param height
     */
    public Rectangulo(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Getters and Setters
     */
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2*(width + height);
    }

    @Override
    public String toString() {
        return "Rectangulo [width=" + width + ", height=" + height + "]";
    }
}