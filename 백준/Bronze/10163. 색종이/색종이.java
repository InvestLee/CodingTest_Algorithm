import java.io.*;
import java.util.*;

//백준 10163 색종이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[1001][1001];
        int[] result = new int[n+1];

        StringTokenizer st;
        int x, y, width, height;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            for(int j = x; j < (x+width); j++){
                for(int k = y; k < (y+height); k++){
                    map[j][k] = i;
                }
            }
        }

        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001; j++){
                result[map[i][j]]++;
            }
        }

        for(int i = 1; i <= n; i++) bw.write(result[i]+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}