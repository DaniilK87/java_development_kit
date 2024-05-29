package org.example.homework1.server;

import org.example.homework1.repo.FileStorage;
import org.example.homework1.client.ClientController;
import org.example.homework1.entity.Message;
import org.example.homework1.repo.Repository;

import java.util.ArrayList;
import java.util.List;

public class ServerController  {

    private List<ClientController> clientList;
    private boolean isServerWorking;
    private Message message;
    private ServerView serverView;
    private Repository repo;

    public ServerController(ServerView serverView, Repository repo) {
        this.repo = repo;
        this.serverView = serverView;
        clientList = new ArrayList<>();
        message = new Message();
        serverView.setServerController(this);
    }

    public void sendMessageToAllClient(Message message) {
        for (ClientController client: clientList) {
            client.answerFromServer(message);
        }
    }

    public void message(Message message) {
        if (!isServerWorking) return;
        repo.saveHistory(message);
        showOnWindow(message);
        sendMessageToAllClient(message);
    }


    public boolean connectUser(ClientController clientController) {
        if (!isServerWorking){
            return false;
        }
        clientList.add(clientController);
        message.setText(clientController.getName() + " " + "подключился");
        showOnWindow(message);
        return true;
    }

    public void disconnectUser(ClientController clientController){
        clientList.remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
            message.setText(clientController.getName() + " " + "отключился");
            showOnWindow(message);
        }
    }

    public void connect() {
        if (isServerWorking){
            message.setText("Сервер уже был запущен");
            showOnWindow(message);
        } else {
            isServerWorking = true;
            message.setText("Сервер запущен!");
            showOnWindow(message);
            System.out.println("Server start" + " " + isServerWorking + "\n");
        }
    }

    public void disconnect() {
        if (!isServerWorking){
            message.setText("Сервер уже был остановлен");
            showOnWindow(message);
        } else {
            isServerWorking = false;
            while (!clientList.isEmpty()){
                disconnectUser(clientList.get(clientList.size()-1));
            }
            message.setText("Сервер остановлен!");
            showOnWindow(message);
        }
        System.out.println("Server stopped" + " " + isServerWorking + "\n");
    }

    public String loadHistory() {
        return repo.loadHistory();
    }

    private void showOnWindow(Message message) {
        serverView.showMessage(message);
    }

}
