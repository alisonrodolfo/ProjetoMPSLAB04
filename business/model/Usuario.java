/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import java.io.Serializable;


/**
 *
 * @author aliso
 */
public class Usuario implements Serializable {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String data;
    private double saldoCC;
    private double saldoCP;

    public Usuario(int id, String nome, String login, String senha, String data, double saldoCC, double saldoCP) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.data = data;
        this.saldoCC = saldoCC;
        this.saldoCP = saldoCP;
    }
    
    public Usuario(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getSaldoCC() {
        return saldoCC;
    }

    public void setSaldoCC(double saldoCC) {
        this.saldoCC = saldoCC;
    }

    public double getSaldoCP() {
        return saldoCP;
    }

    public void setSaldoCP(double saldoCP) {
        this.saldoCP = saldoCP;
    }

    



    
    
    
    
    
}
