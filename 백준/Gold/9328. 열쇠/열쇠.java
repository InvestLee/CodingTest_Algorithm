import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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

public class Main {

    public static char[][] graph;
    public static boolean[][] visited;
    public static boolean[] key;
    public static ArrayList<Node>[] locks;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int h, w, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new char[h+2][w+2];
            visited = new boolean[h+2][w+2];
            key = new boolean[26];
            locks = new ArrayList[26];
            cnt = 0;

            for(int i = 0; i < 26; i++) locks[i] = new ArrayList<>();
            for(int i = 0; i < h+2; i++){
                for(int j = 0; j < w+2; j++) graph[i][j] = '.';
            }
            for(int i = 1; i <= h; i++){
                String inputLine = br.readLine();
                for(int j = 1; j <= w; j++) graph[i][j] = inputLine.charAt(j-1);
            }
            String inputKey = br.readLine();
            if (!inputKey.equals("0")) {
                for (int i = 0; i < inputKey.length(); i++){
                    key[inputKey.charAt(i) - 'a'] = true;
                }
            }
            bfs();
            System.out.println(cnt);
        }
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = node.getX()+dx[i];
                int ny = node.getY()+dy[i];
                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                if (graph[nx][ny] == '*' || visited[nx][ny]) continue;
                int room = graph[nx][ny];
                if (room - 'A' >= 0 && room - 'A' <= 25){
                    if (key[room - 'A']){
                        graph[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    } else {
                        locks[room - 'A'].add(new Node(nx, ny));
                    }
                } else if (room - 'a' >= 0 && room - 'a' <= 25){
                    key[room - 'a'] = true;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    for (int j = 0; j <= 25; j++){
                        if (locks[j].size() != 0 && key[j]){
                            for (int k = 0; k < locks[j].size(); k++){
                                Node unlock = locks[j].get(k);
                                graph[unlock.getX()][unlock.getY()] = '.';
                                visited[unlock.getX()][unlock.getY()] = true;
                                q.add(new Node(unlock.getX(),unlock.getY()));
                            }
                        }
                    }
                } else if (room == '$') {
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                } else {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }
}
