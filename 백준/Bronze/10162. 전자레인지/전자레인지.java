import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = T / 300;
        T -= A*300;
        int B = T / 60;
        T -= B*60;
        int C = T / 10;
        T -= C*10;
        if (T != 0) System.out.println(-1);
        else System.out.printf("%d %d %d",A,B,C);
        sc.close();
    }
}