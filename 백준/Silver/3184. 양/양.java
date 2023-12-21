import java.io.*;
import java.util.*;

//3184 양
public class Main {

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static char[][] map;
    public static boolean[][] visited;
    public static int r, c, oCnt, vCnt, oResult, vResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        String temp;
        for(int i = 0; i < r; i++){
            temp = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        oResult = 0;
        vResult = 0;
        visited = new boolean[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!visited[i][j] && map[i][j] != '#'){
                    bfs(i, j);
                    if(oCnt > vCnt) oResult += oCnt;
                    else vResult += vCnt;
                }
            }
        }

        bw.write(oResult+" "+vResult);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        vCnt = 0;
        oCnt = 0;
        if(map[x][y] == 'v') vCnt++;
        else if(map[x][y] == 'o') oCnt++;

        int nx, ny;
        int[] xy;
        while(!q.isEmpty()){
            xy = q.poll();
            for(int i = 0; i < 4; i++){
                nx = xy[0] + dx[i];
                ny = xy[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '#') continue;
                if(!visited[nx][ny]){
                    if(map[nx][ny] == 'v') vCnt++;
                    else if(map[nx][ny] == 'o') oCnt++;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}