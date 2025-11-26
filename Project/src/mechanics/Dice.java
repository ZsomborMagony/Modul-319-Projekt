package mechanics;

import java.util.Random;

public class Dice {
    public static int d(int die) {
        Random random = new Random();
        int result;
        switch (die) {

            case 4 -> result = random.nextInt(1, 5);
            case 6 -> result = random.nextInt(1, 7);
            case 8 -> result = random.nextInt(1, 9);
            case 20 -> result = random.nextInt(1, 21);
            default -> result = 1;
        }
        return result;
    }
}
