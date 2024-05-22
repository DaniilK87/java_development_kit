package org.example.homework1;


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
        ServerWindow serverWindow = null;
        try {
            serverWindow = new ServerWindow();
            new ClientGUI(serverWindow);
            new ClientGUI(serverWindow);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
