import java.io.*;
import java.util.StringTokenizer;

//백준 14890 경사로
public class Main {

    public static int n, l, result;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            if(check(i,0,true)) result++;
            if(check(0,i,false)) result++;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean check(int x, int y, boolean flag){
        int[] height = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(flag) height[i] = map[x][i];
            else height[i] = map[i][y];
        }

        int heightDiff;
        for(int i = 0; i < n-1; i++){
            heightDiff = height[i] - height[i+1];
            if(Math.abs(heightDiff) > 1) return false;
            if(heightDiff == 0) continue;
            if(heightDiff == 1){
                for(int j = i+1; j <= i+l; j++){
                    if(!(0 <= j && j < n) || height[i+1] != height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            } else if(heightDiff == -1){
                for(int j = i; j > i-l; j--){
                    if(!(0 <= j && j < n) || height[i] != height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}