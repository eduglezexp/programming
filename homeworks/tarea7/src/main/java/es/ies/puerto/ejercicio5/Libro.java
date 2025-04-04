package es.ies.puerto.ejercicio5;

/**
 * 5. Clase Libro con Sobrecarga de Constructores
 * Define una clase Libro con atributos titulo, autor y paginas. Crea varios constructores para 
 * inicializar diferentes combinaciones de estos atributos. Implementa toString() para devolver 
 * una descripción del libro.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Libro {
    private String titulo;
    private String autor;
    private int paginas;

    /**
     * Constructor por defecto
     */
    public Libro() {
        this.titulo = "Titulo desconocido";
        this.autor = "Autor desconocido";
    }

    /**
     * Constructor con la propiedad titulo
     * @param titulo del libro
     */
    public Libro(String titulo) {
        this.titulo = titulo;
        this.autor = "Autor desconocido";
    }

    /**
     * Constructor con la propiedades titulo y autor
     * @param titulo del libro
     * @param autor del libro
     */
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    /**
     * Constructor con todas las propiedades
     * @param titulo del libro
     * @param autor del libro
     * @param paginas del libro
     */
    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    /**
     * Getters and Setters
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
    }
}
