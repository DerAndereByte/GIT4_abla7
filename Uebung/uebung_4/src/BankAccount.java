public class BankAccount {
    private double kontostand;

    protected BankAccount(double kontostand) {
        this.kontostand = kontostand;
    }

    protected double getKontostand() {
        return this.kontostand;
    }

    protected void einzahlen(double betrag) {
        this.kontostand += betrag;
    }

    protected void abheben(double betrag) {
        this.kontostand -= betrag;
    }
}