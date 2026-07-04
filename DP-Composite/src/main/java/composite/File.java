package composite;


public class File extends Component{
    public File(String name) {
        super(name);
    }

    @Override
    public void print() {
        String tab = tab();
        System.out.println(tab+"File: "+name);
    }
}
