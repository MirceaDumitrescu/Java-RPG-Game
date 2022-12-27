import generators.Directions;
import utils.Utils;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    private static final ArrayList<String> map = Directions.generateMap(random.nextInt(100));

    public static void main(String[] args) {
        Utils.welcomeTitle();
        Utils.loadingBar();
        Directions.chooseDirection(map);
    }

}

