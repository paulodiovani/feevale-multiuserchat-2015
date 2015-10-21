package interfaces;

/**
 * Chat interface for Servers
 */
public interface ChatServer {
    /**
     * Configures and start a chat server
     */
    void setupServer();

    /**
     * Loop and wait for Socket client connections
     */
    void waitForClients();

}
