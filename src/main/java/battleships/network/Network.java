package battleships.network;

import battleships.enums.NetworkType;

public class Network {
    private KryoServer kryoServer;
    private KryoClient kryoClient;
    private NetworkEntity networkEntity;
    private Data player;

    public Network() {
        player = new Data();
    }

    public void connect(NetworkType networkType) {
        if (networkType.equals(NetworkType.CLIENT)) {
            player.number = 20;
            kryoClient = new KryoClient();
            kryoClient.start();
        } else if (networkType.equals(NetworkType.HOST)) {
            kryoServer = new KryoServer();
            kryoServer.start();
        }
    }

    public void sendData(Data data) {
//        networkEntity.sendTCP(data);
        if (kryoClient != null) {
            kryoClient.sendTCP(data);
        } else if (kryoServer != null) {
            kryoServer.sendTCP(data);
        }
    }

    public Data opponent() {
//        networkEntity.opponent();
        if (kryoClient != null) {
            return kryoClient.opponent();
        } else if (kryoServer != null) {
            return kryoServer.opponent();
        }
        return null;
    }
}
