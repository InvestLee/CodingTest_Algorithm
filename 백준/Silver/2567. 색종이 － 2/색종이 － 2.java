import java.io.*;
import java.util.*;

//2567 색종이 - 2
public class Main {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] paper = new int[101][101];
        int x, y, nx, ny;
        for(int k = 0; k < n; k++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for(int i = x; i < x+10; i++){
                for(int j = y; j < y+10; j++){
                    paper[i][j] = 1;
                }
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int result = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(paper[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if(paper[nx][ny] == 0
                        || nx < 0 || ny < 0
                        || nx > 100 || ny > 100) result++;
                    }
                }
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}