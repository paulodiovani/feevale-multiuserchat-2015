/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class ExecutaServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MultiUserChatServer mucs = new MultiUserChatServer();
        mucs.configurarServidor();
        mucs.aguardarClientes();
    }
    
}
