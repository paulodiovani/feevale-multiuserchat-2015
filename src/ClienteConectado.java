import interfaces.IChatClient;
import interfaces.IChatServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Connected chat client class
 */
public class ClienteConectado implements IChatClient, Runnable {
    private Socket s;
    private IChatServer server;

    Thread thRecebeMsg;
    BufferedReader entrada;
    PrintWriter saida;

    public ClienteConectado(Socket s, IChatServer server){
        setupClient(s);
        this.server = server;
    }

    public void setupClient() throws Exception {
        throw new Exception("Missing argument 'Socket'");
    }
    
    public void setupClient(Socket s) {
        this.s = s;
        try {
            entrada = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            saida = new PrintWriter(s.getOutputStream());
            thRecebeMsg = new Thread(this);
            thRecebeMsg.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void receiveMessage(){
        try {
            String msg;
            while((msg = entrada.readLine()) != null){
                System.out.println(msg);
                for(IChatClient cliente:server.getClients()){
                    cliente.sendMessage(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String msg){
        saida.println(msg);
        saida.flush();
    }
    
    @Override
    public void run() {
        receiveMessage();
    }
    
    
}
