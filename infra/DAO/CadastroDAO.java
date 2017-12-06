/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import infra.DataBase.Database;
import business.model.Usuario;

/**
 *
 * @author aliso
 */
public class CadastroDAO implements Database {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean inserir(Usuario user) {

        String sql = "INSERT INTO usuarios values (default,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getData());
            stmt.setString(5, "" + user.getSaldoCC());
            stmt.setString(6, "" + user.getSaldoCP());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Usuario user) {

        String sql = "UPDATE usuarios SET nome=?, login=?, senha=?, dataNasc=?, saldoCC=?, saldoCP=?  WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getData());
            stmt.setString(5, "" + user.getSaldoCC());
            stmt.setString(6, "" + user.getSaldoCP());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    @Override
    public boolean updateCC(Usuario user) {

        String sql = "UPDATE usuarios SET saldoCC=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "" + user.getSaldoCC());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    @Override
    public boolean updateCP(Usuario user) {

        String sql = "UPDATE usuarios SET saldoCP=?  WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "" + user.getSaldoCP());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean remover(Usuario user) {

        String sql = "DELETE FROM usuarios WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Usuario> listar(int op) {
        switch (op) {
            case 0:
                String sql = "SELECT * FROM usuarios";
                List<Usuario> retorno = new ArrayList<>();
                try {
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet resultado = stmt.executeQuery();
                    while (resultado.next()) {
                        Usuario user = new Usuario(Integer.parseInt(resultado.getString("id")),
                                resultado.getString("nome"),
                                resultado.getString("login"),
                                resultado.getString("senha"),
                                resultado.getString("dataNasc"),
                                Double.parseDouble(resultado.getString("saldoCC")),
                                Double.parseDouble(resultado.getString("saldoCP")));

                        retorno.add(user);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return retorno;
            case 1:

            default:
        }
        return null;
    }

    @Override
    public Usuario buscar(Usuario user, String data) {

        String sql = "SELECT * FROM usuarios WHERE id=?";
        Usuario retorno = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()&&data.equalsIgnoreCase("2017")) {
                retorno = new Usuario(Integer.parseInt(resultado.getString("id")),
                        resultado.getString("nome"),
                        resultado.getString("login"),
                        resultado.getString("senha"),
                        resultado.getString("dataNasc"),
                        Double.parseDouble(resultado.getString("saldoCC")),
                        Double.parseDouble(resultado.getString("saldoCP")));
                //retorno = user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }

}
