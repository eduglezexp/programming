package es.ies.puerto.clases;

/**
 * Ejercicio 12
 * Crea una clase Libro con los atributos titulo, autor y paginas. 
 * Usa getters y setters para cada atributo, y asegura que el número 
 * de páginas sea un entero positivo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Libro {
    private String titular;
    private String autor;
    private int paginas;
    
    /**
     * Constructor por defecto
     */
    public Libro() {
    }

    /**
     * Constructor con todas las propiedades
     * @param titular del libro
     * @param autor del libro
     * @param paginas del libro
     */
    public Libro(String titular, String autor, int paginas) {
        this.titular = titular;
        this.autor = autor;
        this.paginas = paginas;
    }

    /**
     * Getters and Setters
     */
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libro [titular=" + titular + ", autor=" + autor + ", paginas=" + paginas + "]";
    }
}
