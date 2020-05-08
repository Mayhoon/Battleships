package battleships.server;

import battleships.enums.NetworkType;

import java.io.IOException;

public class Network {
    KryoServer kryoServer;
    KryoClient kryoClient;

    public void connect(NetworkType networkType) throws IOException {
        if (networkType.equals(NetworkType.CLIENT)) {
            kryoClient = new KryoClient();
            kryoClient.start();
        } else if (networkType.equals(NetworkType.HOST)) {
            kryoServer = new KryoServer();
            kryoServer.start();
        }
    }

    public void sendData(Data data) {
        if (kryoClient != null) {
            kryoClient.sendTCP();
        } else if (kryoServer != null) {
            kryoServer.sendTCP();
        }
    }

}
