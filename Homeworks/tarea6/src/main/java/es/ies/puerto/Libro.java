package es.ies.puerto;

/**
 * Ejercicio 12
 * Crea una clase Libro con los atributos titulo, autor y paginas. 
 * Usa getters y setters para cada atributo, y asegura que el número 
 * de páginas sea un entero positivo.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Libro con título "El Quijote", autor "Cervantes", 
 * y 500 páginas. Asegúrate de que el número de páginas sea positivo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Libro {
    private String titular;
    private String autor;
    private int paginas;
    
    public Libro() {
    }

    public Libro(String titular, String autor, int paginas) {
        this.titular = titular;
        this.autor = autor;
        this.paginas = paginas;
    }

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

    public static void main(String[] args) {
        Libro libro = new Libro("El Quijote", "Cervantes", 500);
        System.out.println(libro);
    }
}
