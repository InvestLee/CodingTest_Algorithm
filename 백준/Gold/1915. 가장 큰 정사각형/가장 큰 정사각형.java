import java.io.*;
import java.util.*;

//백준 1915 가장 큰 정사각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];
        int result = 0;

        String input;
        for(int i = 1; i <= n; i++){
            input = br.readLine();
            for(int j = 1; j <= m; j++){
               if(input.charAt(j - 1) == '1'){
                   dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                   result = Math.max(result, dp[i][j]);
               }
            }
        }

        bw.write(result * result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}