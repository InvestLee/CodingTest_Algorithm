import java.io.*;
import java.util.*;

//백준 17136 색종이 붙이기
public class Main {

    public static int[][] paper = new int[10][10];
    public static int[] piece = {0, 5, 5, 5, 5, 5};
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);
        if(result == Integer.MAX_VALUE) result = -1;

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void attach(int x, int y, int size, int state){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                paper[i][j] = state;
            }
        }
    }

    public static boolean isAttach(int x, int y, int size){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(i < 0 || i >= 10 || j < 0 || j >= 10 || paper[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void dfs(int x, int y, int cnt){
        if(x == 10){
            result = Math.min(result, cnt);
            return;
        }
        if(result <= cnt) return;
        if(y == 10) {
            dfs(x+1, 0, cnt);
            return;
        }

        if(paper[x][y] == 1){
            for(int i = 5; i > 0; i--){
                if(piece[i] > 0 && isAttach(x, y, i)){
                    attach(x, y, i, 0);
                    piece[i]--;
                    dfs(x, y+1, cnt + 1);
                    attach(x, y, i, 1);
                    piece[i]++;
                }
            }
        } else {
            dfs(x,y+1,cnt);
        }
    }

}