public class App {
    public static void main(String[] args) throws Exception {
        // Aufgabe 1
        Person p1 = new Person("Malte", 24);
        Person p2 = new Person("Lea", 21);

        p1.printDetails();
        p2.printDetails();

        // Aufgabe 2
        BankAccount k1 = new BankAccount(2000.00);
        System.out.println("Kontostand: " + k1.getKontostand());
        k1.einzahlen(400);
        System.out.println("Kontostand: " + k1.getKontostand());
        k1.abheben(505.50);
        System.out.println("Kontostand: " + k1.getKontostand());

        // Aufgabe 3
        System.out.println(isPalindromRekursiv("Otto"));
        System.out.println(isPalindromRekursiv("Malte"));
        System.out.println(isPalindromRekursiv("   LAgErrEGal "));
    }

    public static boolean isPalindromRekursiv(String text) {
        // Entfernen von Leerzeichen und
        // Umwandeln in Kleinbuchstaben
        // z.B., aus "    Otto   " wird "otto"
        text = text.replaceAll("\\s", "").toLowerCase();
        
        if(text.length() <= 1) { // gar kein input und einzelne buchstaben sind palindrome
            return true;
        }
            
        if(text.regionMatches(0, text, text.length() - 1, 1)) { // vergleicht erste und letzte stelle; Str1StartIndex, Str2, Str2StartIndex, Anzahl Zeichen
            text = text.substring(1, text.length() - 1); // erste und letzte stelle wird entfernt;
            return isPalindromRekursiv(text);
        }
        
        return false;
    }
}
    

