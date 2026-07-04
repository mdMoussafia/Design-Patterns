package net.BD;

import composite.File;
import composite.Folder;


public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.addComponent(new File("pom.xml"));
        Folder src = (Folder) root.addComponent(new Folder("src"));
        Folder main = (Folder) src.addComponent(new Folder("main"));
        main.addComponent(new File("Test.java"));
        main.addComponent(new File("Person.java"));
        root.print();
    }
}