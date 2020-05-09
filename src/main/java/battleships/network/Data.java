package battleships.network;

import battleships.ships.Ship;

import java.util.ArrayList;

public class Data {
    public int number;
    public ArrayList fleet;

    public Data() {
        fleet = new ArrayList<Ship>();
        number = 1;
    }
}
