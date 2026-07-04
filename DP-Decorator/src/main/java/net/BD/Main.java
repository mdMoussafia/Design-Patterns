package net.BD;

import Decorators.Caramel;
import Decorators.Chocolate;
import Decorators.Hazelnut;
import composants.Boisson;
import composants.Espresso;
import composants.Sumatra;


public class Main {
    public static void main(String[] args) {
        Boisson boisson;
        boisson = new Sumatra();
        System.out.println(boisson.getDescription());
        System.out.println(boisson.price());
        boisson = new Espresso();
        System.out.println(boisson.getDescription());
        System.out.println(boisson.price());
        boisson = new Chocolate(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.price());
        boisson = new Caramel(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.price());
        boisson = new Chocolate(new Hazelnut(new Chocolate(new Caramel(new Espresso()))));
        System.out.println(boisson.getDescription());
        System.out.println(boisson.price());
    }
}