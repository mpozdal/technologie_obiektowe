package Commands;

import FileSystem.Directory;

public class CommandMKDIR implements ICommand {

    private CommandReceiver receiver;
    private Directory source;
    private String name;

    public CommandMKDIR(Directory source, String name) {
        this.receiver = new CommandReceiver();
        this.source = source;
        this.name = name;
    }
    @Override
    public void execute() {
        this.receiver.mkdir(source, name);
    }
}
