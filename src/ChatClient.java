import interfaces.IChatClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 * Chat client class
 */
public class ChatClient implements IChatClient, Runnable {
    private Thread clientThread;
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;
    private JTextArea outText;

    private static String HOST = "127.0.0.1";
    private static int PORT = 8200;

    public void setOutText(JTextArea outText) {
        this.outText = outText;
    }

    public void setupClient() {
        setupClient(HOST, PORT);
    }

    public void setupClient(String host) {
        setupClient(host, PORT);
    }

    public void setupClient(String host, int port){
        try {
            Socket s = new Socket(host, port);
            setupClient(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
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
    
    @Override
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

    @Override
    public void sendMessage(String msg){
        out.println(msg);
        out.flush();
        System.out.println("Client enviou: " + msg);
    }

    @Override
    public void run() {
        receiveMessage();
    }
}
