package es.ies.puerto.file.tres;

public class app {
    public static void main(String[] args) {
        FileArmasCsv operaciones = new FileArmasCsv();
        Arma arma = new Arma("007", "pokeball, de oro", "\"una pokeball, es mucho mas peligros de lo que suena, creo\"", "pueblo paleta", 1);
        
        System.out.println(operaciones.obtenerArmas());
    }
    
    
}
