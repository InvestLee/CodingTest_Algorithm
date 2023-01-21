import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        int[][] dp = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int len = 1; len < n; len++){
            for (int start = 0; start < n - len; start++){
                for (int k = start; k < start+len; k++){
                    int matSize = dp[start][k] + dp[k+1][start+len]+matrix[start][0]*matrix[k][1]*matrix[start+len][1];
                    dp[start][start+len] = Math.min(dp[start][start+len], matSize);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}