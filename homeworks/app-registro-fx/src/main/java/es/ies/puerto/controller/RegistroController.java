package es.ies.puerto.controller;

import es.ies.puerto.model.entities.Usuario;
import es.ies.puerto.model.services.UsuarioServiceJson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroController extends ControllerAbstract{

    UsuarioServiceJson usuarioServiceJson;
    
    public RegistroController() {
        usuarioServiceJson = new UsuarioServiceJson();
    }

    @FXML 
    private TextField textFiledUsuario;

    @FXML 
    private PasswordField textFieldPassword;

    @FXML 
    private PasswordField textFieldPasswordRepit;

    @FXML 
    private TextField textFieldNombre;

    @FXML 
    private TextField textFieldEmail;

    @FXML 
    private TextField textFieldEmailRepit;

    @FXML 
    private Text textMensaje;

    @FXML 
    private Button buttonRegistrar;

    @FXML
    protected void onRegistrarButtonClick() {
        if (textFieldPassword == null ||  textFieldPassword.getText().isEmpty() 
            || textFieldPasswordRepit == null || textFieldPasswordRepit.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }
        if (textFieldEmail == null ||  textFieldEmail.getText().isEmpty() 
            || textFieldEmailRepit == null || textFieldEmailRepit.getText().isEmpty()) {
            textMensaje.setText("¡El email no puede ser nulo o vacio!");
            return;
        }
        boolean equalPassword = textFieldPassword.getText().equals(textFieldPasswordRepit.getText());
        boolean equalEmail = textFieldEmail.getText().equals(textFieldEmailRepit.getText());
        if (equalPassword && equalEmail) {
            Usuario usuario = new Usuario(textFiledUsuario, textFieldPassword, textFieldNombre, textFieldEmail);
            usuarioServiceJson.add(usuario);
            mostrarPantalla(buttonRegistrar, "profile.fxml", "Pantalla Profile");
        }
        textMensaje.setText("¡Los valores del password o correo no coinciden!");
    }
}