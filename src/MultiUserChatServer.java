
import interfaces.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Chat Server for various clients
 */
public class MultiUserChatServer implements IChatServer {
    private List<IChatClient> clients = new ArrayList<>();
    private ServerSocket ss;

    private static int PORT = 8200;

    public void setupServer() {
        try {
            ss = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForClients() {
        try {
            while (true) {
                Socket socketNovoCliente = ss.accept();
                ConnectedClient novoCliente = new ConnectedClient(socketNovoCliente, this);
                clients.add(novoCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<IChatClient> getClients() {
        return clients;
    }
}
