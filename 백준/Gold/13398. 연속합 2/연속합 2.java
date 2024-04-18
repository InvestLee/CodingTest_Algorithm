import java.io.*;
import java.util.*;

//13398 연속합 2
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[][] dp = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = arr[0];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        bw.write(result+"");
        bw.flush();
    }
}
