package net.BD;

import obs.*;


public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);
        observable.subscribe(o2);
        observable.subscribe(o -> {
            if(o instanceof ObservableImpl obs) {
                System.out.println("********Observable Impl 3********");
                System.out.println("Res=" + obs.getState() * Math.cos(obs.getState()));
            }
        });
        observable.setState(120);
        observable.setState(60);
        observable.unsubscribe(o2);
        observable.setState(80);
    }
}
