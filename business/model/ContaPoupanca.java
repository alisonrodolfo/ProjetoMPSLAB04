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
public class ContaPoupanca extends Conta{

    public ContaPoupanca(double saldo) {
        super(saldo);
    }


    @Override
    public double calculaTaxa() {
        return 0.0;
    }

    
}
