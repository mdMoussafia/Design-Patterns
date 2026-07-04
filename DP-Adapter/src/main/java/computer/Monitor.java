package computer;


public class Monitor implements Vga{

    @Override
    public void print(String message) {
        System.out.println("**************Monitor**************");
        System.out.println(message);
    }
}
