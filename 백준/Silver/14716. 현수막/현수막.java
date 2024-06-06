import java.io.*;
import java.util.*;

//14716 현수막
public class Main {

    public static int n, m, result;
    public static int[] dx = {-1,1,0,0,1,1,-1,-1};
    public static int[] dy = {0,0,-1,1,1,-1,1,-1};
    public static int[][] graph;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph  = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    result++;
                    bfs(i,j);
                }
            }
        }

        bw.write(result+"");
        bw.flush();
    }

    public static void bfs(int x, int y){
        int nx, ny;
        int[] now;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            now = q.poll();
            x = now[0];
            y = now[1];
            for(int i = 0; i < 8; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && graph[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}