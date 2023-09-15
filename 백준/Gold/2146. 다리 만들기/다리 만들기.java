import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private int x;
    private int y;
    private int cnt;

    public Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }
}

//백준 2146 다리 만들기
public class Main {

    public static int n, num, result;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        num = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    landNum(i,j);
                }
            }
        }

        result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] > 1){
                    visited = new boolean[n][n];
                    bridge(i,j);
                }
            }
        }


        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void landNum(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,0));
        visited[x][y] = true;
        map[x][y] = num;
        Node cur;
        int nx, ny;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int i = 0; i < 4; i++){
                nx = cur.getX() + dx[i];
                ny = cur.getY() + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    map[nx][ny] = num;
                    q.offer(new Node(nx,ny,0));
                }
            }
        }
        num++;
    }

    public static void bridge(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,0));
        visited[x][y] = true;
        int curLandNum = map[x][y];
        Node cur;
        int nx, ny;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int i = 0; i < 4; i++){
                nx = cur.getX() + dx[i];
                ny = cur.getY() + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(!visited[nx][ny] && map[nx][ny] != curLandNum){
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0) q.offer(new Node(nx,ny,cur.getCnt()+1));
                    else result = Math.min(result, cur.getCnt());
                }
            }
        }
        num++;
    }
}