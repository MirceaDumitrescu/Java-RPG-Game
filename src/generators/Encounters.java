package generators;

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
        System.out.println(encounters);

        // Continue choosing encounters until there are none left
        while (!encounters.isEmpty()) {
            // Print the encounters
            System.out.println("Encounters:");
            for (int i = 0; i < encounters.size(); i++) {
                System.out.println(i + ": " + encounters.get(i));
            }
            System.out.println(encounters.size() + ": Avoid encounter");

            // Get the chosen encounter
            System.out.println("Enter the number of the encounter you want to choose:");
            int encounterChoice = scanner.nextInt();
            if (encounterChoice < 0 || encounterChoice > encounters.size()) {
                System.out.println("Invalid encounter choice!");
                continue;
            }

            // Perform the chosen encounter or move on if the player chose to avoid
            if (encounterChoice == encounters.size()) {
                System.out.println("Avoiding encounter.");
                break;
            } else {
                String chosenEncounter = encounters.get(encounterChoice);
                // Remove the chosen encounter from the list
                encounters.remove(encounterChoice);
                System.out.println("Performing encounter: " + chosenEncounter);
                // ... (add code to perform the chosen encounter here) ...
            }
        }

        // All encounters have been finished, choose a new location to move on
        System.out.println("All encounters have been finished. Choose a new location to move on (North, East, South, West):");
        // ... (add code to move to the chosen location here) ...
    }
}
