import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int result = 0;
        for(int i=0; i < T; i++){
            int n = sc.nextInt();
            result += n;
        }
        sc.close();
        if (T/2 < result) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}