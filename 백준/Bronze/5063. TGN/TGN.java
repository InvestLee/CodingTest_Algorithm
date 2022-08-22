import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a < b - c) System.out.println("advertise");
            else if (a ==b - c) System.out.println("does not matter");
            else System.out.println("do not advertise");
        }
        sc.close();
    }
}