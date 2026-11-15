public class PayPal extends Zahlungsart {
    protected double berechneGesamtbetrag2(double betrag) {
        if(betrag > 0) {
            double gebuehren = betrag * 0.04 + 5.0;
            return betrag + gebuehren;
        }
        else {
            return 0.0;
        }
    }

    protected void erklaereGebuehren2(double betrag) {
        System.out.println("Gebühren für PayPal Zahlungen betragen +4% des Betrags + 5 Euro");
    }
}
