package battleships.console;

import battleships.server.KryoClient;
import battleships.server.KryoServer;

import java.io.IOException;
import java.util.Scanner;

public class Input {

    private KryoClient kryoClient;
    private KryoServer kryoServer;
    private Scanner scanner;

    public void serverOrHost() throws IOException {
        System.out.println("Do you want to host or join the game?");
        System.out.println("host / join");

        scanner = new Scanner(System.in);
        String input = scanner.next();

        switch (input) {
            case "host":
                startServer();
                break;
            case "join":
                startClient();
                break;
            default:
                System.out.println(Color.RED + "Invalid input." + Color.RESET);
                serverOrHost();
        }
    }

    private void startClient() throws IOException {
        kryoClient = new KryoClient();
        kryoClient.start("localhost");
    }

    private void startServer() throws IOException {
        kryoServer = new KryoServer();
        kryoServer.start();
    }

}
