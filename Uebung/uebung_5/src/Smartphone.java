public class Smartphone {
    // Aufgabe 1.1
    private int speicherkapazitaet;
    private String farbe;

    // Aufgabe 1.4
    private static int anzahlSmartphones = 0;

    // Aufgabe 1.2 & 1.4
    protected Smartphone(int speicherkapazitaet) {
        this.speicherkapazitaet = speicherkapazitaet;
        anzahlSmartphones++;
        System.out.println("Anzahl Smartphones: " + anzahlSmartphones);
    }

    protected int getSpeicherkapazitaet() {
        return this.speicherkapazitaet;
    }

    protected String getFarbe() {
        return this.farbe;
    }
}