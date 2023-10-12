import java.io.*;

//백준 13301 타일 장식물
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[81];
        dp[1] = 4;
        dp[2] = 6;
        for(int i = 3; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];

        bw.write(dp[n]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}