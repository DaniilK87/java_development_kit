package org.example.homework1.server;

import org.example.homework1.entity.Message;

public interface ServerView {

    void showMessage(Message message);

    void disconnect();

    void connect();

    void setServerController(ServerController serverController);
}
