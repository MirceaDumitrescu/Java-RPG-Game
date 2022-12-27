package utils;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static void loadingBar() {
        Random random = new Random();
        System.out.println("Loading...");
        for (int i = 0; i < random.nextInt(10); i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void welcomeTitle() {
        String gameTitle = "The Text Dungeon";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to " + gameTitle + "!");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.println("Hello " + name + "!" + " The Text Dimension is a unknown and dangerous place. " +
                "There are only a few places that might provide safe haven for a weary traveller. " +
                "But beware. Some places might deceive you. ");


        // Agreement Block
        System.out.println("Okay get ready for the biggest adventure of your life? Yes/No");
        String agreed = scanner.next().toLowerCase();
        if (agreed.equals("no") || agreed.equals("n")) {
            System.out.println("You are a coward. You will never be a hero.Goodbye");
            System.exit(0);
        }
    }
}
