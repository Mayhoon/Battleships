package battleships.main;

import battleships.console.Input;
import battleships.console.Output;
import battleships.ships.Carrier;
import battleships.ships.Ship;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) throws Exception {
        new Game();
    }

    private Input input;
    private Output output;
    private ArrayList<Ship> ships;

    public Game() throws Exception {
        input = new Input();

        ships = new ArrayList<Ship>();
        ships.add(new Carrier(input.getPosition(), input.getDirection()));

        output = new Output(ships);
        output.update();
    }
}