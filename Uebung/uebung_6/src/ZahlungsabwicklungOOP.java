public class ZahlungsabwicklungOOP {
    public static void main(String[] args) throws Exception {
        Zahlungsart PayPal = new PayPal();
        Zahlungsart Kreditkarte = new Kreditkarte();
        Zahlungsart Bankueberweisung = new Bankueberweisung();
        Zahlungsart[] zahlungsarten = {PayPal, Kreditkarte, Bankueberweisung}; 
    
        for (Zahlungsart zahlungsart : zahlungsarten) {
            zahlungsart.erklaereGebuehren2(100.0);
            System.out.printf("Gesamtbetrag: %.2f Euro\n", zahlungsart.berechneGesamtbetrag2(100.0));
        }
    }
}