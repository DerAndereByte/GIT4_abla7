public class App {
    public static void main(String[] args) throws Exception {
        // Aufgabe 2
        Zahlungsabwicklung.erklaereGebuehren("PayPal", 10.0);
        Zahlungsabwicklung.erklaereGebuehren("Kreditkarte", 100.0);
        Zahlungsabwicklung.erklaereGebuehren("Gutscheine", 20.0);
        
        // Aufgabe 1
        System.out.printf("Gesamtbetrag: %.2f Euro\n", Zahlungsabwicklung.berechneGesamtbetrag("PayPal", 10.0));
        System.out.printf("Gesamtbetrag: %.2f Euro\n", Zahlungsabwicklung.berechneGesamtbetrag("Kreditkarte", 100.0));
        System.out.printf("Gesamtbetrag: %.2f Euro\n", Zahlungsabwicklung.berechneGesamtbetrag("Gutscheine", 20.0));
    }
    
}
