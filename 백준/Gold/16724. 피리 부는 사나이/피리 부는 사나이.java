import java.io.*;
import java.util.*;

//백준 16724 피리 부는 사나이
public class Main {

    public static int n, m, result;
    public static int[][] graph;
    public static boolean[][] visited;
    public static boolean[][] isCycle;
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        isCycle = new boolean[n][m];

        String tempStr;
        char tempChar;
        for(int i = 0; i < n; i++){
            tempStr = br.readLine();
            for(int j = 0; j < m; j++){
                tempChar = tempStr.charAt(j);
                if(tempChar == 'U') graph[i][j] = 0;
                else if(tempChar == 'D') graph[i][j] = 1;
                else if(tempChar == 'L') graph[i][j] = 2;
                else if(tempChar == 'R') graph[i][j] = 3;
            }
        }

        result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        int nx = x + dx[graph[x][y]];
        int ny = y + dy[graph[x][y]];

        if(!visited[nx][ny]){
            dfs(nx,ny);
        } else if(!isCycle[nx][ny]){
            result++;
        }
        isCycle[x][y] = true;
    }
}