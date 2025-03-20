package es.ies.puerto.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.controller.ProfileController;
import es.ies.puerto.controller.RegistroController;
import es.ies.puerto.model.entities.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public abstract class AbstractController {

    private Properties propertiesIdioma;

    /**
     * Getters and Setters
     */
    public Properties getPropertiesIdioma() {
        return propertiesIdioma;
    }

    public void setPropertiesIdioma(Properties propertiesIdioma) {
        this.propertiesIdioma = propertiesIdioma;
    }

    /**
     * Metodo para cargar un idioma
     * @param nombreFichero a leer
     * @param idioma a cambiar
     * @return properties
     */
    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();
        if (nombreFichero == null || idioma == null) {
            return properties;
        }
        String path = "src/main/resources/" + nombreFichero + "-" + idioma + ".properties";
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Path: " +file.getAbsolutePath());
            return properties;
        }
        try {
            FileInputStream input = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            properties.load(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Metodo para mostrar una nueva pantalla en la aplicacion
     * @param button sirve para obtener la ventana actual
     * @param fxml La ruta al archivo FXML que define la interfaz de la nueva pantalla
     * @param titulo El titulo que se asignara a la ventana
     */
    public void mostrarPantalla(Button button, String fxml, String titulo) {
        if (button == null || fxml == null || fxml.isEmpty() || titulo == null || titulo.isEmpty()) {
            return;
        }
        try {
            Stage stage = (Stage) button.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            RegistroController registroController = fxmlLoader.getController();
            //registroController.setPropertiesIdioma(getPropertiesIdioma());
            //registroController.postConstructor();
            scene.getStylesheets().add(getClass().getResource("/es/ies/puerto/css/style.css").toExternalForm());
            Image icon = new Image(getClass().getResource("/es/ies/puerto/img/icon.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.setTitle(titulo);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para mostrar una nueva pantalla en la aplicacion
     * @param button sirve para obtener la ventana actual
     * @param fxml La ruta al archivo FXML que define la interfaz de la nueva pantalla
     * @param titulo El titulo que se asignara a la ventana
     * @param usuario contiene los datos que se cargaran en la nueva pantalla
     */
    public void mostrarPantalla(Button button, String fxml, String titulo, Usuario usuario) {
        if (button == null || fxml == null || fxml.isEmpty() || titulo == null || titulo.isEmpty()) {
            return;
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/es/ies/puerto/css/style.css").toExternalForm());
            ProfileController profileController = fxmlLoader.getController();
            profileController.cargarDatosUsuario(usuario);
            Stage stage = (Stage) button.getScene().getWindow();
            Image icon = new Image(getClass().getResource("/es/ies/puerto/img/icon.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.setTitle(titulo);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}