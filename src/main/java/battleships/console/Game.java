package battleships.console;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        new Game();
    }

    private Input input;

    public Game() {
        try {
            input = new Input();
            input.serverOrHost();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
