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
        kryo.register(class);
    }

    public void start() throws IOException {
        server.start();
        server.bind(54555, 54777);
        server.addListener(new Listener() {

            @Override
            public void connected(Connection connection) {
                Listener.super.connected(connection);
            }

            public void received(Connection connection, Object object) {
                if (object instanceof Data) {
                    data = (Data) object;
                    System.out.println("FROM CLIENT: " + data.content);
                    sendTCP();
                }
            }
        });
    }

    public void sendTCP() {
        server.sendToAllTCP(data);
    }

    public void stop() {
        server.stop();
    }
}
