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
public class LoginConectServer {
    
    private Usuario user;
    
    public boolean usuarioExiste(Usuario user){
       
        return this.user!=null;
    }
   
    public boolean login(Usuario user){
      
        return this.user.getLogin().equalsIgnoreCase(user.getLogin())&&this.user.getLogin().equalsIgnoreCase(user.getLogin());
    }
}
