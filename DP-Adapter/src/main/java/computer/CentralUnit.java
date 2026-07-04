package computer;


public class CentralUnit {
    private Vga vga;
    public void print(String msg) {
        vga.print(msg);
    }

    public void setVga(Vga vga) {
        this.vga = vga;
    }
}
