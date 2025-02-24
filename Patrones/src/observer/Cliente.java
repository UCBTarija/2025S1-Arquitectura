package observer;

public class Cliente implements Observer {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        Cliente client = new Cliente();
        subject.attachObserver(client);

        subject.setState(100);
    }

    @Override
    public void updateObserver() {
        System.out.println("Client  notificado");
    }


}
