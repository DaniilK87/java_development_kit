package org.example.homework1.server;

import org.example.homework1.entity.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerWindow extends JFrame implements ServerView {

    private static final int POS_X = 500;
    private static final int POS_Y = 500;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;


    private final JPanel panelTop = new JPanel(new GridLayout(1,2));
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();

    private ServerController serverController;

    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    public ServerWindow() throws IOException {
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnect();
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WIDTH,HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        panelTop.add(btnStart);
        panelTop.add(btnStop);
        add(panelTop, BorderLayout.SOUTH);

        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
    }


    @Override
    public void showMessage(Message message) {
        log.append(message.getText() + "\n");
    }

    @Override
    public void disconnect() {
       serverController.disconnect();
    }

    @Override
    public void connect() {
       serverController.connect();
    }
}
