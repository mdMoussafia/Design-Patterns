package net.BD;

import adapter.HdmiVgaAdapter;
import adapter.HdmiVgaAdapterH;
import computer.*;


public class Main {
    public static void main(String[] args) {
        CentralUnit centralUnit = new CentralUnit();
        centralUnit.setVga(new Monitor());
        centralUnit.print("Hello World");
        centralUnit.setVga(new Projector());
        centralUnit.print("Hello World");
        HdmiVgaAdapter hdmiVgaAdapter = new HdmiVgaAdapter();
        hdmiVgaAdapter.setHdmi(new TV());
        centralUnit.setVga(hdmiVgaAdapter);
        centralUnit.print("Hello World");
        centralUnit.setVga(new SuperVP());
        centralUnit.print("Hello World");
        hdmiVgaAdapter.setHdmi(new SuperVP());
        centralUnit.setVga(hdmiVgaAdapter);
        centralUnit.print("Hello World");

        HdmiVgaAdapterH hdmiVgaAdapterH = new HdmiVgaAdapterH();
        centralUnit.setVga(hdmiVgaAdapterH);
        centralUnit.print("Test");

    }
}