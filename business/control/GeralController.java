/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.Usuario;
import java.net.URL;
import java.util.List;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



/**
 *
 * @author aliso
 */
public class GeralController implements Initializable {

    @FXML
    private TableView<Usuario> tableViewusUsuario;
    
  
    @FXML
    private TableColumn<Usuario, String> tableColumnLogin;
    @FXML
    private TableColumn<Usuario, String> tableColumnNome;
    @FXML
    private TableColumn<Usuario, String> tableColumnSenha;
    
    private List<Usuario> listUsuarios;
    private ObservableList<Usuario> observableListUsuarios;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleMenuItemcarregarTableViewUsuario();

    }

    public void handleMenuItemcarregarTableViewUsuario() {
        tableColumnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        
        listUsuarios = DocumentController.CadastroDAO.listar();
        observableListUsuarios = FXCollections.observableArrayList(listUsuarios);
        tableViewusUsuario.setItems(observableListUsuarios);
    }

   
}
