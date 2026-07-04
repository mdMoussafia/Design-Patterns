package composite;


public abstract class Component {
    protected String name;
    protected int level=0;
    public abstract void print();
    public String tab(){
        String tabs="";
        for(int i=0;i<level;i++){
            tabs+="\t";
        }
        return tabs;
    }

    public Component(String name) {
        this.name = name;
    }
}
