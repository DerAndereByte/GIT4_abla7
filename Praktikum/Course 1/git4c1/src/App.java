import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while(menu(sc)) {
        }
    }

    // Einfache Operationen
    public static double add(double summand1, double summand2) {
        return summand1 + summand2;
    }

    public static double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    public static double multiply(double multiplier, double multiplicant) {
        return multiplier * multiplicant;
    }

    public static double divide(double dividend, double divisor) {
        return dividend / divisor;
    }

    // komplexere Operationen
    public static double sin(double x) {
        return Math.sin(Math.toRadians(x)); 
    }

    public static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    public static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        else if(b == 0) {
            return a;
        }
        else {
            do {
                int h = a % b;
                a = b;
                b = h;
            }while(b != 0);
        
            return a;
        }
    }

    public static long fibonacci(int n) {
        
        long f_n, f_1, f_2;
        f_n = 0;
        f_1 = f_2 = 1;

        if(n == 0) {
            return 0;
        }

        if(n <= 2) {
            return 1;
        }

        while(n > 2) {
            f_n = f_1 + f_2;
            f_2 = f_1;
            f_1 = f_n;
            n--; 
        }
        
        return f_n; 
    }

    // Menu
    public static boolean menu(Scanner sc) {
        System.out.println("CALCULATOR - please select:");
        System.out.println("0: end program");
        System.out.println("1: add(x,y)");
        System.out.println("2: subtract(x,y)");
        System.out.println("3: multiply(x,y)");
        System.out.println("4: divide(x,y)");
        System.out.println("5: sin(x)");
        System.out.println("6: pow(x,y)");
        System.out.println("7: gcd(x,y)");
        System.out.println("8: fibonacci(n)");
 
        int userinput = sc.nextInt();
        double number1, number2;

        switch (userinput) {
            case 0:
                return false;

            case 1:
                System.out.println("Please choose two numbers:");
                System.out.print("Number1: ");
                number1 = sc.nextDouble();
                System.out.print("Number2: ");
                number2 = sc.nextDouble();
                System.out.println(number1 + " + " + number2 + " = " + add(number1, number2));
                return true;
            
            case 2:
                System.out.println("Please choose two numbers:");
                System.out.print("Number1: ");
                number1 = sc.nextDouble();
                System.out.print("Number2: ");
                number2 = sc.nextDouble();
                System.out.println(number1 + " - " + number2 + " = " + subtract(number1, number2));
                return true;
            
            case 3:
                System.out.println("Please choose two numbers:");
                System.out.print("Number1: ");
                number1 = sc.nextDouble();
                System.out.print("Number2: ");
                number2 = sc.nextDouble();
                System.out.println(number1 + " * " + number2 + " = " + multiply(number1, number2));
                return true;

            case 4:
                System.out.println("Please choose two numbers:");
                System.out.print("Number1: ");
                number1 = sc.nextDouble();
                System.out.print("Number2: ");
                number2 = sc.nextDouble();
                System.out.println(number1 + " / " + number2 + " = " + divide(number1, number2));
                return true;
                
            case 5:
                System.out.println("Please choose a angle:");
                System.out.print("Angle: ");
                number1 = sc.nextDouble();
                System.out.println("sin(" + number1 + ")" + " = " + sin(number1));
                return true;

            case 6:
                System.out.println("Please choose two numbers:");
                System.out.print("Number1: ");
                number1 = sc.nextDouble();
                System.out.print("Number2: ");
                number2 = sc.nextDouble();
                System.out.println(number1 + " ^ " + number2 + " = " + pow(number1, number2));
                return true;

            case 7:
                System.out.println("Please choose two numbers:");
                System.out.print("Number1: ");
                number1 = sc.nextDouble();
                System.out.print("Number2: ");
                number2 = sc.nextDouble();
                System.out.println("ggT von " + number1 + " und " + number2 + " ist " + gcd((int)number1, (int)number2));
                return true;

            case 8:
                System.out.println("Please choose a n for the nth-Fibonacci:");
                System.out.print("n: ");
                number1 = sc.nextDouble();
                System.out.println("Fibonacci(" + number1 + ")" + " = " + fibonacci((int)number1));
                return true;

            default:
                return false;
        }
    }
}

/*
Task 1:
v) Da wir keine Objekte der Klasse App erstellen, brauchen wir den Modifier static, um auch ohne Objekte die Methoden ausführzukönnen

Task 2:
4) javac App.java: kompiliert den Code in Maschinensprache und erstellt daraus eine neue Datei App.class
   java App: führt die Applikation aus
*/
