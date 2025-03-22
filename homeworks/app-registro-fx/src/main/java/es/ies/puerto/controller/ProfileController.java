package es.ies.puerto.controller;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class ProfileController extends AbstractController {

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private Button buttonVolverAtras;

    /**
     * Metodo de inicializacion de la interfaz
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    /**
     * Carga los datos del usuario en los campos de la interfaz grafica
     * @param usuario El objeto Usuario con los datos que se mostraran en pantalla
     */
    public void cargarDatosUsuario(Usuario usuario) {
        if (usuario != null) {
            textFieldUsuario.setText(usuario.getUsuario());
            textFieldPassword.setText("******");
            textFieldNombre.setText(usuario.getNombre());
            textFieldEmail.setText(usuario.getEmail());
        }
    }

    /**
     * Maneja el evento de clic en el boton de volver atras
     * Redirige a la pantalla de inicio de sesion (login)
     */
    @FXML
    protected void onVolverAtrasClick() {
        String tituloPantalla = ConfigManager.ConfigProperties.getProperty("loginTitle");
        mostrarPantalla(buttonVolverAtras, "login.fxml", tituloPantalla);
    }
}