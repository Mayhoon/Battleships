package battleships.server;

import battleships.enums.Networking;

import java.io.IOException;

public class Starter {
    private KryoServer kryoServer;
    private KryoClient kryoClient;

    public Starter(Networking type) throws IOException {
        if (type.equals(Networking.CLIENT)) {
            kryoClient = new KryoClient();
            kryoClient.start("localhost");

        } else if (type.equals(Networking.HOST)) {
            kryoServer = new KryoServer();
            kryoServer.start();
        }
    }

    public void startServer() throws IOException {
        kryoServer.start();
    }

    public void startClient() throws IOException {
        kryoClient.start("localhost");
    }
}
