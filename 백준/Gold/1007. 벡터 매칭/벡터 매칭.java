import java.io.*;
import java.util.*;

//백준 1007 벡터 매칭
public class Main {

    public static int n, totX, totY;
    public static int arr[][];
    public static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            totX = 0;
            totY = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                totX += arr[i][0];
                totY += arr[i][1];
            }
            result = Double.MAX_VALUE;
            dfs(0, 0, totX, totY);
            bw.write(result+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int depth, int prev, int x, int y){
        if(depth == n/2){
            result = Math.min(result, Math.sqrt((double)x*x+(double)y*y));
            return;
        }
        for(int i = prev; i < n; i++){
            dfs(depth+1, i+1, x-2*arr[i][0], y-2*arr[i][1]);
        }
    }
}