package chainofresponsability;

public class EmailAutenticacion extends Autenticacion {

    private String email;

    public EmailAutenticacion(String email, Autenticacion siguiente){
        this.siguiente = siguiente;
        this.email = email;
    }

    @Override
    public void execute() {
        System.out.println("Validando por correo: " + this.email);

        this.siguiente();
    }
    
}
