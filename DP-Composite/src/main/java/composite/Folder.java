package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Folder extends Component{
    private List<Component> components = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void print() {
        String tab = tab();
        System.out.println(tab + "Folder:" + name);
        for (Component component : components) {
            component.print();
        }
    }
    public Component addComponent(Component component) {
        component.level = this.level + 1;
        this.components.add(component);
        return component;
    }
    public List<Component> getComponents() {
        return components;
    }
    public Component getComponent(String name) {
        Optional<Component> first = components.stream().filter(component -> component.name == name).findFirst();
        return first.orElse(null);
    }

}
