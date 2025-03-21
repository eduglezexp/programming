package es.ies.puerto.controller;

import org.mindrot.jbcrypt.BCrypt;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.Usuario;
import es.ies.puerto.model.services.UsuarioServiceJson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class LoginController extends AbstractController{
    
    private final String pathFichero="src/main/resources/";
    private final String ficheroStr= "idioma-";

    UsuarioServiceJson usuarioServiceJson;
    
    /**
     * Constructor por defecto
     */
    public LoginController() {
        usuarioServiceJson = new UsuarioServiceJson();
    }

    @FXML
    private ComboBox comboIdioma;

    @FXML
    private TextField textFieldUsuario;
    
    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Text textMensaje;

    @FXML
    private Text textUsuario;

    @FXML
    private Text textContrasenia;

    @FXML
    private Button openRegistrarButton;

    @FXML
    private Button openAceptarButton;

    @FXML
    private Button buttonRecuperarContrasenia;

    @FXML
    public void initialize() {
        comboIdioma.getItems().add("es");
        comboIdioma.getItems().add("en");
        comboIdioma.getItems().add("fr");
        String idioma = ConfigManager.ConfigProperties.getIdiomaActual();
        comboIdioma.setValue(idioma);
        cargarIdioma(idioma);
        cambiarIdioma();
    }

    @FXML
    protected void seleccionarIdiomaClick() {
        String idioma = comboIdioma.getValue().toString();
        ConfigManager.ConfigProperties.setIdiomaActual(idioma);
        cargarIdioma(idioma);
        cambiarIdioma();
    }

    private void cargarIdioma(String idioma) {
        String path = pathFichero+ficheroStr+idioma+".properties";
        ConfigManager.ConfigProperties.setPath(path);
    }

    /**
     * Maneja el evento de clic en el boton de inicio de sesion
     * Valida las credenciales del usuario y muestra mensajes de error si es necesario
     * Si las credenciales son correctas, se redirige a la pantalla de perfil
     */
    @FXML
    protected void onLoginButtonClick() {
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty() || 
            textFieldPassword == null || textFieldPassword.getText().isEmpty() ) {
            textMensaje.setText("¡Credenciales nulos o vacios!");
            return;
        }
        Usuario usuario = usuarioServiceJson.buscarUsuarioPorCriterio(textFieldUsuario.getText(), Usuario::getUsuario);
        if (usuario == null) {
            textMensaje.setText("Usuario no encontrado");
            return;
        }
        boolean passwordCorrecta = BCrypt.checkpw(textFieldPassword.getText(), usuario.getPassword());
        if (!passwordCorrecta) {
            textMensaje.setText("Contraseña incorrecta");
            return;
        }
        String tituloPantalla = ConfigManager.ConfigProperties.getProperty("profile.title");
        mostrarPantalla(openAceptarButton, "profile.fxml", tituloPantalla, usuario);
    }

    /**
     * Maneja el evento de clic en el boton de registro
     * Redirige a la pantalla de registro
     */
    @FXML
    protected void openRegistrarClick() {
        String tituloPantalla = ConfigManager.ConfigProperties.getProperty("registro.title");
        mostrarPantalla(openRegistrarButton, "registro.fxml", tituloPantalla);
    }

    /**
     * Maneja el evento de clic en el boton de recuperar contrasenia
     * Redirige a la pantalla de recuperacion de contrasenia
     */
    @FXML
    protected void openRecuperarContraseniaClick() {
        String tituloPantalla = ConfigManager.ConfigProperties.getProperty("password.title");
        mostrarPantalla(buttonRecuperarContrasenia, "password.fxml", tituloPantalla);
    }
}