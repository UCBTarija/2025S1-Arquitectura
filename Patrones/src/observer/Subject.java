package observer;

import java.util.ArrayList;

public class Subject {

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void attachObserver(Observer observer){
        this.observers.add(observer);        
    }

    public void dettachObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : this.observers){
            observer.updateObserver();
        }
    }

}
