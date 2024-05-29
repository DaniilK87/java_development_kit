package org.example.homework1.repo;

import org.example.homework1.entity.Message;

public interface Repository {

    void saveHistory(Message message);

    String loadHistory();
}
