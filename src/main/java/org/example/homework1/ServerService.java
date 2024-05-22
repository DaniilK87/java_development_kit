package org.example.homework1;


public interface ServerService {
    void getMessage(Message message);

    boolean connectUser(ClientGUI clientGUI);

    void disconnectUser(ClientGUI clientGUI);

    void saveHistory();

    void sendMessageToAllClient(Message message);

    String loadHistory();

}
