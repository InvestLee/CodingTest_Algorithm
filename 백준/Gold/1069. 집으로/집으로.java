import java.io.*;
import java.util.*;

//백준 1069 집으로
public class Main {
    public static int[] parent;
    public static int[][] camp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        br.close();

        double distance = Math.sqrt(n * n + m * m);
        double walk = distance;
        double jump, jumpAndWalk;
        int jumpCnt;
        if(distance >= d){
            jumpCnt = (int)(distance/d);
            jump = t * (jumpCnt + 1);
            jumpAndWalk = t * jumpCnt + (distance - d * jumpCnt);
        } else {
            jump = t * 2;
            jumpAndWalk = t + (d - distance);
        }

        bw.write(Math.min(walk,Math.min(jump, jumpAndWalk))+"");
        bw.flush();
        bw.close();
    }
}
