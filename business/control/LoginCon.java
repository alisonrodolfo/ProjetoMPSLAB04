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
public interface LoginCon {
    
    public boolean usuarioExiste(Usuario user);
   
    public boolean login(Usuario user);
    
}
