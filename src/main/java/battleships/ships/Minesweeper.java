package battleships.ships;

import java.util.Collections;
import java.util.List;

public class Minesweeper extends Ship {
    // Constructor
    public Minesweeper(Field field, boolean horizontal) throws Exception {
        length = 3;
        width = 1;
        isHorizontal = horizontal;
        setCoordinates(horizontal, field);
    }
}
