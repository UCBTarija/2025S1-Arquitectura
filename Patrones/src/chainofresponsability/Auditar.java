package chainofresponsability;

public class Auditar extends Autenticacion{

    public Auditar(Autenticacion siguiente){
        this.siguiente = siguiente;
    }

    @Override
    public void execute() {
        System.out.println("Registrando en log");

        this.siguiente();
    }
    
}
