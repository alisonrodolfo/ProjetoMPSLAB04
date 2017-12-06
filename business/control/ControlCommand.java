/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.Usuario;
import infra.DAO.UsuariosDAOO;

/**
 *
 * @author aliso
 */
public class ControlCommand implements Command {
    private Usuario antigo, novo;
    private String tipo;

    public ControlCommand(Usuario antigo, Usuario novo, String tipo) {
        this.antigo = antigo;
        this.novo = novo;
        this.tipo = tipo;
    }
    @Override
    public Object execute(UsuariosDAOO usuarios) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
