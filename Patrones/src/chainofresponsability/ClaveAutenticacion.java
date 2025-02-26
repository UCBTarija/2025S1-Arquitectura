package chainofresponsability;

public class ClaveAutenticacion extends Autenticacion{
    
    private String usuario;
    private String clave;

    public ClaveAutenticacion(String usuario, String clave, Autenticacion siguiente){
        this.siguiente = siguiente;
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public void execute() {
        System.out.println("Validando clave:" + this.usuario + "/" + this.clave);

        this.siguiente();
    }
    
}
