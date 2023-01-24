import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

public class Main {
    public static int n;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] graph;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                result = Math.max(result,dfs(i,j));
            }
        }
        System.out.println(result);
    }

    public static int dfs(int x, int y){
        int nx, ny;
        if (dp[x][y] == -1){
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++){
                nx = x+dx[i];
                ny = y+dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (graph[nx][ny] > graph[x][y]) dp[x][y] = Math.max(dp[x][y],dfs(nx,ny));
            }
        }
        return dp[x][y] + 1;
    }
}