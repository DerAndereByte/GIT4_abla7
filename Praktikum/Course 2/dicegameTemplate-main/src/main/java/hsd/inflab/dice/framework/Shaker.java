package hsd.inflab.dice.framework;

import hsd.inflab.dice.types.Dice;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * DIESE KLASSE NICHT VERÄNDERN!
 *
 */

public class Shaker {
    private final List<Dice> cup = new ArrayList<>();

    public List<Dice> getDices() {
        return new ArrayList<>(cup);
    }

    public void addDice(Dice dice) {
        cup.add(dice);
    }

    public void clear() {
        cup.clear();
    }

    public List<DiceResult> throwDice() {
        List<DiceResult> result = new ArrayList<>();
        for (Dice dice : cup) {
            int diceFace = dice.roll();
            DiceResult singleResult = new DiceResult(dice, diceFace);
            result.add(singleResult);
        }
        return result;
    }

    public boolean isEmpty(){
        return cup.isEmpty();
    }
}
