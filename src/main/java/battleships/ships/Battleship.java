package battleships.ships;

import java.util.Collections;
import java.util.List;

public class Battleship extends Ship {
    // Constructor
    public Battleship(List<Field> coordinates, boolean horizontal) {
        length = 5;
        width = 1;
        isHorizontal = horizontal;
        occupiedCoordinates = coordinates;
        hitCoordinates = Collections.emptyList();
    }
}
