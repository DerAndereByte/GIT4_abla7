public class Kreditkarte extends Zahlungsart {
    protected double berechneGesamtbetrag2(double betrag) {
        double gebuehren = 0.0;
        if(betrag < 100.0) {
            gebuehren = betrag * 0.05;
        }
        else {
            gebuehren = betrag * 0.02 + 8;
        }
        
        return betrag + gebuehren;
    }

    protected void erklaereGebuehren2(double betrag) {
        if(betrag < 100.0) {
            System.out.println("Gebühren für Kreditkarten Zahlungen ab 100 Euro betragen +2% des Betrags + 8 Euro");
        }
        else {
            System.out.println("Gebühren für Kreditkarten Zahlungen unter 100 Euro betragen +5% des Betrags");
        }
    }
}