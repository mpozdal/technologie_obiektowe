package Commands;

import FileSystem.Component;
import FileSystem.Directory;
import FileSystem.File;

public class CommandReceiver {
    public void move(String source, String destination) {
        System.out.println("Moving component from " + source + " to " + destination);
    }
    public void copy(String source, String destination) {
        System.out.println("Copying component from " + source + " to " + destination);
    }
    public void ls(Directory currentDirectory) {
        currentDirectory.viewComponents();
    }
    public void mkdir(Directory dir, String name) {
        Directory newDir = new Directory(name);
        dir.addComponent(newDir);
    }
    public void touch(Directory dir, String name) {
        File newFile = new File(name);
        dir.addComponent(newFile);
    }
}
