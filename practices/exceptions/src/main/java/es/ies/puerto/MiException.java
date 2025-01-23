package es.ies.puerto;

public class MiException extends Exception{
    int tipo;

    public MiException() {
        super();
        tipo = 0;
    }

    public MiException(String mensaje) {
        super(mensaje);
        tipo = 0;
    }

    public MiException(String mensaje, int tipo) {
        super(mensaje);
        this.tipo = tipo;
    }
}