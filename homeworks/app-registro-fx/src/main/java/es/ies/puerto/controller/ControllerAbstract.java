package es.ies.puerto.controller;

import es.ies.puerto.PrincipalApplication;
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

public abstract class ControllerAbstract {

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