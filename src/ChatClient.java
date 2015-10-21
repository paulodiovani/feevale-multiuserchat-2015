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
    String host;
    int porta;
    Thread thCliente;
    Socket s;
    BufferedReader in;
    PrintWriter out;
    JTextArea txtSaida;

    public void setTxtSaida(JTextArea txtSaida) {
        this.txtSaida = txtSaida;
    }
    
    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public int getPorta() {
        return porta;
    }
    
    public void setupClient(){
        try {
            s = new Socket(host, porta);
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
        thCliente = new Thread(this);
        thCliente.start();
    }
    
    public void receiveMessage(){
        try {
            String msg;
            while((msg = in.readLine()) != null){
                txtSaida.append(msg);
                txtSaida.append("\n");
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
