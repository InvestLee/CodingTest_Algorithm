import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        int[][] accumulateArr = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                accumulateArr[i][j] = arr[i][j]+accumulateArr[i][j-1]+accumulateArr[i-1][j]-accumulateArr[i-1][j-1];
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(accumulateArr[x2][y2]-accumulateArr[x1-1][y2]-accumulateArr[x2][y1-1]+accumulateArr[x1-1][y1-1]);
        }
    }
}