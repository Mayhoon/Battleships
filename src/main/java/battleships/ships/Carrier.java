package battleships.ships;

import java.util.Collections;
import java.util.List;

public class Carrier extends Ship {
    // Constructor
    public Carrier(Field field, boolean horizontal) throws Exception {
        description = "Carrier";
        length = 6;
        width = 1;
        isHorizontal = horizontal;
        setCoordinates(horizontal, field);
    }
}
