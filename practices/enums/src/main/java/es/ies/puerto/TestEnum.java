package es.ies.puerto;

public class TestEnum {
    public static void main(String[] args) {
        Dia dia = Dia.LUNES;
        switch (dia) {
            case LUNES: case MARTES: case JUEVES: case VIERNES:
                System.out.println("Hay Programacion: " + dia);
                break;
            default:
                System.out.println("Hay Programacion: " + dia);
                break;
        }
    }
}