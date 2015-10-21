import interfaces.IChatClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 * Chat client class
 */
public class ChatClient implements IChatClient, Runnable {
    private String host;
    private int port;
    private Thread clientThread;
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;
    private JTextArea outText;

    public void setOutText(JTextArea outText) {
        this.outText = outText;
    }
    
    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
    
    public void setupClient(){
        try {
            s = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setupClient(Socket s) {
        setupClient();
    }
    
    public void iniciar(){
        clientThread = new Thread(this);
        clientThread.start();
    }
    
    public void receiveMessage(){
        try {
            String msg;
            while((msg = in.readLine()) != null){
                outText.append(msg);
                outText.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String msg){
        out.println(msg);
        out.flush();
        System.out.println(msg);
    }

    @Override
    public void run() {
        setupClient();
        receiveMessage();
    }
}
