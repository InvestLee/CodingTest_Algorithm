import java.io.*;
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

    public static int n, m, startX, startY;
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
        graph = new char[n][m];
        visited = new boolean[n][m];
        String temp;
        for(int i = 0; i < n; i++){
            temp = br.readLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = temp.charAt(j);
                if(graph[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = bfs(startX,startY);
        if(result == 0) bw.write("TT");
        else bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y){
        int nx, ny;
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Node currentNode = q.poll();
            x = currentNode.getX();
            y = currentNode.getY();
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(graph[nx][ny] != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                    if(graph[nx][ny] == 'P') cnt++;
                }
            }
        }
        return cnt;
    }
}
