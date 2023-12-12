package Commands;

import FileSystem.Component;
import FileSystem.Directory;

public class CommandParser {
    String command;


    private boolean checkName(String name) {
        if (name.matches(".*[\\\\/:*?\"<>|].*") || name.startsWith("?")) {
            return false;
        }
        return true;
    }
    public CommandParser(String input, Directory current) {
        String[] tokens = input.split(" ");
        if(tokens.length > 0) {
            switch(tokens[0]){
                case "ls" -> {
                   if(tokens.length == 1) {
                       ICommand command = new CommandLS(current);
                       command.execute();
                   } else System.out.println("Invalid params");
                }
                case "mkdir" -> {
                    if(tokens.length == 2 && checkName(tokens[1])) {
                        ICommand command = new CommandMKDIR(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }
                case "touch" -> {
                    if(tokens.length == 2 && checkName(tokens[1])) {
                        ICommand command = new CommandTOUCH(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }
                //////
                case "cd" -> {
                    if(tokens.length == 2 ) {
                        ICommand command = new CommandTOUCH(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }
                case "more" -> {
                    if(tokens.length == 2) {
                        ICommand command = new CommandTOUCH(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }
                case "mv" -> {
                    if(tokens.length == 3) {
                        ICommand command = new CommandTOUCH(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }case "cp" -> {
                    if(tokens.length == 3) {
                        ICommand command = new CommandTOUCH(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }
                case "rm" -> {
                    if(tokens.length == 2 ) {
                        ICommand command = new CommandTOUCH(current, tokens[1]);
                        command.execute();
                    } else System.out.println("Invalid params");
                }

                ////////
                default -> System.out.println("Invalid command");

            }
        }
    }
}
