package org.example.homework1.client;

import org.example.homework1.entity.Message;

public interface ClientView {


    void disconnectedFromServer();


    void showMessage(Message message);

    void setClientController(ClientController clientController);
}
