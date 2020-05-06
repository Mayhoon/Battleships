package battleships.ships;

import java.util.Collections;
import java.util.List;

public class Carrier extends Ship {
    // Constructor
    public Carrier(List<Field> coordinates, boolean horizontal) {
        length = 6;
        width = 1;
        isHorizontal = horizontal;
        occupiedCoordinates = coordinates;
        hitCoordinates = Collections.emptyList();
    }
}
