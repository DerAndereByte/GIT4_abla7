public class ggT_Algorithmus {

    public static void main(String args[]) {
        System.out.println(ggT(10, 5));
    }

    private static int ggT(int a, int b) {
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
}