import java.io.*;

//15989 1, 2, 3 더하기 4
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int n;
        int[][] dp;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            dp = new int[10001][4];
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
            for(int i = 4; i <= n; i++){
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }
            bw.write(dp[n][1]+dp[n][2]+dp[n][3]+"\n");
        }
        bw.flush();
    }
}