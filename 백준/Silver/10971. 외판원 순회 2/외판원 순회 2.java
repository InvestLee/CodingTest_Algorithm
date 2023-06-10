import java.io.*;
import java.util.*;

public class Main {

    public static int n, result;
    public static int[][] w;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        result = Integer.MAX_VALUE;
        /*
        for(int i = 0; i < n; i++){
            visited[i] = true;
            dfs(1,i,i,0);
            visited[i] = false;
        } */
        visited[0] = true;
        dfs(1,0,0,0);

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int start, int now, int cost){
        if(depth == n){
            if(w[now][start] != 0){
                cost += w[now][start];
                result = Math.min(result, cost);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i] && w[now][i] > 0){
                visited[i] = true;
                dfs(depth+1,start,i,cost+w[now][i]);
                visited[i] = false;
            }
        }
    }
}
