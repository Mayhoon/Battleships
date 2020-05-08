package battleships.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class KryoClient {
    private Client client;
    private Data data;

    public KryoClient() {
        client = new Client();

        //Register classes
        Kryo kryo = client.getKryo();
        kryo.register(Data.class);
    }

    public void start() throws IOException {
        client.start();
        client.connect(5000, "localhost", 54555, 54777);
        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Data) {
                    data = (Data) object;
                    System.out.println("FROM SERVER: " + data.content);
                    sendTCP();
                }
            }
        });
    }

    public void sendTCP() {
        client.sendTCP(data);
    }
}
