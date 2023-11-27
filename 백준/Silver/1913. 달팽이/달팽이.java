import java.io.*;

//백준 1913 달팽이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int x = 0;
        int y = 0;
        int nx, ny;
        int idx = 0;
        int targetX = 0;
        int targetY = 0;
        for(int i = n*n; i > 0; i--){
            if(i == target){
                targetX = x+1;
                targetY = y+1;
            }
            map[x][y] = i;
            nx = x + dx[idx];
            ny = y + dy[idx];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0){
                idx = (idx + 1) % 4;
                nx = x + dx[idx];
                ny = y + dy[idx];
            }
            x = nx;
            y = ny;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.write(targetX+" "+targetY);
        bw.flush();
        br.close();
        bw.close();
    }
}