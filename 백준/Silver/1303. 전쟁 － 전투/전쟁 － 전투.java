import java.io.*;
import java.util.*;

//1303 전쟁 - 전투
public class Main {

    public static int n, m;
    public static char[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[m][n];
        visited = new boolean[m][n];
        String temp;
        for(int i = 0; i < m; i++){
            temp = br.readLine();
            for(int j = 0; j < n; j++){
                graph[i][j] = temp.charAt(j);
            }
        }

        int wResult = 0;
        int bResult = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    if(graph[i][j] == 'W') wResult += bfs(i, j);
                    else bResult += bfs(i,j);
                }
            }
        }
        bw.write(wResult+" "+bResult);
        bw.flush();
    }

    public static int bfs(int x, int y){
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        int[] cur;
        int nx, ny;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int i = 0; i < 4; i++){
                nx = cur[0] + dx[i];
                ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(!visited[nx][ny] && graph[nx][ny] == graph[x][y]){
                    cnt++;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        return cnt * cnt;
    }
}
