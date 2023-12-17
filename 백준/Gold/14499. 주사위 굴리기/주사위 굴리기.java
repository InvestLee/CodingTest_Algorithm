import java.io.*;
import java.util.*;

//14499 주사위 굴리기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int move, temp;
        int[] dice = new int[6];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < k; i++){
            move = Integer.parseInt(st.nextToken()) - 1;
            x += dx[move];
            y += dy[move];
            if(x < 0 || y < 0 || x >= n || y >= m){
                x -= dx[move];
                y -= dy[move];
                continue;
            }

            if(move == 0){
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
            }else if(move == 1){
                temp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
            }else if(move == 2){
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
            }else if(move == 3){
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
            }

            if(map[x][y] == 0){
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            bw.write(dice[0]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}