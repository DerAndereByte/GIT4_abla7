public class Bankueberweisung extends Zahlungsart {
    protected double berechneGesamtbetrag2(double betrag) {
        return betrag;
    }

    protected void erklaereGebuehren2(double betrag) {
        System.out.println("Banküberweisungen sind frei von Gebühren");
    }
}