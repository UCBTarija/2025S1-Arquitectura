package chainofresponsability;

public abstract class Autenticacion {

    protected Autenticacion siguiente = null;

    public abstract void execute();

    public void siguiente() {
        if (siguiente != null) {
            siguiente.execute();
        }
    }
}
