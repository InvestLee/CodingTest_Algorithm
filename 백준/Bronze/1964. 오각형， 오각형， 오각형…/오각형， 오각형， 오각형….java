import java.io.*;

//1964 오각형, 오각형, 오각형…
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[n+1];
        dp[1] = 5;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + 3*i + 1) % 45678;
        }
        bw.write(dp[n]+"");
        bw.flush();
    }
}
