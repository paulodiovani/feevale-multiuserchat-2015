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
     */
    void setupClient(Socket socket);

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
