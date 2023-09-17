import java.io.*;
import java.util.*;

//백준 15684 사다리 조작
public class Main {

    public static int n, m, h, r, c, result;
    public static int[][] ladder;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladder = new int[h+1][n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            ladder[r][c] = 1;
            ladder[r][c+1] = 2;
        }

        for(int i = 0; i <= 3; i++){
            result = i;
            addLine(1,0);
            if(flag) break;
        }

        if(!flag) result = -1;
        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean check(){
        int x, y;
        for(int i = 1; i <= n; i++){
            x = 1;
            y = i;
            for(int j = 0; j < h; j++){
                if(ladder[x][y] == 1) y++;
                else if (ladder[x][y] == 2) y--;
                x++;
            }
            if(y != i) return false;
        }
        return true;
    }

    public static void addLine(int x, int cnt){
        if(flag) return;
        if(result == cnt){
            if(check()) flag = true;
            return;
        }

        for(int i = x; i <= h; i++){
            for(int j = 1; j < n; j++){
                if(ladder[i][j] == 0 && ladder[i][j+1] == 0){
                    ladder[i][j] = 1;
                    ladder[i][j+1] = 2;
                    addLine(i,cnt+1);
                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }
    }
}