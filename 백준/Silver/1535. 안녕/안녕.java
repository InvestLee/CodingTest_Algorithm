import java.io.*;
import java.util.*;

//1535 안녕
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = 99;
        int[][] dp = new int[n+1][k+1];

        int[] lostHealth = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            lostHealth[i] = Integer.parseInt(st.nextToken());
        }

        int[] getJoy = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            getJoy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(lostHealth[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j-lostHealth[i]]+getJoy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        bw.write(dp[n][k]+"");
        bw.flush();
    }
}
