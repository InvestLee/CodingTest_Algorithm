import java.io.*;
import java.util.*;

//2491 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp = new int[3][n+1];
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[1][1] = 1;
        dp[2][1] = 1;

        int result = 1;
        for(int i = 2; i <= n; i++){
            dp[0][i] = Integer.parseInt(st.nextToken());
            if(dp[0][i] >= dp[0][i-1]) dp[1][i] = dp[1][i-1] + 1;
            else dp[1][i] = 1;
            if(dp[0][i] <= dp[0][i-1]) dp[2][i] = dp[2][i-1] + 1;
            else dp[2][i] = 1;
            result = Math.max(result, Math.max(dp[1][i], dp[2][i]));
        }

        bw.write( result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}