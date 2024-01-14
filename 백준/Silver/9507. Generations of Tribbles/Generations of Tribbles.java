import java.io.*;

//9507 Generations of Tribbles
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[68];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 68; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
        }

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            bw.write(dp[Integer.parseInt(br.readLine())]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}