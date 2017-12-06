
package infra.DataBase;

import business.model.Usuario;

 
public interface Database {
    
   public boolean inserir(Usuario user);
    public boolean update(Usuario user);
    public boolean remover(Usuario user);
    public Usuario buscar(Usuario user,String data);
    
    public boolean updateCC(Usuario user);
    public boolean updateCP(Usuario user);
    
}
