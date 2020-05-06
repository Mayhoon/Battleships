package battleships.ships;

import java.util.Collections;
import java.util.List;

public class OilPlatform extends Ship {
    // Constructor
    public OilPlatform(Field field, boolean horizontal) throws Exception {
        length = 2;
        width = 2;
        isHorizontal = horizontal;
        this.setCoordinates(isHorizontal, field);
    }

    // Methods
    @Override
    public void setCoordinates(boolean isHorizontal, Field position) throws Exception {
        for (int l = 1; l < this.length; l++) {
            if ((position.getX() + length) > 9 || (position.getY() + length) > 9) {
                throw new Exception(OUT_OF_BOUND_EXCEPTION_CAUSE);
            } else {
                this.occupiedCoordinates.add(new Field(position.getX() + l, position.getY()));
                for (Field test : occupiedCoordinates) {
                    occupiedCoordinates.add(new Field(test.getX() + 1, test.getY() + 1));
                }
            }
        }
    }
}
