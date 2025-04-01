package es.ies.puerto.controller;

import java.sql.SQLException;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.UsuarioEntitySqlite;
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
    public Text textRegistroTitulo;

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
    private Button openRegistrarButton;

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
     * Maneja el evento de clic en el boton de registro
     * Valida los datos ingresados por el usuario y crea un nuevo usuario si son correctos
     * Muestra mensajes de error si los datos no cumplen con los requisitos
     */
    @FXML
    protected void onRegistrarButtonClick() {
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorUsuarioVacio"));
            return;
        }
        if (textFieldPassword == null ||  textFieldPassword.getText().isEmpty() 
            || textFieldPasswordRepit == null || textFieldPasswordRepit.getText().isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorPasswordVacio"));
            return;
        }
        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorNombreVacio"));
            return;
        }
        if (textFieldEmail == null ||  textFieldEmail.getText().isEmpty() 
            || textFieldEmailRepit == null || textFieldEmailRepit.getText().isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorEmailVacio"));
            return;
        }
        if (textFieldPassword.getText().length() < 6) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorPasswordLongitud"));
            return;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if (!emailPattern.matcher(textFieldEmail.getText()).matches()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorEmailFormato"));
            return;
        }
        boolean equalPassword = textFieldPassword.getText().equals(textFieldPasswordRepit.getText());
        boolean equalEmail = textFieldEmail.getText().equals(textFieldEmailRepit.getText());
        if (equalPassword && equalEmail) {
            //String hashedPassword = BCrypt.hashpw(textFieldPassword.getText(), BCrypt.gensalt());
            UsuarioEntitySqlite usuario = new UsuarioEntitySqlite(textFieldUsuario.getText(), textFieldEmail.getText(), 
            textFieldNombre.getText(), textFieldPassword.getText());
            try {
                boolean insertar = getUsuarioServiceSqlite().insertarUsuario(usuario);
                if (!insertar) {
                    textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorUsuarioExiste"));
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            /** Json
            UsuarioEntityJson usuario = new UsuarioEntityJson(textFieldUsuario.getText(), hashedPassword, 
            textFieldNombre.getText(), textFieldEmail.getText());
            boolean insertar = usuarioServiceJson.add(usuario);
            if (!insertar) {
                textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorUsuarioExiste"));
                return;
            }
            */
            String tituloPantalla = ConfigManager.ConfigProperties.getProperty("profileTitle");
            mostrarPantalla(openRegistrarButton, "profile.fxml", tituloPantalla, usuario);
            return;
        }
        textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorEmailOPasswordNoCoincide"));
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