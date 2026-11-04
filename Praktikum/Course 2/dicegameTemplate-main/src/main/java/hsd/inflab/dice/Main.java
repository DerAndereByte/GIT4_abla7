package hsd.inflab.dice;

import hsd.inflab.dice.framework.Shaker;
import hsd.inflab.dice.ui.DiceGameApp;
import javafx.application.Application;

/*
 *
 * DIESE KLASSE NICHT VERÄNDERN!
 *
 */

public class Main {
    public static void main(String[] args) {
        Shaker shaker = new Shaker();
        DiceGameApp.setShaker(shaker);
        Application.launch(DiceGameApp.class, args);
    }
}
