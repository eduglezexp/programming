package es.ies.puerto.ejercicio40;

/**
 * 40. Clase Biblioteca Digital con E-books
 * Crea una clase BibliotecaDigital que almacene una lista (array) de e-books 
 * (clase EBook (con las propiedades: nombre isbn, y anio)). Implementa métodos 
 * para agregar, eliminar y buscar libros, y usa toString() para mostrar los detalles 
 * de la biblioteca.
 * @author eduglezexp
 * @version 1.0.0
 */

public class BibliotecaDigital {
    private int numeroEBooks;
    private String nombre;
    private EBook[] eBooks;

    /**
     * Constructor por defecto
     */
    public BibliotecaDigital() {
        this.numeroEBooks = 0;
        this.eBooks = new EBook[10];
    }
    

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public BibliotecaDigital(String nombre) {
        this.nombre = nombre;
        this.numeroEBooks = 0;
        this.eBooks = new EBook[10];
    }

    /**
     * Metodo para agregar un ebook a la biblioteca digital
     * @param ebook 
     * @return true/false
     */
    public boolean addEBook(EBook ebook) {
        if (ebook == null) {
            return false;
        }
        if (numeroEBooks >= eBooks.length) {
            return false;
        }
        eBooks[numeroEBooks] = ebook;
        numeroEBooks++;
        return true;
    }

    /**
     * Metodo para eliminar un ebook de la biblioteca digital
     * @param ebook
     * @return true/false
     */
    public boolean deleteEbook(EBook ebook) {
        if (ebook == null) {
            return false;
        }
        if (numeroEBooks == 0) {
            return false;
        }
        for (int i = 0; i < eBooks.length; i++) {
            if (ebook.equals(eBooks[i])) {
                eBooks[i] = null;
                numeroEBooks--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un ebook
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < eBooks.length; i++) {
            if (eBooks[i] != null) {
                eBooks[index++] = eBooks[i];
            }
        }
        while (index < eBooks.length) {
            eBooks[index++] = null;
        }
    }

    /**
     * Metodo para buscar un ebook por su nombre
     * @param nombre
     * @return EBook encontrado o null si no existe
     */
    public EBook buscarEbook(String nombre) {
        for (int i = 0; i < numeroEBooks; i++) {
            if (eBooks[i] != null && eBooks[i].getNombre().equalsIgnoreCase(nombre)) {
                return eBooks[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroEBooks; i++) {
            mensaje += eBooks[i];
        }
        return mensaje;
    }
}