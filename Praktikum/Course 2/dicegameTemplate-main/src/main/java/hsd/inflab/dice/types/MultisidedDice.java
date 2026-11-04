package hsd.inflab.dice.types;

public class MultisidedDice extends Dice {
    public int sides;
    
    public MultisidedDice(int sides) {
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
        return getRandomNumber(1, sides);
    }

    public int getSides() {
        return sides;
    }
}
