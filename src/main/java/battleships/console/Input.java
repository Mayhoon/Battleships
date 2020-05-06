package battleships.console;

import battleships.server.KryoClient;
import battleships.server.KryoServer;
import battleships.ships.Battleship;
import battleships.ships.Field;
import battleships.ships.Ship;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

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
        ArrayList list = new ArrayList<Ship>();

        try {
            list.add(new Battleship(getPosition(), isHorizontal()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Boolean isHorizontal() {
        System.out.println("Direction of the ship:");
        System.out.println("horizontal (h) / vertical (v)");

        Boolean horizontal = false;
        String input = scanner.next();

        if (input.equals("h")) {
            horizontal = true;
        } else if (input.equals("v")) {
            horizontal = false;
        }
        return horizontal;
    }

    private Field getPosition() {
        System.out.println("X position of the ship:");
        int x = scanner.nextInt();
        System.out.println("Y position of the ship:");
        int y = scanner.nextInt();

        return new Field(x, y);
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
