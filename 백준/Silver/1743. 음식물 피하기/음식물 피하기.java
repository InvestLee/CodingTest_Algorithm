import java.io.*;
import java.util.*;

class Node {
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

    public static int n;
    public static int m;
    public static int k;
    public static int[][] graph;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        int x, y;
        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x-1][y-1] = 1;
        }

        int garbageSize;
        int result = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    garbageSize = bfs(i,j);
                    if(result < garbageSize) result = garbageSize;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y){
        int count = 1;
        int nx, ny;
        Node node;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            node = q.poll();
            x = node.getX();
            y = node.getY();
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && graph[nx][ny] == 1){
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
