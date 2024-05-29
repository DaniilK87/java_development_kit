package org.example.homework1.client;


import org.example.homework1.entity.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class ClientGUI extends JFrame implements ClientView {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2,3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JButton btnLogin = new JButton("Login");
    private final JTextField tfLogin = new JTextField("login");
    private final JPasswordField tfPassword = new JPasswordField("pass");

    private final JPanel panelBottom = new JPanel(new GridLayout(1,2));
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private ClientController clientController;

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public ClientGUI() throws IOException {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientController.connectToServer(tfLogin.getText());
                if (clientController.isClientConnect()) {
                    panelTop.setVisible(true);
                } else {
                    panelTop.setVisible(false);
                }

            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message message = clientController.getMessage();
                message.setText(tfLogin.getText() + " " + tfMessage.getText());
                clientController.message(message);
                tfMessage.setText("");
            }
        });


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setTitle("Chat client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(new JPanel());
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(tfMessage);
        panelBottom.add(btnSend);
        add(panelTop,BorderLayout.NORTH);
        add(panelBottom,BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);
        setVisible(true);
    }

    @Override
    public void disconnectedFromServer() {
        panelTop.setVisible(true);
        log.append("Вы отключены от сервера!");
    }

    public void disconnectFromServer(){
        clientController.disconnectFromServer();
    }

    @Override
    public void showMessage(Message message) {
        log.append(message.getText() + "\n");
    }


    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
    }
}
