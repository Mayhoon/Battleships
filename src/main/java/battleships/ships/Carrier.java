<<<<<<< Updated upstream
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
=======
//package battleships.ships;
//
//public class Carrier implements Ship {
//
//    public Ship
//
//    //@Override
//    public int getLength() {
//        return length;
//    }
//
//    @Override
//    public void setLength(int l) {
//
//    }
//
//    @Override
//    public int getWidth() {
//        return width;
//    }
//
//    @Override
//    public void setWidth(int w) {
//        width = w;
//    }
//}
>>>>>>> Stashed changes
