public class Student {

    private String name;
    private int punkte;

    protected Student(String name, int punkte) {
        this.name = name;
        this.punkte = punkte;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    protected void setPunke(int punkte) {
        this.punkte = punkte;
    }

    protected int getPunkte() {
        return punkte;
    }
}