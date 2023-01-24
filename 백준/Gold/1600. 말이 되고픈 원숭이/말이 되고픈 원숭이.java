import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node{
    private int x;
    private int y;
    private int k;
    private int cnt;

    public Node(int x, int y, int k, int cnt){
        this.x = x;
        this.y = y;
        this.k = k;
        this.cnt = cnt;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getK(){
        return this.k;
    }

    public int getCnt(){
        return this.cnt;
    }
}

public class Main {
    public static int k, w, h;
    public static int[] dx = {-1,1,0,0,2,2,-2,-2,1,1,-1,-1};
    public static int[] dy = {0,0,-1,1,1,-1,1,-1,2,-2,2,-2};
    public static int[][] graph;
    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[h][w];
        for (int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[h][w][k+1];
        bfs();
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0, k, 0));
        visited[0][0][k] = true;
        int isHorse, x, y, remainK, currentCnt, nx, ny;
        while (!q.isEmpty()){
            Node nowNode = q.poll();
            x = nowNode.getX();
            y = nowNode.getY();
            remainK = nowNode.getK();
            currentCnt = nowNode.getCnt();
            if (x == h-1 && y == w-1){
                System.out.println(currentCnt);
                return;
            }
            if (remainK > 0) isHorse = 12;
            else isHorse = 4;
            for (int i = 0; i < isHorse; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (i >= 4 && !visited[nx][ny][remainK-1] && graph[nx][ny] == 0){
                    q.offer(new Node(nx,ny,remainK-1,currentCnt+1));
                    visited[nx][ny][remainK-1] = true;
                }
                else if (i < 4 && !visited[nx][ny][remainK] && graph[nx][ny] == 0){
                    q.offer(new Node(nx,ny,remainK,currentCnt+1));
                    visited[nx][ny][remainK] = true;
                }
            }
        }
        System.out.println(-1);
        return;
    }
}