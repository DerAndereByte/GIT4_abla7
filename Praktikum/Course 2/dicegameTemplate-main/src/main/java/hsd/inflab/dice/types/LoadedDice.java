package hsd.inflab.dice.types;

public class LoadedDice extends Dice {
    private int sides = 6;
    
    public LoadedDice() {
        
    }

    public int roll() {
        int number = getRandomNumber(1, 10);
        if(number > 5) {
            return 6;
        }
        else {
            return number;
        } 
    }

    public int getSides() {
        return sides;
    }
}
