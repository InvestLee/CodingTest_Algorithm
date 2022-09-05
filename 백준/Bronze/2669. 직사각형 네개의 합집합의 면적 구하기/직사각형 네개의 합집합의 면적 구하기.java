import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rec = new int[4];
        int[][] graph = new int[101][101];
        int result = 0;
        for(int i=0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < 4; j++) {
                rec[j] = Integer.parseInt(st.nextToken());
            }
            //면적 입력
            for(int j = rec[0]; j < rec[2]; j++) {
                for (int k = rec[1]; k < rec[3]; k++) {
                    graph[j][k] = 1;
                }
            }
        }
        for (int i=0; i < 101; i++){
            for (int j=0; j < 101; j++){
                if (graph[i][j] == 1) result += 1;
            }
        }
        System.out.println(result);
        br.close();
    }
}