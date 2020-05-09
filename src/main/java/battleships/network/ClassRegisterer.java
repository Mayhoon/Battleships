package battleships.network;

import battleships.ships.Ship;
import com.esotericsoftware.kryo.Kryo;

import java.util.ArrayList;

//Classes that the server and client have to serialize.
public class ClassRegisterer {
    public Kryo addClasses(Kryo kryo) {
        kryo.register(Data.class);
        kryo.register(Ship.class);
        kryo.register(ArrayList.class);
        return kryo;
    }
}
