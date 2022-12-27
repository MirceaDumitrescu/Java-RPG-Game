package generators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Directions {
    private static final String[] CARDINAL_DIRECTIONS = {"north", "east", "south", "west"};

    private static final Random random = new Random();

    public static ArrayList<String> generateMap(int size) {
        ArrayList<String> map = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            map.add(CARDINAL_DIRECTIONS[random.nextInt(CARDINAL_DIRECTIONS.length)]);
        }

        return map;
    }

    public static boolean getDirection(ArrayList<String> map, String direction) {
        if (map.size() > 0 && map.get(0).equals(direction)) {
            map.remove(0);
            return true;
        }
        return false;
    }


    public static String chooseDirection(ArrayList<String> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(map);
        while (true) {
            System.out.println("Enter a direction (North, East, South, West):");
            String direction = scanner.next().toLowerCase();

            if (!Directions.getDirection(map, direction)) {
                System.out.println("Invalid direction!");
                continue;
            }
            Encounters.chooseEncounter();
        }
    }
}
