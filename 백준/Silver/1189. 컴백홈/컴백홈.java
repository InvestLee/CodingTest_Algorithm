import java.io.*;
import java.util.*;

//1189 컴백홈
public class Main {

    public static int r, c, k, result = 0;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[r][c];

        String temp;
        for(int i = 0; i < r; i++){
            temp = br.readLine();
            for(int j = 0; j < c; j++){
                if(temp.charAt(j) == 'T') visited[i][j] = true;
            }
        }

        visited[r-1][0] = true;
        dfs(r-1,0,1);

        bw.write(result+"");
        bw.flush();
    }

    public static void dfs(int x, int y, int depth){
        if(x == 0 && y == c-1){
            if(depth == k) result++;
            return;
        }

        int nx, ny;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, depth+1);
                visited[nx][ny] = false;
            }
        }
    }
}
