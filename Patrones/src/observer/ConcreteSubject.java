package observer;

public class ConcreteSubject extends Subject{
    private int estado;

    public void setState(int valor){
        System.out.println("Estado alterado para: " + valor);
        this.estado = valor;        
        this.notifyObservers();
    }

    public int getState(){
        return this.estado;
    }

}
