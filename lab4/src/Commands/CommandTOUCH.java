package Commands;

import FileSystem.Directory;

public class CommandTOUCH implements ICommand {

    private CommandReceiver receiver;
    private Directory source;
    private String name;

    public CommandTOUCH(Directory source, String name) {
        this.receiver = new CommandReceiver();
        this.source = source;
        this.name = name;
    }
    @Override
    public void execute() {
        this.receiver.touch(source, name);
    }
}
