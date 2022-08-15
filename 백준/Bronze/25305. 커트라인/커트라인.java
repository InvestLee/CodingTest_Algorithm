import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        Integer[] score = new Integer[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(score,Collections.reverseOrder());
        System.out.println(score[k-1]);
    }
}