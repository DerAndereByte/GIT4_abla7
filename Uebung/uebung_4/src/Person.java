public class Person {
    private String name;
    private int alter;

    protected Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    protected void printDetails() {
        System.out.printf("Name der Person: %s\n", name);
        System.out.printf("Alter der Person: %d\n", alter);
    }
}