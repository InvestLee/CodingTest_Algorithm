import java.io.*;
import java.util.*;

//10164 격자상의 경로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(k == 0) k = 1;
        int row = (k-1) / m;
        int col = (k-1) % m;

        int[][] map = new int[n][m];

        for(int i = 0; i <= row; i++){
            map[i][0] = 1;
        }
        for(int j = 0; j <= col; j++){
            map[0][j] = 1;
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        for(int i = row + 1; i < n; i++){
            map[i][col] = map[row][col];
        }
        for(int j = col + 1; j < m; j++){
            map[row][j] = map[row][col];
        }

        for(int i = row+1; i < n; i++){
            for(int j = col+1; j < m; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        bw.write(map[n-1][m-1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}