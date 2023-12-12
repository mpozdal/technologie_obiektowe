package FileSystem;

public class Drive {
    private Directory FileSystem;
    private String CurrentPath;
    private Directory parent;
    public Drive() {
        this.FileSystem = new Directory("root");
        this.CurrentPath = "/";

        Directory etc = new Directory("etc");
        Directory bin = new Directory("bin");
        Directory lib = new Directory("lib");
        Directory tmp = new Directory("tmp");
        Directory sys = new Directory("sys");
        Directory var = new Directory("usr");

        this.FileSystem.addComponent(etc);
        this.FileSystem.addComponent(bin);
        this.FileSystem.addComponent(lib);
        this.FileSystem.addComponent(tmp);
        this.FileSystem.addComponent(sys);
        this.FileSystem.addComponent(var);
    }

    public String getCurrentPath() {
        return CurrentPath;
    }
    public Directory getDirectory() {
        return FileSystem;
    }
}
