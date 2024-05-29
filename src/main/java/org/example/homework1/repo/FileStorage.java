package org.example.homework1.repo;

import org.example.homework1.entity.Message;
import org.example.homework1.repo.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Repository {
    @Override
    public void saveHistory(Message message) {
        try(FileWriter fileWriter = new FileWriter("log.txt", true)) {
            fileWriter.write(message.getText());
            fileWriter.write('\n');
        } catch (IOException ex) {
            throw new RuntimeException(ex);
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
