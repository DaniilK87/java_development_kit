package org.example.homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class ClientGUI extends JFrame implements ClientService {
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

    private boolean isClientConnect;
    private String name;
    private Message message;

    private ServerWindow server;

    ClientGUI(ServerWindow serverWindow) throws IOException {
        this.server = serverWindow;
        message = new Message();
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
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
    public void connectToServer() {
        if (server.connectUser(this)){
            name = tfLogin.getText();
            appendLog(name + " " + "успешно подключен!\n");
            panelTop.setVisible(false);
            isClientConnect = true;
            String log = server.loadHistory();
            if (log != null){
                appendLog(log);
            }
        } else {
            appendLog("Подключение не удалось");
        }
    }

    @Override
    public void disconnectServer() {
        if (isClientConnect) {
            panelTop.setVisible(true);
            isClientConnect = false;
            server.disconnectUser(this);
            appendLog("Вы отключены от сервера!");
        }
    }

    @Override
    public void sendMessage() {
        if (server.isServerWorking()) {
            message.setText(tfLogin.getText() + " " + tfMessage.getText());
            log.append(message.getText() + "\n");
            server.getMessage(message);
            tfMessage.setText("");
        } else {
            appendLog("Нет подключения" + "\n");
        }
    }

    @Override
    public void getMessageFromServer(Message message) {
        appendLog(message.getText() + "\n");
    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }
}
