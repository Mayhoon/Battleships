package battleships.ships;

import java.util.Collections;
import java.util.List;

public class Minesweeper extends Ship {
    // Constructor
    public Minesweeper(List<Field> coordinates, boolean horizontal) {
        length = 3;
        width = 1;
        isHorizontal = horizontal;
        occupiedCoordinates = coordinates;
        hitCoordinates = Collections.emptyList();
    }
}
