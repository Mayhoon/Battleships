package battleships.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

public class KryoServer {
    private Server server;
    private Data data;

    public KryoServer() {
        server = new Server();

        //Register classes
        Kryo kryo = server.getKryo();
        kryo.register(Data.class);
    }

    public void start() throws IOException {
        server.start();
        server.bind(54555, 54777);
        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Data) {
                    data = (Data) object;
                    System.out.println(data.content);
                }
            }
        });
    }

    public void sendTCP() {
        server.sendToAllTCP(data);
    }
}
