import java.io.*;
import java.util.*;

//백준 16958 텔레포트
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] city = new int[n+1][3];
        int[][] dist = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[][] aToB = new int[m][2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            aToB[i][0] = Integer.parseInt(st.nextToken());
            aToB[i][1] = Integer.parseInt(st.nextToken());
        }

        int nowDist;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                nowDist = Math.abs(city[i][1]-city[j][1]) + Math.abs(city[i][2]-city[j][2]);
                if(city[i][0] == 1 && city[j][0] == 1){
                    if(nowDist > t) nowDist = t;
                }
                dist[i][j] = nowDist;
                dist[j][i] = nowDist;
            }
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(j==k) continue;
                    if(dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        for(int[] ab : aToB){
            bw.write(dist[ab[0]][ab[1]]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
