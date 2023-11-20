package MontyHallParadox;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> resultMap = new HashMap<>();
        Random random = new Random();
        int trial = 1000;

        System.out.println("Игрок не меняет решение.");
        int win = 0;
        for (int i = 0; i < trial; i++) {
            int prizeDoor = random.nextInt(3);
            int playerDoor = random.nextInt(3);

            if (playerDoor == prizeDoor) {
                win++;
            }
        }

        double result = (double) win / trial * 100;
        String formattedResult = new DecimalFormat("#0.00").format(result);
        resultMap.put(trial,formattedResult);
        resultMap.forEach((key, value) -> System.out.println("Игр сыграно: " + key +  "\n" + "Процент побед: " + value + " %"));
        System.out.println();

        System.out.println("Игрок меняет решение:");
        win = 0;
        for (int i = 0; i < trial; i++) {
            int prizeDoor = random.nextInt(3);
            int playerDoor = random.nextInt(3);

            int wrongDoor = prizeDoor;

            while (wrongDoor == prizeDoor || wrongDoor == playerDoor) {
                wrongDoor = random.nextInt(3);
            }

            int alternateDoor = 3 - (playerDoor + wrongDoor);

            if (alternateDoor == prizeDoor) {
                win++;
            }
        }
        result = (double) win / trial * 100;
        formattedResult = new DecimalFormat("#0.00").format(result);
        resultMap.put(trial,formattedResult);
        resultMap.forEach((key, value) -> System.out.println("Игр сыграно: " + key +  "\n" + "Процент побед: " + value + " %"));
    }
}
