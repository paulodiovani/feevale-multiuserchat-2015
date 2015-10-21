
import interfaces.IChatClient;
import interfaces.IChatServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteConectado implements IChatClient, Runnable {
    private Socket s;
    private IChatServer server;

    Thread thRecebeMsg;
    BufferedReader entrada;
    PrintWriter saida;

    public ClienteConectado(Socket s, IChatServer server){
        configurarCliente(s);
        this.server = server;
    }
    
    public void configurarCliente(Socket s){
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

    public void receberMensagens(){
        try {
            String msg;
            while((msg = entrada.readLine()) != null){
                System.out.println(msg);
                for(IChatClient cliente:server.getClients()){
                    cliente.enviarMensagem(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void enviarMensagem(String msg){
        saida.println(msg);
        saida.flush();
    }
    
    @Override
    public void run() {
        receberMensagens();
    }
    
    
}
