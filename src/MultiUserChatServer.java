
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
            System.out.println("Server listening on port " + PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
