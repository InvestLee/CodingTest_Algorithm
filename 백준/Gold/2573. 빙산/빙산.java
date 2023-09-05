import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
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

//백준 2573 빙산
public class Main {

    public static int n, m;
    public static int[][] map;
    public static int[][] melt;
    public static boolean[][] visited;
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int island = 0;
        int nx, ny;
        boolean nothing;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    bfs(i,j);
                    island++;
                }
            }
        }
        while(island < 2){
            melt = new int[n][m];
            nothing = true;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 0) continue;
                    for(int k = 0; k < 4; k++){
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if(map[nx][ny] == 0){
                            melt[i][j]++;
                            nothing = false;
                        }
                    }
                }
            }
            if(nothing){
                result = 0;
                break;
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 0) continue;
                    if(map[i][j] <= melt[i][j]) map[i][j] = 0;
                    else map[i][j] -= melt[i][j];
                }
            }

            island = 0;
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j] && map[i][j] != 0){
                        bfs(i,j);
                        island++;
                    }
                }
            }
            result++;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        Node node;
        int nx, ny;
        while(!q.isEmpty()){
            node = q.poll();
            x = node.getX();
            y = node.getY();
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0) continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }
}