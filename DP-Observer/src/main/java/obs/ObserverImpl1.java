package obs;

public class ObserverImpl1 implements Observer {
    @Override
    public void update(Observable o) {
        if(o instanceof ObservableImpl obs){
            System.out.println("********Observable Impl 1********");
            System.out.println("New state: " + obs.getState());
        }
    }
}
