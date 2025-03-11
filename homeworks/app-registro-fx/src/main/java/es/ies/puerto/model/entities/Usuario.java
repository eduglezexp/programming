package es.ies.puerto.model.entities;

import java.util.Objects;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Usuario {

    private TextField textFiledUsuario;

    private PasswordField textFieldPassword;

    private TextField textFieldNombre;
 
    private TextField textFieldEmail;

    public Usuario() {
    }

    public Usuario(TextField textFiledUsuario) {
        this.textFiledUsuario = textFiledUsuario;
    }

    public Usuario(TextField textFiledUsuario, PasswordField textFieldPassword,
        TextField textFieldNombre, TextField textFieldEmail) {
        this.textFiledUsuario = textFiledUsuario;
        this.textFieldPassword = textFieldPassword;
        this.textFieldNombre = textFieldNombre;
        this.textFieldEmail = textFieldEmail;
    }

    public TextField getTextFiledUsuario() {
        return textFiledUsuario;
    }

    public void setTextFiledUsuario(TextField textFiledUsuario) {
        this.textFiledUsuario = textFiledUsuario;
    }

    public PasswordField getTextFieldPassword() {
        return textFieldPassword;
    }

    public void setTextFieldPassword(PasswordField textFieldPassword) {
        this.textFieldPassword = textFieldPassword;
    }

    public TextField getTextFieldNombre() {
        return textFieldNombre;
    }

    public void setTextFieldNombre(TextField textFieldNombre) {
        this.textFieldNombre = textFieldNombre;
    }

    public TextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public void setTextFieldEmail(TextField textFieldEmail) {
        this.textFieldEmail = textFieldEmail;
    }

    @Override
    public String toString() {
        return textFiledUsuario + "," + textFieldPassword
                + "," + textFieldNombre + "," + textFieldEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(textFiledUsuario, usuario.textFiledUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textFiledUsuario);
    }
}