package computer;


public class SuperVP implements Vga,Hdmi{
    @Override
    public void view(byte[] data) {
        String s = new String(data);
        System.out.println("Super VP HDMI");
        System.out.println(s);
    }

    @Override
    public void print(String message) {
        System.out.println("SuperVP VGA");
        System.out.println(message);
    }
}
