package es.ies.puerto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadVariables {
    static Idioma defaul = Idioma.ESPANIOL;
    static String path = "src/main/resources/idioma-";
    static Properties properties;
    
    public static void main(String[] args) {
        properties = loadIdioma(defaul);
        System.out.println(properties.getProperty("etiquetaNombreUsuario"));

    }

    public static Properties loadIdioma(Idioma idioma) {
        switch (idioma) {
            case INGLES:
                path = path + "en" + ".properties";
                break;
            case ALEMAN:
                path = path + "gr" + ".properties";
                break;
            case FRANCES:
                path = path + "fr" + ".properties";
                break;
            default:
                path = path + "es" + ".properties";
                break;
        }
            Properties systemProperties = loadFile(path);
            return systemProperties;
        }
        
        public static Properties loadFile(String path) {
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return properties;
    }
}
