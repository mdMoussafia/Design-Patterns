package Decorators;

import composants.Boisson;


public class Caramel extends Decorator {
    public Caramel(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription()+" + Caramel";
    }

    @Override
    public double price() {
        return 1.8+boisson.price();
    }

}
