import java.io.*;
import java.util.*;

//16948 데스 나이트
public class Main {

    public static int n, r1, c1, r2, c2;
    public static boolean[][] visited;
    public static int[] dx = {-2,-2,0,0,2,2};
    public static int[] dy = {-1,1,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        int result = bfs(r1,c1);
        bw.write(result+"");
        bw.flush();
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});
        visited[x][y] = true;

        int[] node;
        int cnt, nx, ny;
        while(!q.isEmpty()){
            node = q.poll();
            x = node[0];
            y = node[1];
            cnt = node[2];
            for(int i = 0; i < 6; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx == r2 && ny == c2) return cnt+1;
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }
}
