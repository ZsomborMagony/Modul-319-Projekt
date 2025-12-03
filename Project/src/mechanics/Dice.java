package mechanics;

import java.util.Random;

public class Dice {
    public static int d(int die) {
        Random random = new Random();
        int result;
        result = random.nextInt(1, die+1);

        return result;
    }
}
