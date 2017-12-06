/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.Usuario;

/**
 *
 * @author aliso
 */
public class AdapterLogin extends LoginConectServer implements LoginCon {

    private Usuario user;

    @Override
    public boolean usuarioExiste(Usuario user) {
        this.user = DocumentController.CadastroDAO.buscar(user, "2017");
        return this.user != null;
    }

    @Override
    public boolean login(Usuario user) {
        this.user = DocumentController.CadastroDAO.buscar(user, "2017");
        return this.user.getLogin().equalsIgnoreCase(user.getLogin()) && this.user.getLogin().equalsIgnoreCase(user.getLogin());
    }

}
