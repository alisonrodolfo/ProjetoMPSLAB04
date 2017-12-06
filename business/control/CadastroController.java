/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import static business.control.LoginController.user;
import business.model.ContaCorrente;
import business.model.ContaPoupanca;
import java.net.URL;


import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import business.model.Usuario;
import infra.ValidaEntradadeDados;
import infra.errorMessageException;

/**
 *
 * @author aliso
 */
public class CadastroController implements Initializable {

    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField SenhaPasswordField;

    @FXML
    private Label errorLabel;
    
    private ValidaEntradadeDados validaEntradadeDados;
    


    @FXML
    private void handleButtonCadastro(ActionEvent event) throws errorMessageException {

        validaEntradadeDados = new ValidaEntradadeDados(LoginTextField.getText(),SenhaPasswordField.getText());
        AdapterLogin api = new AdapterLogin();
        
        if (validaEntradadeDados.isValid()) {
         
            Usuario user = new Usuario(0,null,LoginTextField.getText(),SenhaPasswordField.getText(),"",0,0);
            if (!api.usuarioExiste(user)) {
                DocumentController.CadastroDAO.inserir(user);
                errorMessageExceptionAmigavel("Conta Cadastrada com Sucesso");
                LoginTextField.setText("");
                SenhaPasswordField.setText("");
            } else {
                errorMessageExceptionAmigavel("Já existe um usuario com esse login");
            }

        } else {
            errorMessageExceptionAmigavel(validaEntradadeDados.getErrorMessageExceptionAmigavel());
        }

    }

    
    public void errorMessageExceptionAmigavel(String erro) {
        errorLabel.setText(erro);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
