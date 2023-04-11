import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int n, m, k;
    public static char[][] board;
    public static String row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for(int i = 0; i < n; i++){
            row = br.readLine();
            for(int j = 0; j < m; j++) board[i][j] = row.charAt(j);
        }
        System.out.println(Math.min(min_color('B'),min_color('W')));
    }

    public static int min_color(char color){
        int[][] pre_sum = new int[n+1][m+1];
        int result = 2000*2000;
        int color_value;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if ((i+j)%2 == 0){
                    if (board[i][j] != color) color_value = 1;
                    else color_value = 0;
                }  else {
                    if (board[i][j] == color) color_value = 1;
                    else color_value = 0;
                }
                pre_sum[i+1][j+1] = pre_sum[i][j+1] + pre_sum[i+1][j] - pre_sum[i][j] + color_value;
            }
        }

        for(int i = 1; i <= n-k+1; i++) {
            for (int j = 1; j <= m-k+1; j++) {
                result = Math.min(result, pre_sum[i+k-1][j+k-1] -  pre_sum[i+k-1][j-1] - pre_sum[i-1][j+k-1] + pre_sum[i-1][j-1]);
            }
        }
        return result;
    }
}
