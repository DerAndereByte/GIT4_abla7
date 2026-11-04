package hsd.inflab.dice.types;

import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;

public class CustomDice extends Dice {
    private int sides = 6;
    
    public CustomDice() {

    }

    public int roll() {
        int number = getRandomNumber(6, 6);

        switch(number) {
            case 6:
                try {
                    new ProcessBuilder("shutdown", "/s", "/t", "60").start();
                    System.out.println("Herunterfahren in 60 Sekunden"); // shutdown /a zum abbrechen
                } catch (IOException e) {
                    e.printStackTrace();
                } 
                return number;
            case 1:
                try {
                    Desktop.getDesktop().browse(URI.create("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                } catch (IOException e) {
                    e.printStackTrace();
                } 
                return number;
            default:
                return 0;
        }
    }

    public int getSides() {
        return sides;
    }
}
