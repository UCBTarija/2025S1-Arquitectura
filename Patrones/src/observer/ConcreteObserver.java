package observer;

public class ConcreteObserver implements Observer {
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject){
        this.subject = subject;
        this.subject.attachObserver(this);
    }

    @Override
    public void updateObserver() {
        System.out.println("ConcreteObserver notificado");
        int estado = this.subject.getState();
        System.out.println("Estado ConcreteObserver: " + estado);
    }

}
