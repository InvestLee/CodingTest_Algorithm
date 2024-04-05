import java.io.*;
import java.util.*;

//17086 아기 상어 2
public class Main {

    public static int n, m;
    public static int[][] map;
    public static int[] dx = {-1,1,0,0,1,1,-1,-1};
    public static int[] dy = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] node;
        int nx, ny, x, y, result = 0;
        while(!q.isEmpty()){
            node = q.poll();
            x = node[0];
            y = node[1];
            for(int i = 0; i < 8; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0){
                    q.offer(new int[]{nx,ny});
                    map[nx][ny] = map[x][y] + 1;
                    result = map[nx][ny];
                }
            }
        }

        bw.write(result-1+"");
        bw.flush();
    }
}
