package Decorators;

import composants.Boisson;

public class Hazelnut extends Decorator {
    public Hazelnut(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription()+" + Hazelnut";
    }

    @Override
    public double price() {
        return 2.5+boisson.price();
    }

}
