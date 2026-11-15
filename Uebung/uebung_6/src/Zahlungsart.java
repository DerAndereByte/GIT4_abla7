public abstract class Zahlungsart {
    protected abstract double berechneGesamtbetrag2(double betrag);
    protected abstract void erklaereGebuehren2(double betrag);
}