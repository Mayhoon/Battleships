package battleships.main;

import battleships.console.Input;
import battleships.console.Output;
import battleships.server.Network;
import battleships.ships.*;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) throws Exception {
        new Game();
    }

    final String SHIP_TO_BE_PLACED = "Place your: ";
    final String CARRIER_DESCRIPTION = "Carrier";
    final String BATTLESHIP_DESCRIPTION = "Battleship";
    final String CRUISER_DESCRIPTION = "Cruiser";
    final String MINESWEEPER_DESCRIPTION = "Minesweeper";
    final String OIL_PLATFORM_DESCRIPTION = "Oil Platform";

    private Input input;
    private Output output;
    private ArrayList<Ship> ships;
    private Network network;

    public Game() throws Exception {
        input = new Input();

        network = new Network();
        network.connect(input.serverOrHost());
        // network.sendData(new Data());

//        addShips();
//        output = new Output(ships);
//        output.update();
    }

    private void addShips() throws Exception {
        ships = new ArrayList<>();
        System.out.println(SHIP_TO_BE_PLACED + CARRIER_DESCRIPTION);
        ships.add(new Carrier(input.getPosition(), input.getDirection()).validatePlacementLocation(ships));
        System.out.println(SHIP_TO_BE_PLACED + BATTLESHIP_DESCRIPTION);
        ships.add(new Battleship(input.getPosition(), input.getDirection()).validatePlacementLocation(ships));
        System.out.println(SHIP_TO_BE_PLACED + CRUISER_DESCRIPTION);
        ships.add(new Cruiser(input.getPosition(), input.getDirection()).validatePlacementLocation(ships));
        System.out.println(SHIP_TO_BE_PLACED + MINESWEEPER_DESCRIPTION);
        ships.add(new Minesweeper(input.getPosition(), input.getDirection()).validatePlacementLocation(ships));
        System.out.println(SHIP_TO_BE_PLACED + OIL_PLATFORM_DESCRIPTION);
        ships.add(new OilPlatform(input.getPosition(), input.getDirection()).validatePlacementLocation(ships));
    }

}