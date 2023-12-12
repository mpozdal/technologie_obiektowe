package Commands;

import FileSystem.Component;
import FileSystem.Directory;

public class CommandLS implements ICommand{

    private CommandReceiver receiver;
    private Directory source;

    public CommandLS(Directory source) {
        this.receiver = new CommandReceiver();
        this.source = source;
    }
    @Override
    public void execute() {
        this.receiver.ls(this.source);
    }
}
