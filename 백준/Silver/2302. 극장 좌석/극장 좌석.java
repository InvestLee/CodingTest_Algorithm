import java.io.*;

//백준 2302 극장 좌석
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];

        int result = 1;
        int before = 0;
        int fixedSit;
        for(int i = 0; i < m; i++){
            fixedSit = Integer.parseInt(br.readLine());
            result *= dp[fixedSit - before - 1];
            before = fixedSit;
        }
        result *= dp[n - before];

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}