import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int r,c,n;
    public static char[][] graph;
    public static Queue<int[]> q = new LinkedList<>();
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        for (int i = 0; i < r; i++){
            String charLine = br.readLine();
            for (int j = 0; j < c; j++) graph[i][j] = charLine.charAt(j);
        }

        for (int i = 2; i <= n; i++){
            if (i % 2 == 1){
                for (int j = 0; j < r; j++){
                    for (int k = 0; k < c; k++){
                        if (graph[j][k] == 'O') q.add(new int[] {j, k});
                    }
                }
                for (char[] g: graph) Arrays.fill(g, 'O');
                bfs();
            }
        }
        if (n % 2 == 0){
            for (char g[]:graph) Arrays.fill(g, 'O');
        }
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) System.out.print(graph[i][j]);
            System.out.println();
        }
    }

    public static void bfs(){
        int[] bomb;
        int x, y, nx, ny;
        while (!q.isEmpty()){
            bomb = q.poll();
            x = bomb[0];
            y = bomb[1];
            graph[x][y] = '.';
            for (int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (graph[nx][ny] == 'O') graph[nx][ny] = '.';
            }
        }
    }
}