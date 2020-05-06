package battleships.console;

import battleships.server.KryoClient;
import battleships.server.KryoServer;
import battleships.ships.Battleship;
import battleships.ships.Field;
import battleships.ships.Ship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private KryoClient kryoClient;
    private KryoServer kryoServer;
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public ArrayList placeShips() {
        Boolean horizontal = false;
        ArrayList list = new ArrayList<Ship>();

        //Direction of the ship
        System.out.println("Direction of your Battleship:");
        System.out.println("horizontal (h) / diagonal (d)");
        String input = scanner.next();
        if (input.equals("h")) {
            horizontal = true;
        } else if (input.equals("d")) {
            horizontal = false;
        }

        //Position of the ship
        System.out.println("Battleship position x");
        int x = scanner.nextInt();
        System.out.println("Battleship position y at length ");
        int y = scanner.nextInt();

        try {
            list.add(new Battleship(new Field(x, y), horizontal));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void serverOrHost() throws IOException {
        System.out.println("Do you want to host or join the game?");
        System.out.println("host / join");
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
