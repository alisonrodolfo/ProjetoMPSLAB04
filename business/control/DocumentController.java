/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;


import infra.DAO.CadastroFILEDAO;
import java.io.IOException;
import java.net.URL;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;


import javafx.scene.layout.AnchorPane;

/**
 *
 * @author aliso
 */
public class DocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    
    private boolean logado = false;

    public final static CadastroFILEDAO CadastroDAO = new CadastroFILEDAO();
    


    @FXML
    private MenuItem editarSaldo;

    @FXML
    public void handleMenuItemCadastro() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLCadastro.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemLogin() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemTodos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLGeral.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemSaldo() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLIndexFunc.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml"));
            anchorPane.getChildren().setAll(a);
            editarSaldo.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(DocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 

   
}
