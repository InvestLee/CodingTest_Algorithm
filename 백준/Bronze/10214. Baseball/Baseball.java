import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int Y ;
        int K ;
        for (int i = 0; i < T; i++) {
            Y = 0;
            K = 0;
            for (int j = 0; j < 9; j++) {
                Y += sc.nextInt();
                K += sc.nextInt();
            }
            if (Y > K) System.out.println("Yonsei");
            else if (Y < K) System.out.println("Korea");
            else System.out.println("Draw");
        }
        sc.close();
    }
}