import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[101][101];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x+10; j++){
                for (int k = y; k < y+10; k++){
                    paper[j][k] = 1;
                }
            }
        }
        br.close();

        //결과값 산출
        int result = 0;
        for (int i = 0; i < 101; i++){
            for (int j = 0; j < 101; j++){
                if (paper[i][j] > 0) result++;
            }
        }
        System.out.print(result);
    }
}