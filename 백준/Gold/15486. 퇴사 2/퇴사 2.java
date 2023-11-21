import java.io.*;
import java.util.*;

//백준 15486 퇴사 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n+2][2];
        int[] dp = new int[n+2];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int next;
        for(int i = 1; i <= n+1; i++){
            if(max < dp[i]) max = dp[i];
            next = i + arr[i][0];
            if(next < n + 2) dp[next] = Math.max(dp[next], max+arr[i][1]);
        }

        bw.write(dp[n+1]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}