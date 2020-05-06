package battleships.ships;

import battleships.enums.HitType;
import battleships.enums.ShipType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShipVersuch implements Serializable, Cloneable {
    // Type of the Ship via ENUM
    ShipType shipType = ShipType.MINESWEEPER;

    // Ships length
    private int length = 0;

    // Ships width
    private int width = 0;

    // All Coordinates occupied by a ship
    private List<Integer[]> occupiedCoordinates = new ArrayList<Integer[]>();

    // Hit Coordinates
    private List<Integer[]> hitCoordinates = new ArrayList<Integer[]>();

    // Layout
    private boolean isHorizontal = false;

    // ConstructorZ
    public ShipVersuch(ShipType shipType, List<Integer[]> coordinates) {
        switch (shipType) {
            case CARRIER:
                this.shipType = shipType;
                width = 1;
                length = 5;
                occupiedCoordinates = coordinates;
                break;

            case BATTLESHIP:
                this.shipType = shipType;
                width = 1;
                length = 4;
                occupiedCoordinates = coordinates;
                break;

            case CRUISER:
                this.shipType = shipType;
                width = 1;
                length = 3;
                occupiedCoordinates = coordinates;
                break;

            case MINESWEEPER:
                width = 1;
                length = 2;
                occupiedCoordinates = coordinates;
                break;

            case OIL_PLATFORM:
                this.shipType = shipType;
                width = 2;
                length = 2;
                occupiedCoordinates = coordinates;
                break;
        }
    }

    // Methods
    public HitType isHit(Field position) {
        for (Integer[] v: occupiedCoordinates) {
//            if (Field == position) {
//                if (!hitCoordinates.contains(v)) {
//                    hitCoordinates.add(v);
//                    return HitType.SUCCESS;
//                } else {
//                    return HitType.ALREADY_HIT;
//                }
//            }
        }
        return HitType.MISS;
    }

    public List<Integer[]> setCoordinates(boolean isHorizontal, Integer[] position, ShipType shipType) {
        ShipVersuch currentShip = new ShipVersuch(shipType, Collections.singletonList(position));
        currentShip.occupiedCoordinates.add(position);

        if (isHorizontal && shipType != ShipType.OIL_PLATFORM) {
            for (int l = 1; l < currentShip.length; l++) {
                if ((position[0] + currentShip.length) > 10 || (position[1] + currentShip.length) > 10) {
                    return null;
                } else {
                    currentShip.occupiedCoordinates.add(new Integer[] {position[0] + l, position[1]});
                }
            }
        } else if (!isHorizontal && shipType != ShipType.OIL_PLATFORM) {
            for (int l = 1; l < currentShip.length; l++) {
                if ((position[0] + currentShip.length) > 10 || (position[1] + currentShip.length) > 10) {
                    return null;
                } else {
                    currentShip.occupiedCoordinates.add(new Integer[] {position[0], position[1] + 1});
                }
            }
        }

        return null;
    }

    // Getter/Setter
    // Length
    public int getLength() {
        return length;
    }

    // Coordinates
    public void setOccupiedCoordinates(List<Integer[]> occupiedCoordinates) {
        this.occupiedCoordinates = occupiedCoordinates;
    }

    public List<Integer[]> getOccupiedCoordinates() {
        return occupiedCoordinates;
    }
}