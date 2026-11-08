public class Zug extends Transportmittel {
    public static void main() throws Exception {
        // Aufgabe 3.2a
        Zug meinZug = new Zug();
        meinZug.durchfuehrenWartung();
        meinZug.meldenVerspaetung();

        Transportmittel meinTransport = new Transportmittel();
        meinTransport.durchfuehrenWartung();
        meinTransport.meldenVerspaetung();
    }

    // Aufgabe 3.1
    private void meldenVerspaetung() {
        System.out.println("Wir bitten die Verspätung zu entschuldigen.");
    }
}
