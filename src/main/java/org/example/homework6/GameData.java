package org.example.homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameData {

    public List<Door> getDoorList() {
        List<Door> doorList = new ArrayList<>();
        Random random = new Random();

        List<Integer> doorNumberList = random.ints(1, 4)
                .distinct().limit(3).boxed().collect(Collectors.toList());

        doorList.add(new Door(doorNumberList.get(0),"Автомобиль"));
        doorList.add(new Door(doorNumberList.get(1),"Козел"));
        doorList.add(new Door(doorNumberList.get(2), "Козел"));
        System.out.println(doorList);
        return doorList;
    }
}
