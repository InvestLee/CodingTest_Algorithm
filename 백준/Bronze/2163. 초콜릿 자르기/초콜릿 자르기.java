import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        int big_num = 0;
        int small_num = 0;
        if (N > M){
            big_num = N;
            small_num = M;
        } else {
            big_num = M;
            small_num = N;
        }
        System.out.print((big_num-1)+big_num*(small_num-1));
    }
}