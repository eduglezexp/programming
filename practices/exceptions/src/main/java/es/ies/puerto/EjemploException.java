package es.ies.puerto;

public class EjemploException {
    public static void main(String[] args) {
        try {
            int valor = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Siempre se ejecuta");
        }
    }
}