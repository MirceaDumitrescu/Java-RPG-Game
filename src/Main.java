import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Main {
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

    public static void enterTavern() {
        System.out.println();
        //The start of the underground tavern navigation
        System.out.println("You go to the tavern and see a few people to interact with. Who should you chat with first?");
        System.out.println("A. The bartender");
        System.out.println("B. The cook (Marcella)");
        System.out.println("C. The drunkard");
        System.out.println("D. The thief");
        System.out.println();
        System.out.println("Enter A, B, C, or D to choose your character.");
    }
    public static void main(String[] args) {
        String gameTitle = "The Text Dungeon";
        Scanner playerInputs = new Scanner(System.in);
        Hashtable<String, String> inventory = new Hashtable<String, String>();

        System.out.println("Welcome to " + gameTitle + "!");
        System.out.print("Enter your name: ");
        String name = playerInputs.next();
        System.out.println("Hello " + name + "!" + " The Text Dimension is a unknown and dangerous place. " +
                "There are only a few places that might provide safe haven for a weary traveller. " +
                "But beware. Some places might deceive you. ");


        // Agreement Block
        System.out.println("Okay get ready for the biggest adventure of your life? Yes/No");
        String agreed = playerInputs.next().toLowerCase();
        if ( agreed.equals("no") || agreed.equals("n")) {
            System.out.println("You are a coward. You will never be a hero.Goodbye");
            return;
        }

        System.out.print("Will you go to the North,South,East, or West?: ");
        String direction = playerInputs.next().toLowerCase();

        //Directions
        if (direction.equals("north") || direction.equals("south") || direction.equals("east")) {
            System.out.println("Path was not found and you fell in a hole. You died.");
            System.exit(0);
        }

        if (direction.equals("west") || direction.equals("w")) {
            System.out.println("Path found! You see a split road ahead. Do you got to the Right or Left? (right/left): ");
            String path = playerInputs.next().toLowerCase();
            if (path.equals("right")) {
                System.out.print("You see a fort nearby and head inside,");
                System.out.print("A troll spots you lurking and eats you. The end :(");
                System.exit(0);
            }

            if (path.equals("left")) {
                System.out.println("You spot a castle nearby and see a King. You recognize him as the notorious riddle questioner.");
            }


            //The start of the riddle 1
            System.out.println("He asks you a question: ");
            System.out.println("I’m tall when I’m young, and I’m short when I’m old. What am I? Hint: I burn: ");
            String riddle = playerInputs.next().toLowerCase();

            if (!riddle.contains("candle")) {
                System.out.println("Wrong. He throws you into a pit full with the deadliest snakes ever.");
                System.exit(0);
            }

            System.out.println("He is impressed and gives you a map to a underground tavern which leads to a hoard of mythical armour");
            loadingBar();

            enterTavern();
            String undergroundTavern = playerInputs.next().toLowerCase();


            if ( undergroundTavern.equals("a")) {
                System.out.println("You talk to the bartender and he gives you a drink. You feel a bit tipsy.");
                System.out.println("You see a chest in the corner of the room. Do you open it? (yes/no): ");
                String chest = playerInputs.next().toLowerCase();
                if (chest.equals("yes")) {
                    System.out.println("You open the chest and find a key. You put it in your pocket.");
                    enterTavern();
                }
                if (chest.equals("no")) {
                    System.out.println("You decide not to open the chest and leave the tavern.");
                }
            }

            if (undergroundTavern.equals("b")){
                // Print the quest introduction and dialogue options
                System.out.println("Quest: The Missing Ingredient");
                System.out.println(MessageFormat.format("Marcella: Hello {0}, I'm glad you stopped by. I have a favor to ask of you. I'm in need of a rare herb called moonflower for a special potion I'm brewing, but it's difficult to find in these parts. Would you be willing to help me track it down?", name));
                System.out.println("Dialogue options:");
                System.out.println("Option 1: Of course, I'll help you find the moonflower.");
                System.out.println("Option 2: I'm sorry, I don't have time for this right now.");

                // Get the player's response
                int response = playerInputs.nextInt();

                // Check the player's response and provide the appropriate dialogue
                if (response == 1) {
                    System.out.println(MessageFormat.format("{0}: Of course, I'll help you find the moonflower. Where should I start looking?", name));
                    System.out.println(MessageFormat.format("Marcella: Thank you, {0}. The moonflower grows in the darkest and wettest parts of the forest. It's a tough plant to find, but if you keep your eyes open and listen to the rustling of the leaves, you might be able to locate it. Good luck on your search.", name));
                } else if (response == 2) {
                    System.out.println(MessageFormat.format("{0}: I'm sorry, I don't have time for this right now.",name));
                    System.out.println("Marcella: Oh, I understand. Thank you for your honesty. If you change your mind and have some free time, don't hesitate to come back and see me. I could really use your help.");
                } else {
                    System.out.println("Invalid response. Please enter a valid dialogue option.");
                }
            }


            playerInputs.close();
        }

//The end of :  public static void main(String[] args)
    }
}