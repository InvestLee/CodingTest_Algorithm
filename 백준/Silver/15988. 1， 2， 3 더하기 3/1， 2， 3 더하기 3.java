import java.io.*;

//백준 15988 1, 2, 3 더하기 3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 1_000_001; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
        }

        int n;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}