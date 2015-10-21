import interfaces.ChatServer;

/**
 * Static class to run a chat server
 */
public class ExecServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChatServer server = new MultiUserChatServer();
        server.setupServer();
        server.waitForClients();
    }
    
}
