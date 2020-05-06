package battleships.ships;

import java.util.Collections;
import java.util.List;

public class Cruiser extends Ship {
    // Constructor
    public Cruiser(List<Field> coordinates, boolean horizontal) {
        length = 4;
        width = 1;
        isHorizontal = horizontal;
        occupiedCoordinates = coordinates;
        hitCoordinates = Collections.emptyList();
    }
}
