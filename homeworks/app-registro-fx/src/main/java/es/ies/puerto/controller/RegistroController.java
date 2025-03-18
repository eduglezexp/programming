package es.ies.puerto.controller;

import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.Usuario;
import es.ies.puerto.model.services.UsuarioServiceJson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class RegistroController extends AbstractController{

    UsuarioServiceJson usuarioServiceJson;
    
    /**
     * Constructor por defecto
     */
    public RegistroController() {
        usuarioServiceJson = new UsuarioServiceJson();
    }

    @FXML 
    private TextField textFieldUsuario;

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

    /**
     * Maneja el evento de clic en el boton de registro
     * Valida los datos ingresados por el usuario y crea un nuevo usuario si son correctos
     * Muestra mensajes de error si los datos no cumplen con los requisitos
     */
    @FXML
    protected void onRegistrarButtonClick() {
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textMensaje.setText("¡El usuario no puede ser nulo o vacio!");
            return;
        }
        if (textFieldPassword == null ||  textFieldPassword.getText().isEmpty() 
            || textFieldPasswordRepit == null || textFieldPasswordRepit.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }
        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText("¡El nombre no puede ser nulo o vacio!");
            return;
        }
        if (textFieldEmail == null ||  textFieldEmail.getText().isEmpty() 
            || textFieldEmailRepit == null || textFieldEmailRepit.getText().isEmpty()) {
            textMensaje.setText("¡El email no puede ser nulo o vacio!");
            return;
        }
        if (textFieldPassword.getText().length() < 6) {
            textMensaje.setText("¡La contraseña debe tener al menos 6 caracteres!");
            return;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if (!emailPattern.matcher(textFieldEmail.getText()).matches()) {
            textMensaje.setText("¡El formato del correo no es válido!");
            return;
        }
        boolean equalPassword = textFieldPassword.getText().equals(textFieldPasswordRepit.getText());
        boolean equalEmail = textFieldEmail.getText().equals(textFieldEmailRepit.getText());
        if (equalPassword && equalEmail) {
            String hashedPassword = BCrypt.hashpw(textFieldPassword.getText(), BCrypt.gensalt());
            Usuario usuario = new Usuario(textFieldUsuario.getText(), hashedPassword, 
            textFieldNombre.getText(), textFieldEmail.getText());
            boolean insertar = usuarioServiceJson.add(usuario);
            if (insertar == false) {
                textMensaje.setText("¡El usuario ya existe!");
                return;
            }
            mostrarPantalla(buttonRegistrar, "profile.fxml", "Pantalla Profile", usuario);
            return;
        }
        textMensaje.setText("¡Los valores del password o correo no coinciden!");
    }
}