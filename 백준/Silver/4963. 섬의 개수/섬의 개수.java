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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int[] dx = {-1,1,0,0,-1,-1,1,1};
    public static int[] dy = {0,0,-1,1,-1,1,-1,1};
    public static int w;
    public static int h;
    public static int[][] graph;
    public static boolean[][] visited;

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (graph[nx][ny] == 1 && !visited[nx][ny]){
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            graph = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (graph[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}