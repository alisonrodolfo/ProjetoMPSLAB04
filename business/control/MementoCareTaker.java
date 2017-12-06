/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import java.util.ArrayList;

/**
 *
 * @author aliso
 */
public class MementoCareTaker {

    protected ArrayList<Memento> estados;

    public MementoCareTaker() {
        estados = new ArrayList<>();
    }

    public void adicionarMemento(Memento memento) {
        estados.add(memento);
    }

    public Memento getUltimoEstadoSalvo() {
        if (estados.size() <= 0) {
            return new Memento();
        }
        Memento estadoSalvo = estados.get(estados.size() - 1);
        estados.remove(estados.size() - 1);
        return estadoSalvo;
    }

}
