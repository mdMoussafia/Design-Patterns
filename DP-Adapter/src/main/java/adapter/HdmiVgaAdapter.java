package adapter;

import computer.Hdmi;
import computer.Vga;


public class HdmiVgaAdapter implements Vga {
    private Hdmi hdmi;
    @Override
    public void print(String message) {
        System.out.println("*********Adapter********");
        hdmi.view(message.getBytes());
    }
    public void setHdmi(Hdmi hdmi) {
        this.hdmi = hdmi;
    }
}
