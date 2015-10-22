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
     * Get a list of connected clients
     * @return
     */
    List<IChatClient> getClients();
}
