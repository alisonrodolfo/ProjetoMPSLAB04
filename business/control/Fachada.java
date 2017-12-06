package business.control;

import business.model.ContaPoupanca;
import business.model.ContaCorrente;
import business.model.Usuario;
import infra.DAO.UsuariosDAOO;
import infra.errorMessageException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aliso
 */
public class Fachada {

    private final UsuariosDAOO usuarios;
    private final MementoCareTaker mementoCareTaker;
    private Memento men;

    //
    public Fachada(UsuariosDAOO usuarios) throws errorMessageException {
        this.usuarios = usuarios;
        mementoCareTaker = new MementoCareTaker();
    }

    public Object service(Command c) throws Exception {
        Object o = c.execute(usuarios);
        men.setEstado(c);
        mementoCareTaker.adicionarMemento(men);
        return o;
    }

    public void undo(Memento mem) throws Exception {
        Command c = mementoCareTaker.getUltimoEstadoSalvo().getEstado();
        if (!(c == null)) {
            c.execute(usuarios);
            mem.setEstado(null);  
        }else{
            throw new errorMessageException("Nenhuma operação para desfazer!");
        }

    }

}
