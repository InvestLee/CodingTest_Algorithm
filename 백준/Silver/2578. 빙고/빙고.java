import java.io.*;
import java.util.*;

//백준 2578 빙고
public class Main {

    public static int[][] board = new int[5][5];
    public static int num, bingo;
    public static int result;
    public static boolean escape;
    public static int[] callNum = new int[25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                callNum[i*5+j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 25; i++){
            result = 0;
            escape = false;
            for(int x = 0; x < 5; x++){
                for(int y = 0; y < 5; y++){
                    if(board[x][y] == callNum[i]){
                        board[x][y] = 0;
                        escape = true;
                        break;
                    }
                }
                if(escape) break;
            }
            bingoCount();
            if(result >= 3){
                bw.write(i+1+"");
                break;
            }
        }
        bw.flush();
        bw.close();
    }

    public static void bingoCount(){
        int cnt;

        for(int i = 0; i < 5; i++){
            cnt = 0;
            for(int j = 0; j < 5; j++){
                if(board[i][j] == 0) cnt++;
            }
            if(cnt == 5) result++;
        }

        for(int i = 0; i < 5; i++){
            cnt = 0;
            for(int j = 0; j < 5; j++){
                if(board[j][i] == 0) cnt++;
            }
            if(cnt == 5) result++;
        }

        cnt = 0;
        for(int i = 0; i < 5; i++){
            if(board[i][i] == 0) cnt++;
        }
        if(cnt == 5) result++;

        cnt = 0;
        for(int i = 0; i < 5; i++){
            if(board[i][4-i] == 0) cnt++;
        }
        if(cnt == 5) result++;
    }
}
