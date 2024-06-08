package org.example.homework6;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameService {
    Scanner scanner = new Scanner(System.in);
    GameData gameData = new GameData();
    List<Door> doorList = gameData.getDoorList();
    private static int round = 0;
    private static String result = null;

    public void startGame() {
        HashMap<Integer,String> map = new HashMap<>();
        while (round < 3) {
            Master.say("Выберите дверь 1,2 или 3");
            int step_1 = scanner.nextInt();
            Gamer.say("Я выбрал дверь номер:" + " " + step_1);
            Master.say("В качестве подсказки я открою одну дверь");

            int step_2 = scanner.nextInt();
            if (step_2 >= doorList.size()) {
                Master.say("За дверью " + step_2 + " " + doorList.get(step_2 - 1).getPrize());
            } else {
                Master.say("За дверью " + step_2 + " " + doorList.get(step_2).getPrize());
            }
            Master.say("Вы можете поменять свой выбор, или же открыть дверь: " + step_1);

            int step_3 = scanner.nextInt();
            for (Door door : doorList) {
                if (door.getNumber() == step_3 & door.getPrize().equals("Автомобиль")) {
                    Master.say("Вы выйграли автомобиль");
                    result = "Выйграл";
                    break;
                } else {
                    Master.say("Вы проиграли, за дверью " + step_3 + " " + "Козел");
                    result = "Проиграл";
                    break;
                }
            }
            round++;
            map.put(round,result);
        }
        System.out.println(map);
    }
}
