/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import business.model.Usuario;
import infra.errorMessageException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aliso
 */
public class LoginController implements Initializable {

    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField SenhaPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    private AnchorPane AnchorPane;

    public static Usuario user;

    //Atributos para manipulação de Banco de Dados SQL
    /*
    private final DatabaseSQL database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final CadastroDAO CadastroDAO = new CadastroDAO();

     */
    @FXML
    private void handleButtonLogin(ActionEvent event) throws errorMessageException {

        user = new Usuario();
        AdapterLogin api = new AdapterLogin();
        if (!LoginTextField.getText().equalsIgnoreCase("") && !SenhaPasswordField.getText().equalsIgnoreCase("")) {
            user.setLogin(LoginTextField.getText());
            user.setSenha(SenhaPasswordField.getText());

            if (api.usuarioExiste(user)) {
                if (api.login(user)) {
                    try {
                        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLIndex.fxml"));
                        AnchorPane.getChildren().setAll(a);

                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    errorMessageExceptionAmigavel("Campo Login ou senha incorreto");
                }
            } else {
                errorMessageExceptionAmigavel("Usuario não existe");
            }

        } else {
            errorMessageExceptionAmigavel("Campo Login ou Senha vazio");
        }

    }

    public void errorMessageExceptionAmigavel(String erro) {
        errorLabel.setText(erro);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //CadastroDAO.setConnection(connection);

    }

}
