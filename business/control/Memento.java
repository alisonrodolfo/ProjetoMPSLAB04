
package business.control;


public class Memento {
    private Command mem = null;
    
    public void setEstado(Command est){
        mem = est;
    }
    public Command getEstado(){
        return mem;
    }
    
}
