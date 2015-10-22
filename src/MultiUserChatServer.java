
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

    @Override
    public void setupServer() {
        setupServer(PORT);
    }

    @Override
    public void setupServer(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void waitForClients() {
        try {
            while (true) {
                Socket clientSocket = ss.accept();
                ConnectedClient client = new ConnectedClient(clientSocket, this);
                System.out.println("New client connected from " + clientSocket.getInetAddress().getHostAddress());
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<IChatClient> getClients() {
        return clients;
    }
}
