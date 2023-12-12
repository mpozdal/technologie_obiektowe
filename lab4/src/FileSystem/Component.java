package FileSystem;

public interface Component {

    String getName();
    void setParent(Directory dir);
    Directory getParent();
}
