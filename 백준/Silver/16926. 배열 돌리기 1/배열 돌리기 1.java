import java.io.*;
import java.util.*;

//백준 16926 배열 돌리기 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minRowCol = Math.min(n,m);
        int x, y, lastValue, nx, ny, dir;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(r-- > 0){
            for(int i = 0; i < minRowCol/2; i++){
                x = i;
                y = i;
                lastValue = map[i][i];
                dir = 0;
                while(dir < 4){
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                    if(nx < i || ny < i || nx >= n-i || ny >= m-i){
                        dir++;
                    } else {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }
                map[i+1][i] = lastValue;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}