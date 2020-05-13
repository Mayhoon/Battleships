package battleships.network;

import battleships.enums.NetworkType;

public class Network {
    private NetworkEntity networkEntity;
    private Data player;

    public Network() {
        player = new Data();
    }

    public void connect(NetworkType networkType) {
        if (networkType.equals(NetworkType.CLIENT)) {
            player.number = 20;
            networkEntity = new KryoClient();
            networkEntity.start();
        } else if (networkType.equals(NetworkType.HOST)) {
            networkEntity = new KryoServer();
            networkEntity.start();
        }
    }

    public void sendData(Data data) {
        networkEntity.sendTCP(data);
    }

    public Data opponent() {
        return networkEntity.opponent();
    }
}
