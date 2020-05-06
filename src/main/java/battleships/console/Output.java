package battleships.console;

import battleships.ships.Ship;

import java.util.ArrayList;

public class Output {
    private int Battlefield_width;
    private int Battlefield_height;
    private ArrayList<Ship> ships;

    public Output(ArrayList<Ship> ships) {
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

                boolean occupied = false;

                for (int i = 0; i < ships.size(); i++) {
                    for (int c = 0; c < ships.get(i).getOccupiedCoordinates().size(); c++) {
//                        System.out.println("X " + ships.get(i).getOccupiedCoordinates().get(c).getX());
//                        System.out.println("Y " + ships.get(i).getOccupiedCoordinates().get(c).getY());

                        int posY = ships.get(i).getOccupiedCoordinates().get(c).getY();
                        int posX = ships.get(i).getOccupiedCoordinates().get(c).getX();

                        if (posX == x && posY == y) {
                            occupied = true;
                        }
                    }
//                    System.out.println("-----------------------------");
                }

                if (occupied == true) {
                    System.out.print("[X] ");
                } else if (occupied == false) {
                    System.out.print("[ ] ");
                }
            }
            System.out.println("");
        }
    }
}
