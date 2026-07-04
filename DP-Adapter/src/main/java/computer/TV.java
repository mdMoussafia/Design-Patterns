package computer;


public class TV implements Hdmi{
    @Override
    public void view(byte[] data) {
        System.out.println("***********TV*********");
        String str = new String(data);
        System.out.println(str);
    }
}
