import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[41];
        dp[1] = 1;
        dp[2] = 1;
        int n = sc.nextInt();
        int result2 = n-2;
        sc.close();
        for (int i = 3; i<=n ;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.printf("%d %d",dp[n], result2);
    }
}