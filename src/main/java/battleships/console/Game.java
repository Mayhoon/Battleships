package battleships.console;

import battleships.ships.Ship;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        new Game();
    }

    private Input input;
    private Output output;
    private ArrayList<Ship> ships;

    public Game() {
        input = new Input();
        ships = input.placeShips();

        output = new Output(ships);
        output.update();
    }
}