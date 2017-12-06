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
public class SaldoController implements Initializable {


    private String LoginTextField;

    private String SenhaPasswordField;

    private String NomeTextField;
    
    @FXML
    private TextField SaldoTextField;

    private Conta cc;
    private Conta cp;

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
    private void handleButtonDepositoCC(ActionEvent event) throws errorMessageException {

        Usuario user;

        cc.calculaTaxa();
        cc.credita(Double.parseDouble(SaldoTextField.getText()));
        user = new Usuario(0, "", LoginTextField, "", " ", cc.getSaldo(), 0);

        if (DocumentController.CadastroDAO.updateCC(user)) {
            errorMessageExceptionAmigavel("Conta Atualizada com Sucesso");
        }

    }

    @FXML
    private void handleButtonDepositoCP(ActionEvent event) throws errorMessageException {

    }

    @FXML
    private void handleButtonSaqueCC(ActionEvent event) throws errorMessageException {

    }

    @FXML
    private void handleButtonSaqueCP(ActionEvent event) throws errorMessageException {

    }

    public void upData(Usuario user) {
        if (user.getNome() != null) {

            NomeTextField = user.getNome();
        }
        LoginTextField = user.getLogin();
        SenhaPasswordField = user.getSenha();
        ccLabel.setText("Saldo CC: " + user.getSaldoCC());
        cpLabel.setText("Saldo CP: " + user.getSaldoCP());

    }

    public void errorMessageExceptionAmigavel(String erro) {
        errorLabel.setText(erro);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //CadastroDAO.setConnection(connection);
        upData(LoginController.user);
        cc = new ContaCorrente(LoginController.user.getSaldoCC());
        cp = new ContaPoupanca(LoginController.user.getSaldoCP());
    }

}
