import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private int row;
    private int column;
    private int count;

    public Node(int row, int column, int count){
        this.row = row;
        this.column = column;
        this.count = count;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public int getCount(){
        return count;
    }
}


public class Main {
    public static int r;
    public static int c;
    public static char[][] graph;
    public static boolean[][] visited;
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        for (int i = 0; i < r; i++){
            String row = br.readLine();
            for (int j = 0; j < c; j++){
                graph[i][j] = row.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(graph[i][j] == 'L'){
                    visited = new boolean[r][c];
                    result = Math.max(result, bfs(i,j));
                }
            }
        }
        System.out.println(result);
    }

    public static int bfs(int x, int y){
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,0));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.getRow();
            y = node.getColumn();
            cnt = node.getCount();
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||nx>=r||ny<0||ny>=c) continue;
                if(graph[nx][ny] == 'L' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny,cnt+1));
                }
            }
        }
        return cnt;
    }
}