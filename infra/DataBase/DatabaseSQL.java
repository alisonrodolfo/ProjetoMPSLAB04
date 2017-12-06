/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.DataBase;

import java.sql.Connection;

/**
 *
 * @author aliso
 */
public interface DatabaseSQL {
    
      
    public Connection conectar();
    public void desconectar(Connection conn);
    
}
