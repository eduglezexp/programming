package es.ies.puerto.controller;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.UsuarioEntityJson;
import es.ies.puerto.model.services.UsuarioServiceJson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class PasswordController extends AbstractController{

    UsuarioServiceJson usuarioServiceJson;
    
    /**
     * Constructor por defecto
     */
    public PasswordController() {
        usuarioServiceJson = new UsuarioServiceJson();
    }

    @FXML 
    private Text textEmail;

    @FXML 
    private TextField textFieldEmail;

    @FXML 
    private Button openAceptarButton;

    @FXML 
    private Text textMensaje;

    /**
     * Metodo de inicializacion de la interfaz
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    /**
     * Metodo que maneja el evento de clic en el boton de recuperacon de contrasenia
     * Verifica si el email ingresado es valido y si existe en el sistema
     * Muestra mensajes de error o exito segun el resultado
     */
    @FXML
    protected void onPasswordButtonClick() {
        if (textFieldEmail == null ||  textFieldEmail.getText().isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorEmailVacioNulo"));
            return;
        }
        UsuarioEntityJson email = usuarioServiceJson.buscarUsuarioPorCriterio(textFieldEmail.getText(), UsuarioEntityJson::getEmail);
        if (email == null) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorEnviarEmail"));
            return;
        }
        textMensaje.setText(ConfigManager.ConfigProperties.getProperty("emailEnvioCorrecto"));
    }
}