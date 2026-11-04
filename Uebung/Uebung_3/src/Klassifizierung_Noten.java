public class Klassifizierung_Noten {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Anna", 85);
        Student s2 = new Student("Bob", 72);
        Student s3 = new Student("Charlie", 45);
        Student s4 = new Student("Lisa", 92);

        ausgabe(1, s1);
        ausgabe(2, s2);
        ausgabe(3, s3);
        ausgabe(4, s4);
    }

    public static char klassifizieren(Student s) {
        int punkte = s.getPunkte();
        
        switch(punkte / 10) {
            case 10, 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C'; 
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }

    public static void ausgabe(int nummer, Student s) {
        System.out.printf("Student %d: %-10s -Punkteahl: %-2d, Note: %c\n", nummer, s.getName(), s.getPunkte(), klassifizieren(s));
    }
    
}
