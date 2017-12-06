/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.Conta;
import business.model.ContaCorrente;
import business.model.ContaPoupanca;
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
import infra.ValidaEntradadeDados;
import infra.errorMessageException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aliso
 */
public class IndexController implements Initializable {

    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField SenhaPasswordField;
    @FXML
    private TextField NomeTextField;
    @FXML
    private TextField SaldoTextField;

    @FXML
    private Label errorLabel;
    @FXML
    private Label ccLabel;
    @FXML
    private Label cpLabel;

    @FXML
    private AnchorPane AnchorPane;

    private ValidaEntradadeDados validaEntradadeDados;

    //Atributos para manipulação de Banco de Dados SQL
    /*
    private final DatabaseSQL database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final CadastroDAO CadastroDAO = new CadastroDAO();
    
    
    
     */
    @FXML
    private void handleButtonUpdate(ActionEvent event) throws errorMessageException {

        Usuario user;
        user = new Usuario(0, NomeTextField.getText(), LoginTextField.getText(), SenhaPasswordField.getText(), " ", 0, 0);

        if (DocumentController.CadastroDAO.update(user)) {
            errorMessageExceptionAmigavel("Conta Atualizada com Sucesso");
        }

    }

    @FXML
    private void handleButtonExcluir(ActionEvent event) throws errorMessageException {
        Usuario user;
        user = new Usuario(0, "", LoginTextField.getText(), "", " ", 0, 0);

        if (DocumentController.CadastroDAO.remover(user)) {
            errorMessageExceptionAmigavel("Conta Atualizada com Sucesso");
        }
    }

    public void upData(Usuario user) {
        if (user.getNome() != null) {
            NomeTextField.setText(user.getNome());
        }
        LoginTextField.setText(user.getLogin());
        SenhaPasswordField.setText(user.getSenha());

    }

    public void errorMessageExceptionAmigavel(String erro) {
        errorLabel.setText(erro);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //CadastroDAO.setConnection(connection);
        upData(LoginController.user);
        
    }

}
