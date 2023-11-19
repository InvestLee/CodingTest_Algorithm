import java.io.*;

//백준 15990 1, 2, 3 더하기 5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100_001][4];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 1
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3
        for(int i = 4; i <= 100_000; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
        }

        int n;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            bw.write((dp[n][1] + dp[n][2] + dp[n][3]) % 1_000_000_009 + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}