import Commands.CommandParser;
import FileSystem.Component;
import FileSystem.Directory;
import FileSystem.Drive;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Drive drive = new Drive();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            Directory directory = drive.getDirectory();
            System.out.print(drive.getCurrentPath() +  " % ");
            String command = scanner.nextLine();
            CommandParser parser = new CommandParser(command, directory);

            if(command.equals("exit")) {
                System.out.println("EXIT");
                break;
            }
        }
    scanner.close();
    }
}