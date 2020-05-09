package battleships.main;

import battleships.console.Input;
import battleships.network.Data;
import battleships.network.Network;

public class GameStateManager {
    private Input input;
    private Data data;
    private Network network;

    public GameStateManager() {
        input = new Input();
        data = new Data();
        network = new Network();
    }

    public void placeShips() {
        network.connect(input.serverOrHost());
    }

    public void hostOrJoin() {

    }
}
