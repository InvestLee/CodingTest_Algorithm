import java.io.*;
import java.util.*;

//16395 파스칼의 삼각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        bw.write(dp[n][k]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}