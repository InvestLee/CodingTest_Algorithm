import java.io.*;
import java.util.*;

//백준 17404 RGB거리 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cost[][] = new int[n+1][3];
        int dp[][] = new int[n+1][3];

        StringTokenizer st;
        for(int i = 1; i <= n; i++){
            st =  new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 10000000;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j) dp[1][j] = cost[1][j];
                else dp[1][j] = 10000000;
            }

            for(int j = 2; j <= n; j++){
                dp[j][0] = Math.min(dp[j-1][1],dp[j-1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j-1][0],dp[j-1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j-1][0],dp[j-1][1]) + cost[j][2];
            }

            for(int j = 0; j < 3; j++){
                if(i != j) result = Math.min(result,dp[n][j]);
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}