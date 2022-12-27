package player;

import java.util.HashMap;

public class PlayerInventory {
    private static HashMap<String, Integer> items = new HashMap<>();

    public PlayerInventory() {
        items = new HashMap<>();
    }

    public static int getQuantity(String item) {
        if (items.containsKey(item)) {
            return items.get(item);
        }
        return 0;
    }

    public static void addItem(String item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public static void printInventory() {
        for (String item : items.keySet()) {
            System.out.println(item + ": " + items.get(item));
        }
    }

    public void removeItem(String item, int quantity) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            if (currentQuantity > quantity) {
                items.put(item, currentQuantity - quantity);
            } else {
                items.remove(item);
            }
        }
    }
}