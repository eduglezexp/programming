package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;

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
        List<String> idiomas = new ArrayList<>();
        idiomas.add("es");
        idiomas.add("en");
        idiomas.add("fr");
        comboIdioma.getItems().addAll(idiomas);
    }

    /**
     * Metodo para cambiar el idioma
     */
    @FXML
    protected void cambiarIdioma() {
        String path = "src/main/resources/idioma-" + comboIdioma.getValue().toString() + ".properties";
        //setPropertiesIdioma(loadIdioma("idioma", comboIdioma.getValue().toString()));
        //textUsuario.setText(getPropertiesIdioma().getProperty("textUsuario"));
        ConfigManager.ConfigProperties.setPath(path);
        textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
        textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
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
        boolean passwordCorrecta = usuario.getPassword().equals(textFieldPassword.getText());
        if (!passwordCorrecta) {
            textMensaje.setText("Contraseña incorrecta");
            return;
        }
        mostrarPantalla(openAceptarButton, "profile.fxml", "Pantalla Profile", usuario);
    }

    /**
     * Maneja el evento de clic en el boton de registro
     * Redirige a la pantalla de registro
     */
    @FXML
    protected void openRegistrarClick() {
        mostrarPantalla(openRegistrarButton, "registro.fxml", "Pantalla Registro");
    }

    /**
     * Maneja el evento de clic en el boton de recuperar contrasenia
     * Redirige a la pantalla de recuperacion de contrasenia
     */
    @FXML
    protected void openRecuperarContraseniaClick() {
        mostrarPantalla(buttonRecuperarContrasenia, "password.fxml", "Pantalla Recuperar Contraseña");
    }
}