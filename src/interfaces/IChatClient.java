package interfaces;

import java.net.Socket;

/**
 * Chat interface for clients
 */
public interface IChatClient {
    /**
     * Configure the chat client Socket
     */
    void setupClient() throws Exception;

    /**
     * Configure the chat client Socket
     *
     * @param host
     */
    void setupClient(String host) throws Exception;

    /**
     * Configure the chat client Socket
     *
     * @param host
     * @param port
     */
    void setupClient(String host, int port) throws Exception;

    /**
     * Configure the chat client Socket
     *
     * @param socket
     */
    void setupClient(Socket socket) throws Exception;

    /**
     *
     * @param username
     */
    void setUsername(String username);

    /**
     *
     * @return
     */
    String getUsername();

    /**
     * Send a message to other client(s)
     * @param message
     */
    void sendMessage(String message);

    /**
     * Prints messages received from other client(s)
     */
    void receiveMessage();
}
