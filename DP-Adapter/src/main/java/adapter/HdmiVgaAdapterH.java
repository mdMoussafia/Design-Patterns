package adapter;

import computer.Hdmi;
import computer.TV;
import computer.Vga;


public class HdmiVgaAdapterH extends TV implements Vga {
    @Override
    public void print(String message) {
        System.out.println("*********Adapter********");
        super.view(message.getBytes());
    }
}
