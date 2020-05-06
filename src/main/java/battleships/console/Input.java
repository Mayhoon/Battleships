package battleships.console;

import battleships.enums.Networking;
import battleships.server.Starter;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    private Starter starter;

    public void askForServer() throws IOException {
        System.out.println("Do you want to host or join?");
        System.out.println("host / join");
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.next();

        switch (inp) {
            case "host":
                starter = new Starter(Networking.HOST);
                break;
            case "join":
                starter = new Starter(Networking.CLIENT);
                break;
            default:
                System.out.println("Invalid input.");
                System.exit(1);
        }
    }
}
