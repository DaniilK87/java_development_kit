package org.example.homework1.client;

import org.example.homework1.entity.Message;
import org.example.homework1.server.ServerController;

public class ClientController {

    private boolean isClientConnect;
    private Message message = new Message();
    private ClientView clientView;
    private ServerController server;

    private String name;

    public ClientController(ClientView clientView, ServerController server) {
        this.clientView = clientView;
        this.server = server;
        clientView.setClientController(this);
    }

    public boolean isClientConnect() {
        return isClientConnect;
    }

    public Message getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public void connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            message.setText(name + " " + "Вы успешно подключились!\n");
            showOnWindow(message);
            String log = server.loadHistory();
            if (log != null){
                message.setText(log);
                showOnWindow(message);
            }
        } else {
            message.setText("Нет подключения" + "\n");
            showOnWindow(message);
        }
    }

    public void disconnectedFromServer() {
        if (isClientConnect) {
            isClientConnect = false;
            clientView.disconnectedFromServer();
        }
    }

    public void disconnectFromServer() {
        server.disconnectUser(this);
    }

    public void answerFromServer(Message message) {
        showOnWindow(message);
    }

    public void message(Message message) {
        if (!isClientConnect) {
            if (!message.getText().isEmpty()) {
                server.message(message);
            }
        } else {
            message.setText("Сообщение не отправлено" + "\n");
            showOnWindow(message);
        }
    }

    private void showOnWindow(Message message) {
        clientView.showMessage(message);
    }
}
