package interfaces;

import java.util.List;

/**
 * Chat interface for Servers
 */
public interface IChatServer {
    /**
     * Configures and start a chat server
     */
    void setupServer();

    /**
     * Configures and start a chat server
     */
    void setupServer(int port);

    /**
     * Loop and wait for Socket client connections
     */
    void waitForClients();

    /**
     * Get a list of connected clients
     * @return
     */
    List<IChatClient> getClients();
}
