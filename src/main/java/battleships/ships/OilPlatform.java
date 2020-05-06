package battleships.ships;

import java.util.Collections;
import java.util.List;

public class OilPlatform extends Ship {
    // Constructor
    public OilPlatform(List<Field> coordinates, boolean horizontal) {
        length = 2;
        width = 2;
        isHorizontal = horizontal;
        occupiedCoordinates = coordinates;
        hitCoordinates = Collections.emptyList();
    }

    // Methods
    @Override
    public void setCoordinates(boolean isHorizontal, Field position) throws Exception {
        for (int l = 1; l < this.length; l++) {
            if ((position.getX() + length) > 10 || (position.getY() + length) > 10) {
                throw new Exception(OUT_OF_BOUND_EXCEPTION_CAUSE);
            } else {
                this.occupiedCoordinates.add(new Field(position.getX() + l, position.getY()));
                this.occupiedCoordinates.forEach(oc -> new Field(oc.getX() + 1, oc.getY() + 1));
            }
        }
    }
}
