package Decorators;

import composants.Boisson;


public class Chocolate extends Decorator {
    public Chocolate(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription()+" + Chocolate";
    }

    @Override
    public double price() {
        return 1.2+boisson.price();
    }

}
