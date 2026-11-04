package hsd.inflab.dice.types;

public class RegularDice extends Dice {
    private int sides = 6;
    
    public RegularDice() {

    }

    public int roll() {
        return getRandomNumber(1, sides);
    }

    public int getSides() {
        return sides;
    }
}
