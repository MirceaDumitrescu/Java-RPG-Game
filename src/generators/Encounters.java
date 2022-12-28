package generators;

import player.Actions;
import utils.Utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Encounters {

    private static final String[] ENCOUNTER_TYPES = {"Enemy: Fight a group of bandits and gain their treasure.",
            "Building: Enter a tavern and talk to the locals for information.",
            "Traveler: Meet a traveling merchant and buy or sell items.",
            "Dungeon: Explore an abandoned ruin and find hidden treasures.",
            "Enemy: Defend against a group of wild animals and earn their pelts.",
            "Building: Visit a blacksmith and have your weapons and armor repaired.",
            "Traveler: Encounter a group of wanderers and join them on their journey.",
            "Dungeon: Investigate a mysterious cave and uncover its secrets.",
            "Enemy: Battle a group of goblins and earn their hoard of gold.",
            "Building: Enter a chapel and pray for guidance and protection.",
            "Traveler: Meet a traveling healer and purchase potions and remedies.",
            "Dungeon: Descend into a dark underground labyrinth and face its challenges.",
            "Enemy: Engage in a duel with a skilled swordsman and earn their respect.",
            "Building: Visit a library and learn new spells and abilities.",
            "Traveler: Meet a bard and listen to their tales and songs.",
            "Dungeon: Explore a haunted mansion and confront the ghosts within.",
            "Enemy: Fight a group of orcs and earn their respect.",
            "Building: Enter a magic shop and purchase magical items and artifacts.",
            "Traveler: Meet a wise old man and seek his advice and wisdom.",
            "Dungeon: Explore a dragon's lair and confront the beast itself."};
    // Array of actions for enemy encounters
    private static final String[] enemyActions = {
            "Fight",
            "Attempt to flee",
            "Negotiate",
            "Use a special ability"
    };
    // Array of actions for building encounters
    private static final String[] buildingActions = {
            "Enter the building",
            "Ignore the building",
            "Inspect the building",
            "Ask for directions"
    };
    // Array of actions for traveler encounters
    private static final String[] travelerActions = {
            "Talk to the traveler",
            "Ignore the traveler",
            "Ask for directions",
            "Trade items"
    };
    // Array of actions for dungeon encounters
    private static final String[] dungeonActions = {
            "Enter the dungeon",
            "Ignore the dungeon",
            "Inspect the dungeon",
            "Use a special ability"
    };

    public static ArrayList<String> generateEncounters() {
        ArrayList<String> encounters = new ArrayList<>();
        ArrayList<String> encounterTypes = new ArrayList<>(); // Keep track of generated encounter types
        Random random = new Random();
        int numEncounters = random.nextInt(5); // Generate a random number of encounters (0-4)
        for (int i = 0; i < numEncounters; i++) {
            String encounterType = ENCOUNTER_TYPES[random.nextInt(ENCOUNTER_TYPES.length)];
            if (!encounterTypes.contains(encounterType)) { // Ensure that no more than one of the same type is generated
                encounterTypes.add(encounterType);
                encounters.add(encounterType);
            }
        }
        return encounters;
    }

    public static void chooseEncounter() {
        ArrayList<String> encounters = generateEncounters();
        Scanner scanner = new Scanner(System.in);

        // Continue choosing encounters until there are none left
        while (!encounters.isEmpty()) {
            // Print the encounters
            Utils.printLinedText("Encounters:");
            for (int i = 0; i < encounters.size(); i++) {
                System.out.println(i + ": " + encounters.get(i));
            }
            System.out.println(encounters.size() + ": Avoid encounter");

            // Get the chosen encounter
            int encounterChoice = Integer.parseInt(Utils.askQuestion("Enter the number of the encounter you want to choose:", "-"));
            if (encounterChoice < 0 || encounterChoice > encounters.size()) {
                Utils.printLinedText("Invalid encounter choice!");
                continue;
            }

            // Perform the chosen encounter or move on if the player chose to avoid
            if (encounterChoice == encounters.size()) {
                Utils.printLinedText("You continue on your journey.");
                Utils.loadingBar();
                break;
            } else {
                String chosenEncounter = encounters.get(encounterChoice);
                performEncounter(chosenEncounter);
                encounters.remove(encounterChoice);
            }
        }

        Utils.printLinedText("You have finished all of the encounters in this location. Choose a new location to move on (North, East, South, West):");
    }

    public static void performEncounter(String encounter) {
        String[] words = encounter.split(" ");
        String type = words[0].substring(0, words[0].length() - 1);
        String[] actions = new String[0];
        if (type.equals("Enemy")) {
            actions = enemyActions;
        } else if (type.equals("Building")) {
            actions = buildingActions;
        } else if (type.equals("Traveler")) {
            actions = travelerActions;
        } else if (type.equals("Dungeon")) {
            actions = dungeonActions;
        } else {
            System.out.println("Invalid encounter type: " + type);
        }
        Actions.engageEncounter(actions);
    }
}
