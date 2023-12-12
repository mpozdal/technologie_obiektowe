package FileSystem;

import java.util.*;

public class Directory implements Component{
    private String name;
    private List<Component> components;
    private Directory parent;
    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setParent(Directory dir) {
        this.parent = dir;
    }
    @Override
    public Directory getParent() {
        return parent;
    }
    public void viewComponents() {
        for(Component elem: components) {
            System.out.print(elem.getName() + " ");
        }
        System.out.println();
    }

}
