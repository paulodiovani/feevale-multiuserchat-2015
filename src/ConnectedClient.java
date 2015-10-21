import interfaces.IChatClient;
import interfaces.IChatServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Connected chat client class
 */
public class ConnectedClient implements IChatClient, Runnable {
    private Socket s;
    private IChatServer server;

    private Thread clientThread;
    private BufferedReader in;
    private PrintWriter out;

    public ConnectedClient(Socket s, IChatServer server){
        setupClient(s);
        this.server = server;
    }

    public void setupClient() throws Exception {
        throw new Exception("Missing argument 'Socket'");
    }
    
    public void setupClient(Socket s) {
        this.s = s;
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());
            clientThread = new Thread(this);
            clientThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage(){
        try {
            String msg;
            while((msg = in.readLine()) != null){
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
        out.println(msg);
        out.flush();
    }
    
    @Override
    public void run() {
        receiveMessage();
    }
}
