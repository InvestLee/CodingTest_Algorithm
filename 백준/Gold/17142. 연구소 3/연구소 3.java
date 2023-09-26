import java.io.*;
import java.util.*;

class Virus{
    int x;
    int y;
    int dist;

    public Virus(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

//백준 17142 연구소 3
public class Main {

    public static int dx[] = {0,-1,0,1};
    public static int dy[] = {-1,0,1,0};
    public static int map[][];
    public static int n, m, OriginEmpty, result;
    public static ArrayList<Virus> virusArrays = new ArrayList<>();
    public static Virus[] active;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        active = new Virus[m];
        OriginEmpty = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) OriginEmpty++;
                else if(map[i][j] == 2) virusArrays.add(new Virus(i, j, 0));
            }
        }

        result = Integer.MAX_VALUE;
        if(OriginEmpty == 0) bw.write("0");
        else{
            selectVirus(0,0);
            if(result == Integer.MAX_VALUE) bw.write("-1");
            else bw.write(result+"");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void selectVirus(int start, int cnt){
        if(cnt == m){
            bfs(OriginEmpty);
            return;
        }
        for(int i = start; i < virusArrays.size(); i++){
            active[cnt] = virusArrays.get(i);
            selectVirus(i+1, cnt+1);
        }
    }

    public static void bfs(int empty){
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        Virus virus;
        for(int i = 0; i < m; i++){
            virus = active[i];
            visited[virus.x][virus.y] = true;
            q.add(virus);
        }

        int nx, ny;
        while(!q.isEmpty()){
            virus = q.poll();
            for(int i = 0; i < 4; i++){
                nx = virus.x + dx[i];
                ny = virus.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;
                if(map[nx][ny] == 0) empty--;
                if(empty == 0){
                    result = Math.min(result, virus.dist + 1);
                    return;
                }
                visited[nx][ny] = true;
                q.add(new Virus(nx, ny, virus.dist + 1));
            }
        }
    }
}