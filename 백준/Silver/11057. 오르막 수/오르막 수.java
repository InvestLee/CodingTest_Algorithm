import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        for (int i = 0; i < 10; i++) dp[0][i] = 1;

        for (int i = 1; i < n+1; i++){
            dp[i][9] = dp[i-1][9];
            for (int j = 8; j >= 0; j--){
                dp[i][j] = (dp[i-1][j]+dp[i][j+1]) % 10007;
            }
        }
        System.out.println(dp[n][0]);
    }
}