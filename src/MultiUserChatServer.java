
import interfaces.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Chat Server for various clients
 */
public class MultiUserChatServer implements IChatServer {
    static List<ClienteConectado> clientes = new ArrayList<>();
    ServerSocket ss;
    Socket socketNovoCliente;

    public void setupServer() {
        try {
            ss = new ServerSocket(8200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForClients() {
        try {
            while (true) {
                socketNovoCliente = ss.accept();
                ClienteConectado novoCliente = new ClienteConectado(socketNovoCliente);                
                clientes.add(novoCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
