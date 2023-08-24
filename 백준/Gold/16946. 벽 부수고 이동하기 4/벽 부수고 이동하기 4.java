import java.io.*;
import java.util.*;

//백준 16946 벽 부수고 이동하기 4
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

    public static int n, m, areaNum, cnt;
    public static int[][] graph, result;
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        result = new int[n][m];

        String temp;
        for(int i = 0; i < n; i++){
            temp = br.readLine();;
            for(int j = 0; j < m; j++){
                graph[i][j] = temp.charAt(j) - '0';
            }
        }

        areaNum = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 0){
                    bfs(i,j);
                    hashMap.put(areaNum, cnt);
                    areaNum--;
                }
            }
        }

        int nx, ny;
        HashSet<Integer> hashSet;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 1){
                    hashSet = new HashSet<>();
                    result[i][j] = 1;
                    for(int k = 0; k < 4; k++){
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if(nx < 0 || ny <0 || nx >= n || ny >= m || hashSet.contains(graph[nx][ny])) continue;
                        result[i][j] += hashMap.get(graph[nx][ny]);
                        hashSet.add(graph[nx][ny]);
                    }
                    result[i][j] %= 10;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(result[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        cnt = 1;
        graph[x][y] = areaNum;

        Node node;
        int nx, ny;
        while(!q.isEmpty()){
            node = q.poll();

            for(int i = 0; i < 4; i++){
                nx = node.getX() + dx[i];
                ny = node.getY() + dy[i];

                if(nx < 0 || ny <0 || nx >= n || ny >= m) continue;
                if(graph[nx][ny] == 0){
                    graph[nx][ny] = areaNum;
                    q.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }
    }
}