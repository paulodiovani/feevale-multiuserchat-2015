package interfaces;

/**
 * Chat interface for clients
 */
public interface IChatClient {
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
