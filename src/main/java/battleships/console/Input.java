package battleships.console;

import battleships.server.KryoClient;
import battleships.server.KryoServer;
import battleships.ships.Field;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    final String INVALID_PLACEMENT_RANGE_EXCEPTION_CAUSE = "Your Ship must be placed within the Battlefield!";

    private KryoClient kryoClient;
    private KryoServer kryoServer;
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public boolean getDirection() {
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

    public Field getPosition() {
        System.out.println("X position of the ship:");
        int x = scanner.nextInt();
        System.out.println("Y position of the ship:");
        int y = scanner.nextInt();

        try {
            return validateInput(new Field(x, y));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    private Field validateInput(Field field) throws Exception {
        if (field.getX() > 9 || field.getX() < 0 || field.getY() > 9 || field.getY() < 0) {
            throw new Exception(INVALID_PLACEMENT_RANGE_EXCEPTION_CAUSE);
        } else {
            return field;
        }
    }

}
