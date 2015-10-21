import interfaces.IChatServer;

/**
 * Static class to run a chat server
 */
public class ExecServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IChatServer server = new MultiUserChatServer();
        server.setupServer();
        server.waitForClients();
    }
    
}
