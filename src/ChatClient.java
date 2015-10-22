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

    private String username;

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
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
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

    public void login() {
        sendMessage(username, Message.LOGIN);
    }

    public void logout() {
        sendMessage(username, Message.LOGOUT);
    }

    @Override
    public void sendMessage(String msg) {
        sendMessage(msg, Message.CHAT);
    }

    public void sendMessage(String msg, String type){
        Message message = new Message();
        message.setType(type);
        message.setContent(msg);

        out.println(message);
        out.flush();
        System.out.println(this.username + " enviou: " + msg);
    }

    @Override
    public void run() {
        receiveMessage();
    }
}
