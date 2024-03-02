import java.io.*;
import java.util.*;

//1388 바닥 장식
public class Main {

    public static int n, m;
    public static char[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        String str;
        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j]) continue;
                if(map[i][j] == '-') dfs(i, j, true);
                else dfs(i, j, false);
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, boolean rowOrCol){
        visited[x][y] = true;
        if(rowOrCol){
            y++;
            if(y < m && map[x][y] == '-') dfs(x,y,true);
        } else {
            x++;
            if(x < n && map[x][y] != '-') dfs(x,y,false);
        }
    }
}