import java.io.*;
import java.util.*;

//백준 17371 이사
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double temp_distance, max_distance;

        int n = Integer.parseInt(br.readLine());
        int[][] facilities = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            facilities[i][0] = Integer.parseInt(st.nextToken());
            facilities[i][1] = Integer.parseInt(st.nextToken());
        }

        double hx = facilities[0][0];
        double hy = facilities[0][1];
        double answer_distance = Double.MAX_VALUE;
        for(int i = 0; i < n; i++){
            max_distance = 0;
            for(int j = 0; j < n; j++){
                temp_distance = Math.sqrt(Math.pow(facilities[i][0]-facilities[j][0],2)+Math.pow(facilities[i][1]-facilities[j][1],2));
                max_distance = Math.max(max_distance,temp_distance);
            }
            if(answer_distance > max_distance){
                answer_distance = max_distance;
                hx = facilities[i][0];
                hy = facilities[i][1];
            }
        }

        bw.write(hx+" "+hy);
        br.close();
        bw.flush();
        bw.close();
    }
}