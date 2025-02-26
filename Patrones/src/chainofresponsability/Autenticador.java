package chainofresponsability;

public class Autenticador {

    public void autenticar() {
        Autenticacion cadena = new EmailAutenticacion("alguient@xxx",
                new ClaveAutenticacion("usuarioX", "claveY",
                        new Auditar(null)));

        cadena.execute();
    }
}
