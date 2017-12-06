/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

/**
 *
 * @author aliso
 */
public abstract class Conta {
    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
     synchronized public void credita(double valor){
         this.saldo += saldo;
         this.saldo -= this.calculaTaxa();
         
     }
     synchronized public void debita(double valor){
         this.saldo -= saldo;
         this.saldo -= this.calculaTaxa();
     }
     
     public abstract double calculaTaxa();
    
    
}
