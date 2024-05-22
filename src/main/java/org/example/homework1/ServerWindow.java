package org.example.homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame implements ServerService{

    private static final int POS_X = 500;
    private static final int POS_Y = 500;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    List<ClientGUI> clientGUIList;

    private final JPanel panelTop = new JPanel(new GridLayout(1,2));
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private boolean isServerWorking;


    public boolean isServerWorking() {
        return isServerWorking;
    }


    public ServerWindow() throws IOException {
        clientGUIList = new ArrayList<>();

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking){
                    appendLog("Сервер уже был остановлен");
                } else {
                    isServerWorking = false;
                    while (!clientGUIList.isEmpty()){
                        disconnectUser(clientGUIList.get(clientGUIList.size()-1));
                    }
                    appendLog("Сервер остановлен!");
                }
                System.out.println("Server stopped" + " " + isServerWorking + "\n");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking){
                    appendLog("Сервер уже был запущен");
                } else {
                    isServerWorking = true;
                    appendLog("Сервер запущен!");
                    System.out.println("Server start" + " " + isServerWorking + "\n");
                }
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

    private void appendLog(String text) {
        log.append(text + "\n");
    }


    @Override
    public void getMessage(Message message) {
        if (!isServerWorking()) return;
        log.append(message.getText() + "\n");
        sendMessageToAllClient(message);
        saveHistory();
    }

    @Override
    public boolean connectUser(ClientGUI clientGUI) {
        if (!isServerWorking()){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    @Override
    public void disconnectUser(ClientGUI clientGUI){
        clientGUIList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnectServer();
        }
    }

    @Override
    public void saveHistory() {
        try(FileWriter fileWriter = new FileWriter("log.txt", true)) {
            fileWriter.write(log.getText());
            fileWriter.write('\n');
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void sendMessageToAllClient(Message message) {
        for (ClientGUI client: clientGUIList) {
            client.getMessageFromServer(message);
        }
    }

    @Override
    public String loadHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader("log.txt")){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
