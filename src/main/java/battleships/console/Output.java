package battleships.console;

import battleships.ships.Battleship;

import java.util.ArrayList;

public class Output {
    private int Battlefield_width;
    private int Battlefield_height;
    private ArrayList ships;

    public Output(ArrayList<Battleship> ships) {
        this.ships = ships;
        Battlefield_height = 10;
        Battlefield_width = 10;
    }

    public void update() {
        System.out.println("-----------------Battleships-----------------");
        System.out.println(Color.GREEN + "    A   B   C   D   E   F   G   H   I   J" + Color.RESET);

        for (int y = 0; y < Battlefield_height; y++) {
            System.out.print(Color.CYAN + y + "  " + Color.RESET);
            for (int x = 0; x < Battlefield_width; x++) {

//                for (int i = 0; i < ships.size(); i++) {
//                    System.out.print("["+ ships.get(i). +" ] ");
//                }
                System.out.print("[ ] ");
            }
            System.out.println("");
        }
    }
}
