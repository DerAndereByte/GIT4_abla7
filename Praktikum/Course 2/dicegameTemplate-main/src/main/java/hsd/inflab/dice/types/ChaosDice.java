package hsd.inflab.dice.types;

public class ChaosDice extends Dice {
    private int sides;
    
    public ChaosDice(int sides) {
        if(sides < 4) {
            this.sides = 4;    
        }
        else if(sides > 20) {
            this.sides = 20;
        }
        else {
            this.sides = sides;
        }
    }

    public int roll() {
        int number = getRandomNumber(1, sides);
        this.sides = getRandomNumber(4, 20); 
        return number;
    }

    public int getSides() {
        return sides;
    }
}
