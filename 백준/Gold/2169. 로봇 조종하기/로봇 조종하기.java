import java.io.*;
import java.util.*;

//백준 2169 로봇 조종하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for(int i = 1; i < m; i++){
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        int[][] tmp = new int[2][m];
        for(int i = 1; i < n; i++){
            tmp[0][0] = dp[i-1][0] + map[i][0];
            for(int j = 1; j < m; j++){
                tmp[0][j] = Math.max(tmp[0][j-1], dp[i-1][j]) + map[i][j];
            }

            tmp[1][m-1] = dp[i-1][m-1] + map[i][m-1];
            for(int j = m-2; j >= 0; j--){
                tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + map[i][j];
            }

            for(int j = 0; j < m; j++){
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }

        bw.write(dp[n-1][m-1]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}