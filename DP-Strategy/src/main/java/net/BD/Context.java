package net.BD;

public class Context {
    private IStrategy strategy = new StrategyImplDefault();
    public void effectuerOperation(){
        System.out.println("******************************");
        strategy.operation();
        System.out.println("==============================");
    }
    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
