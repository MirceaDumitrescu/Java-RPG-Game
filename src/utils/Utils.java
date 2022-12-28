package utils;

import player.PlayerData;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static void loadingBar() {
        Random random = new Random();
        String loadingBar = "[";
        int maxLength = 50;
        for (int i = 0; i < maxLength; i++) {
            // Generate a random number between 0 and 100
            int progress = random.nextInt(100);
            // Calculate the length of the loading bar
            int barLength = (int) Math.round(progress / 100.0 * maxLength);
            // Fill the loading bar with the progress character
            for (int j = 0; j < barLength; j++) {
                loadingBar += "=";
            }
            // Fill the rest of the loading bar with the empty character
            for (int j = barLength; j < maxLength; j++) {
                loadingBar += " ";
            }
            // Print the loading bar and the progress percentage
            System.out.print("\r" + loadingBar + "] " + progress + "%");
            try {
                // Wait a random amount of time
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                // Ignore exception
            }
            // Reset the loading bar for the next iteration
            loadingBar = "[";
        }
        System.out.println();
    }

    public static void welcomeTitle() {
        String gameTitle = "The Text Dungeon";
        Scanner scanner = new Scanner(System.in);
        printLinedText("Welcome to " + gameTitle + "!");
        String name = askQuestion("Enter your name: ", "-");
        PlayerData.savePlayerData("Name", name);

        System.out.println("The Text Dimension is a unknown and dangerous place.There are only a few places that might provide safe haven for a weary traveller. But beware. Some places might deceive you. ");


        // Agreement Block
        String agreed = askQuestion("Okay get ready for the biggest adventure of your life? Yes/No", "-");
        if (agreed.equals("no") || agreed.equals("n")) {
            printLinedText("You are a coward. You will never be a hero.Goodbye");
            System.exit(0);
        }
    }

    public static void printLinedText(String text) {
        // Calculate the number of spaces to add on each side of the text
        int spaces = (80 - text.length()) / 2;
        // Print the dotted line above the text
        System.out.println(String.format("%0" + 80 + "d", 0).replace("0", "."));
        // Print the text
        System.out.println(String.format("%0" + spaces + "d", 0).replace("0", " ") + text + String.format("%0" + spaces + "d", 0).replace("0", " "));
        // Print the dotted line below the text
        System.out.println(String.format("%0" + 80 + "d", 0).replace("0", "."));
    }

    public static String askQuestion(String question, String lineChar) {
        Scanner scanner = new Scanner(System.in);
        // Print the question with a line of the specified character above and below it
        System.out.println(question);
        System.out.println(String.format("%" + 80 + "s", "").replace(" ", String.valueOf(lineChar)));
        // Ask for the player's input with a blinking arrow
        while (true) {
            System.out.print("\r> ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Ignore exception
            }
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
            System.out.print("\r  ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Ignore exception
            }
        }
    }
}
