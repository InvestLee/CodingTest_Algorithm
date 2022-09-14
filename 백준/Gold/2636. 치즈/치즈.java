import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    private int Node_x;
    private int Node_y;

    public Node(int Node_x,int Node_y){
        this.Node_x = Node_x;
        this.Node_y = Node_y;
    }

    public int getNode_x(){
        return this.Node_x;
    }

    public int getNode_y(){
        return this.Node_y;
    }
}

public class Main {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int N;
    public static int M;
    public static int[][] graph;
    public static boolean[][] visited;

    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        int cnt = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.getNode_x();
            y = node.getNode_y();
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                //외부 공기일경우 다음 영역으로 이동, 공기와 접촉된 치즈일 경우 녹이고 녹은 치즈 갯수 연산
                if (graph[nx][ny] == 0 && !visited[nx][ny]){
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                } else if (graph[nx][ny] == 1 && !visited[nx][ny]){
                    graph[nx][ny] = 0;
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int time_cnt = 0;
        int before_cheese = -1; //1시간 전 녹은 치즈 갯수 연산
        int current_cheese; //현재 시점에서 녹은 치즈 갯수 연산
        while (true){
            current_cheese = bfs(0,0);
            if (current_cheese == 0) break; //녹은 치즈가 없으면 모두 녹았으므로 루프 종료
            before_cheese = current_cheese;
            time_cnt++;
            visited = new boolean[N][M];
        }
        System.out.println(time_cnt);
        System.out.println(before_cheese);
    }
}