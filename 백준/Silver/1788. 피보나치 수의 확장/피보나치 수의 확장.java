import java.io.*;
import java.util.*;

//1788 피보나치 수의 확장
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1000000;
        long[] dp = new long[2000001];
        dp[1000001] = 1;
        if(n < 1000000){
            for(int i = 999999; i >= n; i--){
                dp[i] = (dp[i+2] - dp[i+1]) % 1000000000;
            }
        } else {
            for (int i = 1000002; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
            }
        }
        if (dp[n] > 0) bw.write("1\n");
        if (dp[n] == 0) bw.write("0\n");
        if (dp[n] < 0) bw.write("-1\n");
        bw.write(Math.abs(dp[n])+"");
        bw.flush();
    }
}
