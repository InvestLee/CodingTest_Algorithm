import java.io.*;
import java.util.*;

//2304 창고 다각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (o1, o2) -> o1[0] - o2[0]);

        int j, max, result = 0;
        for(int i = 0; i < n;){
            j = i + 1;
            max = j;
            while(j < n && map[i][1] > map[j][1]){
                if(map[max][1] < map[j++][1]) max = j-1;
            }
            if(j >= n){
                result += map[i][1];
                if(max < n) result += map[max][1] * (map[max][0] - map[i][0] -1);
                i = max;
            } else {
                result += map[i][1] * (map[j][0] - map[i][0]);
                i = j;
            }
        }

        bw.write(result+"");
        bw.flush();
    }
}
