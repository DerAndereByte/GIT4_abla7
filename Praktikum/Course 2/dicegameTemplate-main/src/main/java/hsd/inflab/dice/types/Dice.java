package hsd.inflab.dice.types;

import java.util.Random;

/*
 *
 * DIESE KLASSE NICHT VERÄNDERN!
 *
 */

public abstract class Dice {
    private Random random = new Random();

    protected int getRandomNumber(int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public abstract int roll();

    public abstract int getSides();

    public String getName() {
        return getClass().getSimpleName();
    }

}
