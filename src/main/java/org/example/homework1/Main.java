package org.example.homework1;


import org.example.homework1.client.ClientController;
import org.example.homework1.client.ClientGUI;
import org.example.homework1.repo.FileStorage;
import org.example.homework1.server.ServerController;
import org.example.homework1.server.ServerWindow;

import java.io.IOException;

/**
 * Реализовать клиент-серверное приложение. Начало его можно увидеть в презентации к первому уроку,
 * а можно ориентироваться на скриншоты.
 * Результат можно увидеть на скриншотах, которые также можно найти в материалах к уроку
 * Клиентское приложение должно отправлять сообщения из текстового поля сообщения в серверное приложение
 * по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
 * Продублировать импровизированный лог (историю) чата в файле;
 * При запуске клиента чата заполнять поле истории из файла, если он существует.
 * Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером,
 * а не при открытии окна клиента.
 */
public class Main {


    public static void main(String[] args) {
        ServerController serverController = null;
        try {
            serverController = new ServerController(new ServerWindow(), new FileStorage());
            new ClientController(new ClientGUI(), serverController);
            new ClientController(new ClientGUI(), serverController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
