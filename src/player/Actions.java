package player;

import utils.Utils;

import java.util.Random;
import java.util.Scanner;

public class Actions {


    public static void engageEncounter(String[] actions) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display the available actions
            Utils.printLinedText("Actions:");
            for (int i = 0; i < actions.length; i++) {
                System.out.println((i + 1) + ". " + actions[i]);
            }
            // Ask the player to choose an action
            int choice = Integer.parseInt(Utils.askQuestion("Choose an action: ", "-"));
            if (choice >= 1 && choice <= actions.length) {
                // Valid choice
                String action = actions[choice - 1];
                // Perform the chosen action
                System.out.println("Performing action: " + action);
                Utils.loadingBar();
                // 50% chance to succeed or fail
                Random random = new Random();
                if (random.nextInt(2) == 0) {
                    // Success!
                    System.out.println("Action succeeded!");
                    // Give the player a random reward
                    int experience = random.nextInt(41) + 10; // Random number between 10 and 50
                    int coins = random.nextInt(5) + 1; // Random number between 1 and 5
                    System.out.println("You gained " + experience + " experience points and " + coins + " coins!");
                    PlayerInventory.addItem("Experience", experience);
                    PlayerInventory.addItem("Coins", coins);
                    System.out.println("You now have " + PlayerInventory.getQuantity("Experience") + " experience points and " + PlayerInventory.getQuantity("Coins") + " coins.");
                    Utils.loadingBar();
                    break;
                } else {
                    System.out.println("Action failed!");
                    // remove the choice from the actions array
                    actions = removeAction(actions, choice - 1);
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private static String[] removeAction(String[] actions, int i) {
        String[] newActions = new String[actions.length - 1];
        for (int j = 0; j < actions.length; j++) {
            if (j < i) {
                newActions[j] = actions[j];
            } else if (j > i) {
                newActions[j - 1] = actions[j];
            }
        }
        return newActions;
    }


}
