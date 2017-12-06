
package business.control;


import infra.DAO.UsuariosDAOO;




public interface Command {
    public abstract Object execute(UsuariosDAOO usuarios) throws Exception;
    public abstract String getNome();
}
