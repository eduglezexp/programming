package es.ies.puerto.file.uno;

public class App {
    public static void main(String[] args) throws Exception {
        FileXmlCriatura operaciones = new FileXmlCriatura();
        Criatura criatura = new Criatura("DG001", "Elfo", "potter", "draco");
        operaciones.updateCriatura(criatura);
        System.out.println(operaciones.obtener(criatura));
    }
}
