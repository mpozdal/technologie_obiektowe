package FileSystem;

public class File implements Component{

    private String name;
    private Directory parent;
    public File(String name) {
        this.name = name;
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


}
