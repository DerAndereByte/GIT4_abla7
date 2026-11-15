public class Zahlungsabwicklung {
    protected static double berechneGesamtbetrag(String zahlungsart, double betrag) {
        if(zahlungsart.equals("PayPal") || zahlungsart.equals("Kreditkarte")) {
            double gebuehren;
            if(zahlungsart.equals("PayPal")) {
                gebuehren = betrag * 0.04 + 5.0;  
            }
            else {
                if(betrag < 100.0) {
                    gebuehren = betrag * 0.05;
                }
                else {
                    gebuehren = betrag * 0.02 + 8;
                }
            }
            return betrag + gebuehren;
        }
        else {
            System.out.println("Ungueltige Zahlungsart! Nur PayPal und Kreditkarte verfügbar.");
            return 0;
        }
    }

    protected static void erklaereGebuehren(String zahlungsart, double betrag) {
        if(zahlungsart.equals("PayPal") || zahlungsart.equals("Kreditkarte")) {
            if(zahlungsart.equals("PayPal")) {
                    System.out.println("Gebühren für PayPal Zahlungen betragen +4% des Betrags + 5 Euro");
                }
                else {
                    if(betrag < 100.0) {
                        System.out.println("Gebühren für Kreditkarten Zahlungen ab 100 Euro betragen +2% des Betrags + 8 Euro");
                    }
                    else {
                        System.out.println("Gebühren für Kreditkarten Zahlungen unter 100 Euro betragen +5% des Betrags");
                    }
                }
            }
            else {
                System.out.println("Ungueltige Zahlungsart! Nur PayPal und Kreditkarte verfügbar.");
            }
        }
    } 


