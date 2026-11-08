public class App {
    public static void main(String[] args) throws Exception {
        // Aufgabe 1.3
        Smartphone smartphone1 = new Smartphone(64);
        Smartphone smartphone2 = new Smartphone(128);
        Smartphone smartphone3 = new Smartphone(256);

        ausgabe("Smartphone 1", smartphone1);
        ausgabe("Smartphone 2", smartphone2);
        ausgabe("Smartphone 3", smartphone3);

        // Aufgabe 3.2
        Zug.main();
    }

    private static void ausgabe(String name, Smartphone s) {
        System.out.println(name + " hat " + s.getSpeicherkapazitaet() + "GB und hat die Farbe: " + s.getFarbe());
    }
}
