public class Variablen_Geltungsbereich {
    private int variable1 = 10; // Instanzvariable
    private static int variable2 = 25; // Klassenvariable
    private int variable4 = 75; // Instanzvariable

    public static void main(String[] args) throws Exception {
        Variablen_Geltungsbereich v = new Variablen_Geltungsbereich();

        int variable1 = 60; // Lokale Variable
        int variable2 = 80; // Lokale Variable

        System.out.println(variable1); // Lokale Variable
        System.out.println(v.variable1); // Instanzvariable bzw. Variable vom Objekt; this funktioniert nicht, weil oben variable1 nicht als static definiert wurde

        System.out.println(variable2); // Lokale Variable
        System.out.println(Variablen_Geltungsbereich.variable2); // Klassenvariable

        // methode(2);
        v.methode2(40);

    }

    public static void methode(int variable3) { // Parameter
        int variable0 = 0; // Lokale Variable
        // Funktioniert nicht, da man keine Variable mit dem gleichen Namen wie der Parameter erstellen darf.
        // Man hat dann ein Duplikat, was nicht erlaubt ist.
        System.out.println(variable3);
    }

    public void methode2(int variable4) { // Parameter
        this.variable4 = variable4; // Lokale Variable
        System.out.println(variable4);
    }
}
