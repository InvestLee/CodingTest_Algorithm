import java.io.*;
import java.util.*;

//백준 1256 사전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[][] dp = new long[202][202];
        for(int i = 0; i<= 200; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 1; i <= 200; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                if(dp[i][j] > 1000000000) dp[i][j] = 1000000001;
            }
        }

        if(dp[m+n][m] < k){
            bw.write("-1");
        } else{
            while(!(n == 0 && m == 0)){
                if(dp[m+n-1][m] >= k){
                    bw.append("a");
                    n--;
                } else {
                    bw.append("z");
                    k = k - dp[m+n-1][m];
                    m--;
                }
            }
        }

        bw.write("");
        bw.flush();
        br.close();
        bw.close();
    }
}