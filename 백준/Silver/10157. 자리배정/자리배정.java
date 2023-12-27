import java.io.*;
import java.util.*;

//10157 자리배정
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int k = Integer.parseInt(br.readLine());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int x = 0;
        int y = 0;
        int dir = 0;
        int nx, ny;
        if(k <= r * c){
            for(int i = 1; i < k; i++){
                map[x][y] = i;
                nx = x + dx[dir];
                ny = y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] != 0){
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            x++;
            y++;
            bw.write(y+" "+x);
        } else {
            bw.write("0");
        }



        bw.flush();
        bw.close();
        br.close();
    }
}