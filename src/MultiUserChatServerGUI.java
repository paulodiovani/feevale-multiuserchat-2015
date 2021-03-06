/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import interfaces.IChatClient;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Thaís
 */
public class MultiUserChatServerGUI extends javax.swing.JFrame {
    private String username;
    private String host;
    private int port;
    private ChatClient client;

    /**
     * Creates new form MultiUserChatServerGUI
     */
    public MultiUserChatServerGUI() {
        initComponents();
        initWindowListeners();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtMsgEnviada = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMsgUsuarios = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListaUsuarios = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMsgEnviada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsgEnviadaActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtMsgUsuarios.setColumns(20);
        txtMsgUsuarios.setRows(5);
        jScrollPane3.setViewportView(txtMsgUsuarios);

        jListaUsuarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListaUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMsgEnviada, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMsgEnviada)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void initWindowListeners() {
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                try {
                    client = new ChatClient();
                    client.setupClient(host, port);
                    client.setOutText(txtMsgUsuarios);
                    client.setUsername(username);
                    client.login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                client.logout();
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
    }

    private void txtMsgEnviadaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             
    
    private void jListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }
    
    private void txtMsgUsuariosActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }
    
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String message = txtMsgEnviada.getText();
        txtMsgEnviada.setText("");
        client.sendMessage(message);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEnviar;
    private javax.swing.JList jListaUsuarios;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtMsgEnviada;
    private javax.swing.JTextArea txtMsgUsuarios;
    // End of variables declaration
}
