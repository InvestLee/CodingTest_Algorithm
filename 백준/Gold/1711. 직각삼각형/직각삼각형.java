import java.io.*;
import java.util.*;

//백준 1711 직각삼각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[][] tri = new long[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            tri[i][0] = Long.parseLong(st.nextToken());
            tri[i][1] = Long.parseLong(st.nextToken());
        }

        int result = 0;
        long dist1, dist2, dist3, maxValue;
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    dist1 = (tri[i][0]-tri[j][0])*(tri[i][0]-tri[j][0])+(tri[i][1]-tri[j][1])*(tri[i][1]-tri[j][1]);
                    dist2 = (tri[j][0]-tri[k][0])*(tri[j][0]-tri[k][0])+(tri[j][1]-tri[k][1])*(tri[j][1]-tri[k][1]);
                    dist3 = (tri[k][0]-tri[i][0])*(tri[k][0]-tri[i][0])+(tri[k][1]-tri[i][1])*(tri[k][1]-tri[i][1]);
                    maxValue = Math.max(Math.max(dist1, dist2), dist3);
                    if(2 * maxValue == dist1 + dist2 + dist3) result++;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
