import java.io.*;
import java.util.*;

//백준 16194 카드 구매하기2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            p[i] = Integer.parseInt(st.nextToken());
            dp[i] = p[i];
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i],dp[i-j]+p[j]);
            }
        }

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
