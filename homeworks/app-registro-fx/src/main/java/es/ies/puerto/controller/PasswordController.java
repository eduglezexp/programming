package es.ies.puerto.controller;

import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.Usuario;
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
    private TextField textFieldEmail;

    @FXML 
    private Button buttonAceptar;

    @FXML 
    private Text textMensaje;

    /**
     * Metodo que maneja el evento de clic en el boton de recuperacon de contrasenia
     * Verifica si el email ingresado es valido y si existe en el sistema
     * Muestra mensajes de error o exito segun el resultado
     */
    @FXML
    protected void onPasswordButtonClick() {
        if (textFieldEmail == null ||  textFieldEmail.getText().isEmpty()) {
            textMensaje.setText("¡El email no puede ser nulo o vacio!");
            return;
        }
        Usuario email = usuarioServiceJson.buscarUsuarioPorCriterio(textFieldEmail.getText(), Usuario::getEmail);
        if (email == null) {
            textMensaje.setText("¡No ha sido posible enviar el email!");
            return;
        }
        textMensaje.setText("El email se ha enviado correctamente");
    }
}