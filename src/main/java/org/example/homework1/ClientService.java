package org.example.homework1;

public interface ClientService {

    void getMessageFromServer(Message message);

    void connectToServer();

    void disconnectServer();

    void sendMessage();
}
