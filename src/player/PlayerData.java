package player;

import java.util.HashMap;

public class PlayerData {

    // method to save player data in an object

    static HashMap<String, String> playerData = new HashMap<>();

    public static void savePlayerData(String key, String value) {

        playerData.put(key, value);

    }
}
